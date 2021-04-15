import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Agencia } from 'src/app/models/agencia';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AgenciaService {

  enviroment : CoreEnvironment; 
  urlbase:string = environment.url;
  Url= this.urlbase + '/agencia';

  constructor(private http:HttpClient) { }

  getList(){
    return this.http.get<Agencia[]>(this.Url);
  }
  create(obj: Agencia){
    return this.http.post<Agencia>(this.Url,obj);
  }
  getId(id: string){
    return this.http.get<Agencia>(this.Url+"/"+id);
  }
  update(obj: Agencia){
    return this.http.put<Agencia>(this.Url,obj);
  }
  delete(id: string){
    return this.http.delete(this.Url + "/" + id);
  }
}
