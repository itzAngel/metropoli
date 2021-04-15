import { Component, OnInit } from '@angular/core';
import { Moneda } from 'src/app/models/moneda';
import { LoginService } from '../../base/login/login.service';
import { MonedaService } from './moneda.service';

@Component({
  selector: 'app-moneda',
  templateUrl: './moneda.component.html',
  styleUrls: ['./moneda.component.css']
})
export class MonedaComponent implements OnInit {

  formAct = false;
  modal = false;
  editar = false;
  arreglo:Moneda[]=[];
  obj:Moneda = new Moneda();
  constructor(public service: MonedaService,public loginservice: LoginService) { }

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
    this.obj=new Moneda();
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
  
  Eliminar(o: Moneda):void{
    this.service.delete(o.idMoneda).subscribe(data=>{
      this.arreglo=this.arreglo.filter(p=>p!==o);
    })
    alert("Se elimino con exito");
  }

}
