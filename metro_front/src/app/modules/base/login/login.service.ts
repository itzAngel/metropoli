import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Agente } from 'src/app/models/agente';
import { AgenteService } from 'src/app/modules/usuarios/agente/agente.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  agente:Agente = new Agente();
  logged:boolean = false;
  constructor(public service:AgenteService) { }

  login(correo:string, contrasena:string){
    this.service.login(correo,contrasena).subscribe(data=>{
      this.agente=data;
      this.logged=true;
      console.log(this.agente);
    });
  }
  logOut(){
    this.agente=new Agente();
    this.logged=false;
  }
}
