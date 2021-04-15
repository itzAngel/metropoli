import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PreferenciaRoutingModule } from './preferencia-routing.module';
import { PreferenciaComponent } from './preferencia.component';

import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
@NgModule({
  declarations: [PreferenciaComponent],
  imports: [
    CommonModule,
    PreferenciaRoutingModule,
    HttpClientModule,
    MaterialModule
  ]
})
export class PreferenciaModule { }
