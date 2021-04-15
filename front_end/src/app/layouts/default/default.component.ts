import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Agente } from 'src/app/models/agente';
import { LoginService } from 'src/app/modules/base/login/login.service';

@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.css']
})
export class DefaultComponent implements OnInit {
  agente:Agente = new Agente();
  nombre:string = '';
  imagen: string = null;
  sideBarOpen = false;

  constructor(public service: LoginService,public router:Router) { }

  ngOnInit(): void {
    if(this.service.agente!=null){
      this.agente=this.service.agente;
      this.nombre=this.agente.nombre;
    }else{
      this.nombre="";
    }
  }

  Prop(){
    this.router.navigate(["propiedad"]);
  }


  sideBarToggler($event) {
    this.sideBarOpen = !this.sideBarOpen;
  }

}
