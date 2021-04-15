import { Component, OnInit } from '@angular/core';
import { Estado } from 'src/app/models/estado';
import { Moneda } from 'src/app/models/moneda';
import { Preferencia } from 'src/app/models/preferencia';
import { Tipo } from 'src/app/models/tipo';
import { Ubicacion } from 'src/app/models/ubicacion';
import { EstadoService } from 'src/app/modules/basicos/estado/estado.service';
import { TipoService } from 'src/app/modules/basicos/tipo/tipo.service';
import { UbicacionService } from 'src/app/modules/basicos/ubicacion/ubicacion.service';
import { MonedaService } from '../moneda/moneda.service';
import { PreferenciaService } from './preferencia.service';
import * as uuid from 'uuid';
import { LoginService } from '../../base/login/login.service';
@Component({
  selector: 'app-preferencia',
  templateUrl: './preferencia.component.html',
  styleUrls: ['./preferencia.component.css']
})
export class PreferenciaComponent implements OnInit {
  formAct = false;
  modal = false;
  editar = false;
  preferencia:Preferencia = new Preferencia();
  preferencias:Preferencia[]=[];
  tipos:Tipo[]=[];
  estados:Estado[]=[];
  ubicaciones:Ubicacion[]=[];
  monedas:Moneda[]=[];
  constructor(public service: PreferenciaService,public tipoService: TipoService,
    public estadoService: EstadoService,public ubicacionService: UbicacionService,
     public monedaService: MonedaService,public loginservice: LoginService) { }

  ngOnInit(): void {
    this.cargarPreferencias();
    this.cargarCombos();
  }
  cargarCombos(): void{
    this.tipoService.getList().subscribe(data=>{
      this.tipos=data;
    });
    this.estadoService.getList().subscribe(data=>{
      this.estados=data;
    });
    this.ubicacionService.getList().subscribe(data=>{
      this.ubicaciones=data;
    });
    this.monedaService.getList().subscribe(data=>{
      this.monedas=data;
    });
  }
  cargarPreferencias(): void{
    this.service.getPreferencias().subscribe(data=>{
      this.preferencias=data;
    });
  }
  Agregar(){
    this.formAct=true;
    this.preferencia=new Preferencia();
  }
  Regresar(){
    this.formAct=false;
  }

  validar(){
    if(this.preferencia.tipo != null &&
      this.preferencia.estado && this.preferencia.ubicacion && this.preferencia.monedamenor && 
      this.preferencia.monedamayor && this.preferencia.preciomenor && this.preferencia.preciomayor){
          return true;
    }else{
          return false;
    }
  }

  Guardar(){
    if (this.validar()) {
      this.preferencia.idPreferencia=uuid().replace(/-/g, '');
      this.service.createPreferencia(this.preferencia).subscribe(data=>{
        alert("Se agrego con exito");
      });
      this.formAct=false;
      location.reload();
    }
    else{
      alert("Llena todos los campos");
    }
  }

  Editar(id: string){
    this.preferencias.forEach(p => {
      if(p.idPreferencia==id){
        this.preferencia=p;
      }
    });
    this.service.getPreferenciaId(id).subscribe(data=>{
      this.preferencia=data;
    });
    this.formAct=true;
    this.editar=true;
  }

  Actualizar(){
    this.service.updatePreferencia(this.preferencia).subscribe(data=>{
      alert("Se actualizo con exito");
    });
    location.reload();
  }
  
  Eliminar(preferencia: Preferencia):void{
    this.service.deletePreferencia(preferencia.idPreferencia).subscribe(data=>{
      this.preferencias=this.preferencias.filter(p=>p!==preferencia);
    })
    alert("Se elimino con exito");
  }

}
