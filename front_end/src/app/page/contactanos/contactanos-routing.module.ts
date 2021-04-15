import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ContactanosComponent } from './contactanos.component';

const routes: Routes = [{ path: '', component: ContactanosComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContactanosRoutingModule { }
