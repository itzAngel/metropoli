import { Component, OnInit } from '@angular/core';
import { Agente } from 'src/app/models/agente';
import { LoginService } from 'src/app/modules/base/login/login.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  constructor(public service: LoginService) { }

  ngOnInit(): void {
  }

}
