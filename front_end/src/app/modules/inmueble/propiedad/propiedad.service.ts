import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Estado } from 'src/app/models/estado';
import { Propiedad } from 'src/app/models/propiedad';
import { Tipo } from 'src/app/models/tipo';
import { Ubicacion } from 'src/app/models/ubicacion';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PropiedadService {
  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  busquedaBarra: boolean = false;
  estadoBarra: Estado[]= null;
  ubicacionBarra: Ubicacion[]= null;
  tipoBarra: Tipo[] = null;
  Url=this.urlbase + "/propiedad";

  constructor(private http:HttpClient) { }

  getList(){
    return this.http.get<Propiedad[]>(this.Url+"/listar");
  }
  create(obj: Propiedad){
    return this.http.post<Propiedad>(this.Url,obj);
  }
  getId(id: string){
    return this.http.get<Propiedad>(this.Url+"/listarid"+id);
  }
  update(obj: Propiedad){
    return this.http.put<Propiedad>(this.Url,obj);
  }
  delete(id: string){
    return this.http.delete(this.Url + "/" + id);
  }
  count(){
    return this.http.get<number>(this.Url+"/contar");
  }
}
