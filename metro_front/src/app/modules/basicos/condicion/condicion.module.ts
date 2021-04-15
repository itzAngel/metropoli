import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CondicionRoutingModule } from './condicion-routing.module';
import { CondicionComponent } from './condicion.component';

import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
@NgModule({
  declarations: [CondicionComponent],
  imports: [
    CommonModule,
    CondicionRoutingModule,
    HttpClientModule,
    MaterialModule
  ]
})
export class CondicionModule { }
