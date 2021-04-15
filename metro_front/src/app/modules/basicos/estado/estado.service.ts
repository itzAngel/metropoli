import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Estado } from 'src/app/models/estado';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url= this.urlbase + "/estado";

  constructor(private http:HttpClient) { }

  getList(){
    return this.http.get<Estado[]>(this.Url);
  }
  create(obj: Estado){
    return this.http.post<Estado>(this.Url,obj);
  }
  getId(id: string){
    return this.http.get<Estado>(this.Url+"/"+id);
  }
  update(obj: Estado){
    return this.http.put<Estado>(this.Url,obj);
  }
  delete(id: string){
    return this.http.delete(this.Url + "/" + id);
  }
}
