import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgenciaRoutingModule } from './agencia-routing.module';
import { AgenciaComponent } from './agencia.component';

import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
@NgModule({
  declarations: [AgenciaComponent],
  imports: [
    CommonModule,
    AgenciaRoutingModule,
    HttpClientModule,
    MaterialModule
  ]
})
export class AgenciaModule { }
