import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UbicacionRoutingModule } from './ubicacion-routing.module';
import { UbicacionComponent } from './ubicacion.component';

import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
@NgModule({
  declarations: [UbicacionComponent],
  imports: [
    CommonModule,
    UbicacionRoutingModule,
    HttpClientModule,
    MaterialModule
  ]
})
export class UbicacionModule { }
