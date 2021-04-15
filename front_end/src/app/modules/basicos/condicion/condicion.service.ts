import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Condicion } from 'src/app/models/condicion';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CondicionService {
  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url=this.urlbase +"/condicion";

  constructor(private http:HttpClient) { }

  getList(){
    return this.http.get<Condicion[]>(this.Url);
  }
  create(obj: Condicion){
    return this.http.post<Condicion>(this.Url,obj);
  }
  getId(id: string){
    return this.http.get<Condicion>(this.Url+"/"+id);
  }
  update(obj: Condicion){
    return this.http.put<Condicion>(this.Url,obj);
  }
  delete(id: string){
    return this.http.delete(this.Url + "/" + id);
  }
}
