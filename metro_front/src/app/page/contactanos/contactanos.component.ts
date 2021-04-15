import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Contacto } from 'src/app/models/contacto';
import * as uuid from 'uuid';
import { LoginService } from '../../modules/base/login/login.service';
import { ContactanosService } from './contactanos.service';
@Component({
  selector: 'app-contactanos',
  templateUrl: './contactanos.component.html',
  styleUrls: ['./contactanos.component.css']
})
export class ContactanosComponent implements OnInit {
  /*banderas*/
  formAct = false;
  modal = false;
  editar = false;
  /*objetos*/
  contacto:Contacto = new Contacto();
  variableMuestra: string = null;
  /*arreglos vacios*/
  contactos:Contacto[] = [];
  contactosTemp:Contacto[] = [];
  arreglo: string[] = ['habilitado','no'];
  constructor(public service: ContactanosService,public router:Router,private _snackBar: MatSnackBar,
    public loginservice: LoginService) { }

  ngOnInit(): void {
    this.cargarContactos();
  }
  cargarContactos(){
    this.variableMuestra="todos";
    this.contactos = [];
    this.service.get().subscribe(data=>{
      this.contactosTemp=data;
      this.contactosTemp.forEach(element => {
        if(element.habilitado=='habilitado'){
          this.contactos.push(element);
        }
      });
    });
  }
  Mostrar(){
    if(this.variableMuestra=="todos"){ //va a cambiar a solo habilitados
      this.variableMuestra="habilitados"; 
      this.contactos = [];
      this.service.get().subscribe(data=>{
        this.contactos=data;
      });
    }else{  //va a cambiar a todos
      this.cargarContactos();
    }
  }
  cambiarEstado(contacto:Contacto){
    if(contacto.habilitado == 'habilitado'){
      contacto.habilitado = 'no';
    }else{
      contacto.habilitado = 'habilitado';
    }
    this.service.update(contacto).subscribe(data=>{
      this.openSnackBar("Formulario se actualizo con exito");
      this.cargarContactos();
      this.Regresar();
    });
  }
  openSnackBar(mensaje:string) {
    this._snackBar.open(mensaje, 'OK', {
      duration: 1000,
      horizontalPosition: "center",
      verticalPosition: "top",
    });
  }
  /*funciones de cambio con banderas*/
  Agregar(){
    this.formAct=true;
    this.editar=false;
    this.contacto=new Contacto();
  }
  Regresar(){
    this.formAct=false;
  }
  /*funciones de validacion*/
  validar(){
    if(this.contacto.nombre != null && this.contacto.celular != null && 
      this.contacto.correo != null && this.contacto.mensaje != null){
        return true;
    }else{
        return false;
    }
  }
  
  /*funciones crud*/
  limpiar(){
    this.contacto = new Contacto();
  }

  Guardar(){
    if (this.validar()) {
        this.contacto.idContacto=uuid().replace(/-/g, '');//asigna id cliente
        this.contacto.habilitado="habilitado";
        this.service.create(this.contacto).subscribe(data=>{
          this.openSnackBar("Su formulario se agrego con exito");
          this.formAct=false;
          this.cargarContactos();
        });
    }else{
      this.openSnackBar("Llena todos los campos del formulario");
    }
  }
  EnviarForm(){
    if (this.validar()) {
      this.contacto.idContacto=uuid().replace(/-/g, '');//asigna id cliente
      this.service.create(this.contacto).subscribe(data=>{
        this.openSnackBar("Su formulario se agrego con exito");
        this.formAct=false;
        this.cargarContactos();
        this.contacto = new Contacto();
      });
    }else{
      this.openSnackBar("Llena todos los campos del formulario");
    }
  }

  Editar(contacto: Contacto){
    this.contacto = contacto;
    this.formAct=true;
    this.editar=true;
  }

  Actualizar(){
    if (this.validar()) {
        this.service.update(this.contacto).subscribe(data=>{
          this.openSnackBar("Formulario se actualizo con exito");
          this.cargarContactos();
          this.Regresar();
        });
    }else{
      this.openSnackBar("Llena todos los campos del formulario");
    }
  }
  
  Eliminar(contacto: Contacto):void{
    this.service.delete(contacto.idContacto).subscribe(data=>{
      this.contactos=this.contactos.filter(p=>p!==contacto);
    });
    this.openSnackBar("Formulario se elimino con exito");
    this.Regresar();
    this.cargarContactos();
  }

  home(){
    this.router.navigate(["home"]);
  }
}
