import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatDrawer } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/modules/base/login/login.service';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input() deviceXs: boolean;
  @Input() drawer: MatDrawer;
  @Output() toggleSideBarForMe: EventEmitter<any> = new EventEmitter();
  
  constructor(public router:Router,public authService:AuthenticationService, public loginservice: LoginService) { }

  ngOnInit(): void {
  }

}
