import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";
import { CoreEnvironment } from "@angular/compiler/src/compiler_facade_interface";
import { environment } from "src/environments/environment";
import { AgenteService } from "../modules/usuarios/agente/agente.service";
import { Agente } from "../models/agente";
import { LoginService } from "../modules/base/login/login.service";

export class User {
  constructor(public status: string) {}
}

@Injectable({
  providedIn: "root"
})
export class AuthenticationService {
  constructor(private httpClient: HttpClient, public agenteservice: AgenteService, public loginservice: LoginService) {}
// Provide username and password for authentication, and once authentication is successful, 
//store JWT token in session
  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url= this.urlbase + "/authenticate";

  cargarSesionAgente(username:string): void {
    this.agenteservice.getAgentes().subscribe(data => {
      var agentes: Agente[] = data;
      agentes.forEach(element => {
        if (element.correo == username) {
          this.loginservice.agente = element;
        }
      });
    });
  }

  authenticate(username, password) {
    return this.httpClient
      .post<any>(this.Url, { username, password })
      .pipe(
        map(userData => {
          sessionStorage.setItem("username", username);
          let tokenStr = "Bearer " + userData.token;
          sessionStorage.setItem("token", tokenStr);
          return userData;
        })
      );
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("username");
    if(user!=null){
      this.cargarSesionAgente(user);
    }
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem("username");
  }
}
