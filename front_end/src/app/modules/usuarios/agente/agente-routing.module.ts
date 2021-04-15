import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AgenteComponent } from './agente.component';

const routes: Routes = [{ path: '', component: AgenteComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AgenteRoutingModule { }
