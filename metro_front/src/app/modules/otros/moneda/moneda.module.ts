import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MonedaRoutingModule } from './moneda-routing.module';
import { MonedaComponent } from './moneda.component';

import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
@NgModule({
  declarations: [MonedaComponent],
  imports: [
    CommonModule,
    MonedaRoutingModule,
    HttpClientModule,
    MaterialModule
  ]
})
export class MonedaModule { }
