import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PreferenciaComponent } from './preferencia.component';

const routes: Routes = [{ path: '', component: PreferenciaComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PreferenciaRoutingModule { }
