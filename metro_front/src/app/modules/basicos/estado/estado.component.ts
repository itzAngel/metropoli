import { Component, OnInit } from '@angular/core';
import { Estado } from 'src/app/models/estado';
import { LoginService } from '../../base/login/login.service';
import { EstadoService } from './estado.service';

@Component({
  selector: 'app-estado',
  templateUrl: './estado.component.html',
  styleUrls: ['./estado.component.css']
})
export class EstadoComponent implements OnInit {

  formAct = false;
  modal = false;
  editar = false;
  arreglo:Estado[]=[];
  obj:Estado = new Estado();
  constructor(public service: EstadoService,public loginservice: LoginService) { }

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
    this.obj=new Estado();
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
  
  Eliminar(o: Estado):void{
    this.service.delete(o.idEstado).subscribe(data=>{
      this.arreglo=this.arreglo.filter(p=>p!==o);
    })
    alert("Se elimino con exito");
  }

}
