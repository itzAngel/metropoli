import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { DetalleFotosPropiedad } from 'src/app/models/detalle-fotos-propiedad';
import * as uuid from 'uuid';
import { Imagen } from 'src/app/models/imagen';
import { Propiedad } from 'src/app/models/propiedad';
import { ImagenService } from 'src/app/modules/media/imagen/imagen.service';
import { PropiedadService } from '../propiedad.service';
import { DetalleFotosPropiedadService } from './detalle-fotos-propiedad.service';
import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-detalle-fotos-propiedad',
  templateUrl: './detalle-fotos-propiedad.component.html',
  styleUrls: ['./detalle-fotos-propiedad.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class DetalleFotosPropiedadComponent implements OnInit {

  @Input() idPropiedad: string;
  formAct = false;
  editar = false;
  isProgress=false;
  detalles:DetalleFotosPropiedad[]=[];
  detalle:DetalleFotosPropiedad = new DetalleFotosPropiedad();
  @ViewChild('imagenInputFile', {static: false}) imagenFile: ElementRef;
  imagen: File;
  image: Imagen = new Imagen();
  imagenMin: Imagen = new Imagen();
  imagenes: Imagen[] = [];
  myId:string = null;
  fotoId: string = null;
  propiedades:Propiedad[]=[];
  constructor(private imagenService: ImagenService,public service: DetalleFotosPropiedadService, 
    public propiedadService: PropiedadService,private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.cargarDatos();
  }
  openSnackBar(mensaje:string) {
    this._snackBar.open(mensaje, 'OK', {
      duration: 1000,
      horizontalPosition: "center",
      verticalPosition: "top",
    });
  }
  cargarDatos(){
    this.cargarDetalles();
    this.cargarPropiedades();
    this.cargarImagenes();
  }
  cargarPropiedades(): void{
    this.propiedadService.getList().subscribe(data=>{
      this.propiedades=data;
    });
  }
  cargarDetalles(): void{
    this.service.getListxProp(this.idPropiedad).subscribe(data=>{
      this.detalles=data;
    });
  }
  cargarImagenes(): void {
    this.imagenService.list().subscribe(
      data => {
        this.imagenes = data;
      }
    );
  }
  Agregar(){
    this.formAct=true;
    this.editar=false;
    this.detalle = new DetalleFotosPropiedad();
  }
  Regresar(){
    this.formAct=false;
  }

  validar(){
    if(this.fotoId == null){
      return false;
    }else{
      return true;
    }
  }

  setearCombos(){
    this.propiedades.forEach(obj => {
      if(obj.idPropiedad==this.detalle.propiedad.idPropiedad){
        this.detalle.propiedad=obj;
      }
    }); 
  }

  Guardar(){
    if (this.validar()) {
      this.imagenes.forEach(i => {
        if(i.id==this.fotoId){
          this.detalle.foto = i.imagenurl;//asigna foto
        }
      });
      this.detalle.idDetalleFotosPropiedad = this.myId = uuid().replace(/-/g, '');
      this.detalle.propiedad.idPropiedad = this.idPropiedad;
      this.setearCombos();
      this.service.create(this.detalle).subscribe(data=>{
        this.openSnackBar("Foto se agrego con exito");
      });
      this.formAct=false;
      this.cargarDatos();
    }
    else{
      this.openSnackBar("Elija una imagen");
    }
  }

  Editar(det: DetalleFotosPropiedad){
    this.detalle=det;
    this.formAct=true;
    this.editar=true;
  }

  Actualizar(){
    this.imagenes.forEach(i => {
      if(i.id==this.myId){
        this.detalle.foto = i.imagenurl;//asigna foto
      }
    });
    this.idPropiedad=this.detalle.propiedad.idPropiedad;
    this.setearCombos();
    this.service.update(this.detalle).subscribe(data=>{
      this.openSnackBar("Foto se agrego con exito");
    });
  }
  
  Eliminar(detalle: DetalleFotosPropiedad):void{
    this.service.delete(detalle.idDetalleFotosPropiedad).subscribe(data=>{
      this.detalles=this.detalles.filter(p=>p!==detalle);
    })
    this.openSnackBar("Foto se elimino con exito");
  }

  /*funciones crud externas*/
    
  onUpload(): void {
    this.isProgress = true;
    this.fotoId = uuid().replace(/-/g, '');//crea id de foto
    this.imagenService.upload(this.imagen,this.fotoId).subscribe(
      data => {
        this.cargarImagenes();
        this.cargarDatos();
        this.reset();
        this.isProgress = false;
      },
      err => {
        this.openSnackBar(err.error.mensaje);
        this.reset();
      }
    );
  }
  onFileChange(event) {
    this.imagen = event.target.files[0];
    const fr = new FileReader();
    fr.onload = (evento: any) => {
      this.imagenMin = evento.target.result;
    };
    fr.readAsDataURL(this.imagen);
  }
  
  reset(): void {
    this.imagen = null;
    this.imagenMin = null;
  }

}
