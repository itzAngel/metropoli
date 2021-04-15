import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Contacto } from 'src/app/models/contacto';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ContactanosService {

  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url=this.urlbase + "/contacto";

  constructor(private http:HttpClient) { }

  get(){
    return this.http.get<Contacto[]>(this.Url);
  }
  create(contacto: Contacto){
    return this.http.post<Contacto>(this.Url,contacto);
  }
  getId(id: string){
    return this.http.get<Contacto>(this.Url+"/"+id);
  }
  update(contacto: Contacto){
    return this.http.put<Contacto>(this.Url,contacto);
  }
  delete(id: string){
    return this.http.delete(this.Url + "/" + id);
  }
}
