import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Agente } from 'src/app/models/agente';
import { Imagen } from 'src/app/models/imagen';
import { ImagenService } from 'src/app/modules/media/imagen/imagen.service';
import { AgenteService } from './agente.service';
import * as uuid from 'uuid';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from '../../base/login/login.service';
import { PageEvent } from '@angular/material/paginator';
interface Permiso {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-agente',
  templateUrl: './agente.component.html',
  styleUrls: ['./agente.component.css']
})
export class AgenteComponent implements OnInit {
  formAct = false;
  modal = false;
  editar = false;
  isProgress = false;
  mostrarFoto = true;
  agentes:Agente[]=[];
  agente:Agente = new Agente();
  @ViewChild('imagenInputFile', {static: false}) imagenFile: ElementRef;
  imagen: File;
  image: Imagen = new Imagen();
  imagenMin: Imagen;
  imagenes: Imagen[] = [];
  permisos: Permiso[] = [
    {value: 'administrador', viewValue: 'Administrador'},
    {value: 'usuario', viewValue: 'Usuario'}
  ];
  myId:string;
  fotoId:string;
  /*paginacion*/
  page_size: number = 10;
  page_number: number = 1;
  constructor(public dialog: MatDialog,private imagenService: ImagenService,public agenteService: AgenteService,
    private _snackBar: MatSnackBar,public loginservice: LoginService) { }

  ngOnInit(): void {
    this.cargarAgentes();
    this.cargarImagenes();
    
  }
  openSnackBar(mensaje:string) {
    this._snackBar.open(mensaje, 'OK', {
      duration: 1000,
      horizontalPosition: "center",
      verticalPosition: "top",
    });
  }

  cargarAgentes(): void{
    this.agenteService.getAgentes().subscribe(data=>{
      this.agentes=data;
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
    this.mostrarFoto = true;
    this.agente=new Agente();
  }
  Regresar(){
    this.formAct=false;
  }
  handlePage(e:PageEvent){
    this.page_size=e.pageSize;
    this.page_number=e.pageIndex + 1;
  }
  validar(){
    if(this.agente.correo != null  && this.agente.contrasena != null && this.agente.nombre != null && 
      this.agente.apellido != null){
      return true;
    }else{
      return false;
    }
  }
  validarFoto(){
    if(this.agente.imagen == null && this.fotoId == null){
      this.agente.imagen = "d79a952eae8e46659d6581e24c848fc4";
    }else if(this.fotoId != null){
      this.imagenes.forEach(i => {
        if(i.id==this.fotoId){
          this.agente.imagen = i.imagenurl;
        }
      });
    }
    this.fotoId=null;
  }
  Guardar(){
    if (this.validar()) {
        this.validarFoto();
        this.agente.idAgente = this.myId = uuid().replace(/-/g, '');
        this.agenteService.createAgente(this.agente).subscribe(data=>{
          this.openSnackBar("Agente se agrego con exito");
          this.formAct=false;
          this.cargarAgentes();
        });
    }else{
      this.openSnackBar("Llena todos los campos del agente");
    }
  }

  Editar(id: string){
    this.agenteService.getAgenteId(id).subscribe(data=>{
      this.agente=data;
    });
    this.formAct=true;
    this.editar=true;
    this.mostrarFoto = true;
  }

  Actualizar(){
    if(this.validar()){
      this.validarFoto();
      this.agenteService.updateAgente(this.agente).subscribe(data=>{
        this.openSnackBar("Agente se actualizo con exito");
      });
    }else{
      this.openSnackBar("Llena todos los campos del agente");
    }
    
  }
  
  Eliminar(agente: Agente):void{
    this.agenteService.deleteAgente(agente.idAgente).subscribe(data=>{
      this.agentes=this.agentes.filter(p=>p!==agente);
    })
    alert("Se elimino con exito");
  }

  onUpload(): void {
    this.isProgress = true;
    this.fotoId = uuid().replace(/-/g, '');
    this.imagenService.upload(this.imagen,this.fotoId).subscribe(
      data => {
        this.cargarImagenes();
        this.reset();
        this.mostrarFoto=false;
        this.isProgress = false;
      },
      err => {
        alert(err.error.mensaje);
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
