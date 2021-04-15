import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PropiedadComponent } from './propiedad.component';

const routes: Routes = [{ path: '', component: PropiedadComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PropiedadRoutingModule { }
