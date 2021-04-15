import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MonedaComponent } from './moneda.component';

const routes: Routes = [{ path: '', component: MonedaComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MonedaRoutingModule { }
