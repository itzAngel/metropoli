import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { PropiedadRoutingModule } from './propiedad-routing.module';
import { PropiedadComponent } from './propiedad.component';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { DetalleFotosPropiedadComponent } from './detalle-fotos-propiedad/detalle-fotos-propiedad.component';
import { PaginateModule } from 'src/app/pipes/paginate/paginate.module';

@NgModule({
  declarations: [PropiedadComponent, DetalleFotosPropiedadComponent],
  imports: [
    CommonModule,
    PropiedadRoutingModule,
    HttpClientModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
    SharedModule,
    PaginateModule
  ]
})
export class PropiedadModule { }
