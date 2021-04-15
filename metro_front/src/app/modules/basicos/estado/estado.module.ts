import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EstadoRoutingModule } from './estado-routing.module';
import { EstadoComponent } from './estado.component';

import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
@NgModule({
  declarations: [EstadoComponent],
  imports: [
    CommonModule,
    EstadoRoutingModule,
    HttpClientModule,
    MaterialModule
  ]
})
export class EstadoModule { }
