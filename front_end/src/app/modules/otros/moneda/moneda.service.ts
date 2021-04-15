import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Moneda } from 'src/app/models/moneda';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MonedaService {
  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url=this.urlbase + "/moneda";

  constructor(private http:HttpClient) { }

  getList(){
    return this.http.get<Moneda[]>(this.Url);
  }
  create(obj: Moneda){
    return this.http.post<Moneda>(this.Url,obj);
  }
  getId(id: string){
    return this.http.get<Moneda>(this.Url+"/"+id);
  }
  update(obj: Moneda){
    return this.http.put<Moneda>(this.Url,obj);
  }
  delete(id: string){
    return this.http.delete(this.Url + "/" + id);
  }
}
