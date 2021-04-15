import { Component, OnInit } from '@angular/core';
import { Tipo } from 'src/app/models/tipo';
import { LoginService } from '../../base/login/login.service';
import { TipoService } from './tipo.service';

@Component({
  selector: 'app-tipo',
  templateUrl: './tipo.component.html',
  styleUrls: ['./tipo.component.css']
})
export class TipoComponent implements OnInit {

  formAct = false;
  modal = false;
  editar = false;
  arreglo:Tipo[]=[];
  obj:Tipo = new Tipo();
  constructor(public service: TipoService,public loginservice: LoginService) { }

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
    this.obj=new Tipo();
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
  
  Eliminar(o: Tipo):void{
    this.service.delete(o.idTipo).subscribe(data=>{
      this.arreglo=this.arreglo.filter(p=>p!==o);
    })
    alert("Se elimino con exito");
  }

}
