import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TipoRoutingModule } from './tipo-routing.module';
import { TipoComponent } from './tipo.component';

import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
@NgModule({
  declarations: [TipoComponent],
  imports: [
    CommonModule,
    TipoRoutingModule,
    HttpClientModule,
    MaterialModule
  ]
})
export class TipoModule { }
