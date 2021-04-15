import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { LogoutComponent } from './auth/logout/logout.component';
import { DefaultComponent } from './layouts/default/default.component';
import { HomeComponent } from './modules/base/home/home.component';
import { ServiciosComponent } from './page/servicios/servicios.component';
import { AuthGaurdService } from './service/auth-gaurd.service';
import { SliderComponent } from './shared/components/slider/slider.component';


const routes: Routes = [
  {
    path: '',
    component: DefaultComponent,
    children: [
      {path: '',component: HomeComponent},
      {path: 'home',component: HomeComponent},
      /*
      { path: 'imagen', loadChildren: () => import('./modules/media/imagen/imagen.module').then(m => m.ImagenModule),canActivate:[AuthGaurdService] }, 
      { path: 'multimedia', loadChildren: () => import('./modules/media/multimedia/multimedia.module').then(m => m.MultimediaModule),canActivate:[AuthGaurdService] },
      { path: 'documento', loadChildren: () => import('./modules/media/documento/documento.module').then(m => m.DocumentoModule),canActivate:[AuthGaurdService] },
      { path: 'preferencia', loadChildren: () => import('./modules/otros/preferencia/preferencia.module').then(m => m.PreferenciaModule),canActivate:[AuthGaurdService] },
      { path: 'agencia', loadChildren: () => import('./modules/basicos/agencia/agencia.module').then(m => m.AgenciaModule),canActivate:[AuthGaurdService] },
      { path: 'tipo', loadChildren: () => import('./modules/basicos/tipo/tipo.module').then(m => m.TipoModule),canActivate:[AuthGaurdService] },
      { path: 'ubicacion', loadChildren: () => import('./modules/basicos/ubicacion/ubicacion.module').then(m => m.UbicacionModule),canActivate:[AuthGaurdService] },
      { path: 'estado', loadChildren: () => import('./modules/basicos/estado/estado.module').then(m => m.EstadoModule),canActivate:[AuthGaurdService] },
      { path: 'condicion', loadChildren: () => import('./modules/basicos/condicion/condicion.module').then(m => m.CondicionModule),canActivate:[AuthGaurdService] },
      { path: 'moneda', loadChildren: () => import('./modules/otros/moneda/moneda.module').then(m => m.MonedaModule),canActivate:[AuthGaurdService] },
      
      { path: 'login', loadChildren: () => import('./modules/base/login/login.module').then(m => m.LoginModule),canActivate:[AuthGaurdService] },
      */
      { path: 'home', loadChildren: () => import('./modules/base/home/home.module').then(m => m.HomeModule) },
      { path: 'agente', loadChildren: () => import('./modules/usuarios/agente/agente.module').then(m => m.AgenteModule),canActivate:[AuthGaurdService] },
      { path: 'cliente', loadChildren: () => import('./modules/usuarios/cliente/cliente.module').then(m => m.ClienteModule),canActivate:[AuthGaurdService] },
      { path: 'propiedad', loadChildren: () => import('./modules/inmueble/propiedad/propiedad.module').then(m => m.PropiedadModule) },
      { path: 'contactanos', loadChildren: () => import('./page/contactanos/contactanos.module').then(m => m.ContactanosModule) },
      { path: 'default', loadChildren: () => import('./layouts/default/default.module').then(m => m.DefaultModule) },
      { path: 'servicios', loadChildren: () => import('./page/servicios/servicios.module').then(m => m.ServiciosModule) },
    ]
  },
  { path: 'login', component: LoginComponent },
  { path: 'slider', component: SliderComponent },
  { path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdService] },
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
