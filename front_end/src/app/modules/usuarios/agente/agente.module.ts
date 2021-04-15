import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgenteRoutingModule } from './agente-routing.module';
import { AgenteComponent } from './agente.component';

import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { PaginateModule } from 'src/app/pipes/paginate/paginate.module';
@NgModule({
  declarations: [AgenteComponent],
  imports: [
    CommonModule,
    AgenteRoutingModule,
    HttpClientModule,
    MaterialModule,
    PaginateModule
  ]
})
export class AgenteModule { }
