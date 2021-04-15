import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Preferencia } from 'src/app/models/preferencia';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PreferenciaService {
  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url=this.urlbase + "/preferencia";

  constructor(private http:HttpClient) { }

  getPreferencias(){
    return this.http.get<Preferencia[]>(this.Url);
  }
  getTiposInmuebles(){
    return this.http.get<Preferencia[]>(this.Url);
  }
  createPreferencia(preferencia: Preferencia){
    return this.http.post<Preferencia>(this.Url,preferencia);
  }
  getPreferenciaId(id: string){
    return this.http.get<Preferencia>(this.Url+"/"+id);
  }
  updatePreferencia(preferencia: Preferencia){
    return this.http.put<Preferencia>(this.Url,preferencia);
  }
  deletePreferencia(id: string){
    return this.http.delete(this.Url + "/" + id);
  }
}
