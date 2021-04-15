import { Component, OnInit } from '@angular/core';
import { Ubicacion } from 'src/app/models/ubicacion';
import { LoginService } from '../../base/login/login.service';
import { UbicacionService } from './ubicacion.service';

@Component({
  selector: 'app-ubicacion',
  templateUrl: './ubicacion.component.html',
  styleUrls: ['./ubicacion.component.css']
})
export class UbicacionComponent implements OnInit {

  formAct = false;
  modal = false;
  editar = false;
  arreglo:Ubicacion[]=[];
  obj:Ubicacion = new Ubicacion();
  constructor(public service: UbicacionService,public loginservice: LoginService) { }

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
    this.obj=new Ubicacion();
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
  
  Eliminar(o: Ubicacion):void{
    this.service.delete(o.idUbicacion).subscribe(data=>{
      this.arreglo=this.arreglo.filter(p=>p!==o);
    })
    alert("Se elimino con exito");
  }

}
