import { Component, OnInit,ViewChild, ElementRef } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { Imagen } from 'src/app/models/imagen';
import { ImagenService } from 'src/app/modules/media/imagen/imagen.service';
import { LoginService } from '../../base/login/login.service';
import * as uuid from 'uuid';
@Component({
  selector: 'app-imagen',
  templateUrl: './imagen.component.html',
  styleUrls: ['./imagen.component.css']
})
export class ImagenComponent implements OnInit {

  @ViewChild('imagenInputFile', {static: false}) imagenFile: ElementRef;
  formAct = false;
  imagen: File;
  imagenMin: File;
  imagenes: Imagen[] = [];
  isProgrress=false;
  myId:string;
  constructor(private imagenService: ImagenService, private spinner: NgxSpinnerService,public loginservice:LoginService) {
  }

  ngOnInit() {
    this.cargarImagenes();
  }
  Agregar(){
    this.formAct=true;
  }
  Regresar(){
    this.formAct=false;
  }
  cargarImagenes(): void {
    this.imagenService.list().subscribe(
      data => {
        this.imagenes = data;
      }
    );
  }

  borrar(id: string): void {
    this.isProgrress=true;
    this.imagenService.delete(id).subscribe(
      data => {
        this.isProgrress=false;
        this.cargarImagenes();
      },
      err => {
        this.spinner.hide();
        console.log(err);
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

  onUpload(): void {
    this.isProgrress=true;
    this.myId = uuid().replace(/-/g, '');
    this.imagenService.upload(this.imagen,this.myId).subscribe(
      data => {
        this.isProgrress=false;
        this.formAct=false;
        this.cargarImagenes();
        this.reset();
      },
      err => {
        alert(err.error.mensaje);
        this.isProgrress=false;
        this.reset();
      }
    );
  }

  reset(): void {
    this.imagen = null;
    this.imagenMin = null;
    this.imagenFile.nativeElement.value = '';
  }


}
