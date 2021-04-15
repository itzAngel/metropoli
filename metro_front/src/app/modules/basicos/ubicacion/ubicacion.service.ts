import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Ubicacion } from 'src/app/models/ubicacion';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UbicacionService {
  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url= this.urlbase + "/ubicacion";

  constructor(private http:HttpClient) { }

  getList(){
    return this.http.get<Ubicacion[]>(this.Url);
  }
  create(obj: Ubicacion){
    return this.http.post<Ubicacion>(this.Url,obj);
  }
  getId(id: string){
    return this.http.get<Ubicacion>(this.Url+"/"+id);
  }
  update(obj: Ubicacion){
    return this.http.put<Ubicacion>(this.Url,obj);
  }
  delete(id: string){
    return this.http.delete(this.Url + "/" + id);
  }
}
