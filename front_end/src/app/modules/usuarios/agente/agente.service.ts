import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Agente } from 'src/app/models/agente';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AgenteService {
  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url=this.urlbase + "/agente";

  constructor(private http:HttpClient) { }

  getAgentes(){
    return this.http.get<Agente[]>(this.Url);
  }
  login(correo:string,contra:string){
    return this.http.get<Agente>(this.Url+"/"+correo+"/"+contra);
  }
  createAgente(agente: Agente){
    return this.http.post<Agente>(this.Url,agente);
  }
  getAgenteId(id: string){
    return this.http.get<Agente>(this.Url+"/"+id);
  }
  updateAgente(agente: Agente){
    return this.http.put<Agente>(this.Url,agente);
  }
  deleteAgente(id: string){
    return this.http.delete(this.Url + "/" + id);
  }

}
