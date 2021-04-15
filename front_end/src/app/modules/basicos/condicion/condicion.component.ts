import { Component, OnInit } from '@angular/core';
import { Condicion } from 'src/app/models/condicion';
import { LoginService } from '../../base/login/login.service';
import { CondicionService } from './condicion.service';

@Component({
  selector: 'app-condicion',
  templateUrl: './condicion.component.html',
  styleUrls: ['./condicion.component.css']
})
export class CondicionComponent implements OnInit {

  formAct = false;
  modal = false;
  editar = false;
  arreglo:Condicion[]=[];
  obj:Condicion = new Condicion();
  constructor(public service: CondicionService,public loginservice: LoginService) { }

  ngOnInit(): void {
    this.cargarDatos();
  }

  cargarDatos(): void{
    this.service.getList().subscribe(data=>{
      this.arreglo=data;
    });
  }
  Agregar(){
    this.formAct=true;
    this.obj=new Condicion();
  }
  Regresar(){
    this.formAct=false;
  }

  validar(){
      return true;
  }

  Guardar(){
    if (this.validar()) {
      console.log(this.obj);
      this.service.create(this.obj).subscribe(data=>{
        alert("Se agrego con exito");
      });
      this.formAct=false;
      this.cargarDatos();
      location.reload();
    }
    else{
      alert("Llena todos los campos");
    }
  }

  Editar(id: string){
    this.service.getId(id).subscribe(data=>{
      this.obj=data;
    });
    this.formAct=true;
    this.editar=true;
  }

  Actualizar(){
    this.service.update(this.obj).subscribe(data=>{
      alert("Se actualizo con exito");
    });
    location.reload();
  }
  
  Eliminar(o: Condicion):void{
    this.service.delete(o.idCondicion).subscribe(data=>{
      this.arreglo=this.arreglo.filter(p=>p!==o);
    })
    alert("Se elimino con exito");
  }

}
