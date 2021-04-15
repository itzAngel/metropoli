import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContactanosRoutingModule } from './contactanos-routing.module';
import { ContactanosComponent } from './contactanos.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
@NgModule({
  declarations: [ContactanosComponent],
  imports: [
    CommonModule,
    ContactanosRoutingModule,
    HttpClientModule,
    MaterialModule,
    SharedModule
  ]
})
export class ContactanosModule { }
