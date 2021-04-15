import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ImagenRoutingModule } from './imagen-routing.module';
import { ImagenComponent } from './imagen.component';

import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
@NgModule({
  declarations: [ImagenComponent],
  imports: [
    CommonModule,
    ImagenRoutingModule,
    MaterialModule,
    HttpClientModule
  ]
})
export class ImagenModule { }
