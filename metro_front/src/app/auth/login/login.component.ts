import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Agente } from 'src/app/models/agente';
import { LoginService } from 'src/app/modules/base/login/login.service';
import { AgenteService } from 'src/app/modules/usuarios/agente/agente.service';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false

  @Input() error: string | null;

  constructor(private router: Router,
    private serviceauth: AuthenticationService, public loginservice: LoginService, public agenteservice: AgenteService) { }

  ngOnInit() {
  }

  cargarSesionAgente(): void {
    this.agenteservice.getAgentes().subscribe(data => {
      var agentes: Agente[] = data;
      console.log(agentes);
      agentes.forEach(element => {
        if (element.correo == this.username) {
          this.loginservice.agente = element;
        }
      });
      console.log(this.loginservice.agente);
    });
  }

  checkLogin() {
    (this.serviceauth.authenticate(this.username, this.password).subscribe(
      data => {
        this.router.navigate([''])
        this.invalidLogin = false
        this.cargarSesionAgente()
      },
      error => {
        this.invalidLogin = true
        this.error = error.message;

      }
    )
    );

  }
}
