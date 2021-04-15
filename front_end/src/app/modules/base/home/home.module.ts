import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { PaginateModule } from 'src/app/pipes/paginate/paginate.module';
import { IvyCarouselModule } from 'angular-responsive-carousel';
import { PageModule } from 'src/app/page/page.module';
@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,
    HttpClientModule,
    MaterialModule,
    SharedModule,
    PaginateModule,
    IvyCarouselModule,
    PageModule
  ]
})
export class HomeModule { }
