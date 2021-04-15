import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Agente } from 'src/app/models/agente';
import { AgenteService } from 'src/app/modules/usuarios/agente/agente.service';
import { LoginService } from './login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(public service:LoginService, public router: Router, public agenteService:AgenteService,private _snackBar: MatSnackBar) { }
  agente: Agente = new Agente();
  correo: string='';
  contra: string='';
  agentes:Agente[]=[];
  log:boolean;
  isLoginOK: boolean=false;
  usu:String;
  pass:String;
  ngOnInit(): void {
    this.cargarAgentes();
  }
  hide = true;
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required]),
  });
  cargarAgentes(): void{
    this.agenteService.getAgentes().subscribe(data=>{
      this.agentes=data;
    });
  }
  openSnackBar(mensaje:string) {
    this._snackBar.open(mensaje, 'OK', {
      duration: 1000,
      horizontalPosition: "center",
      verticalPosition: "top",
    });
  }
  IniciarSesion():void{
    for (let usuario of this.agentes) {
      if (usuario.correo == this.usu) {
        if (usuario.contrasena == this.pass) {
          this.isLoginOK=true;
          this.service.logged=true;
          this.service.agente=usuario;
          this.openSnackBar("Inicio sesion con exito");
          this.router.navigate(["home"]);
          break;
        }else{
          this.openSnackBar("Usuario o contraseña incorrectos");
        };
      };
    };
  }
  CerrarSesion():void{
    this.isLoginOK=false;
  }
}
