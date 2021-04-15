import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MultimediaRoutingModule } from './multimedia-routing.module';
import { MultimediaComponent } from './multimedia.component';

import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
@NgModule({
  declarations: [MultimediaComponent],
  imports: [
    CommonModule,
    MultimediaRoutingModule,
    HttpClientModule,
    MaterialModule
  ]
})
export class MultimediaModule { }
