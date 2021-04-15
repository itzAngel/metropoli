import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Tipo } from 'src/app/models/tipo';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TipoService {
  enviroment : CoreEnvironment; 
  urlbase:string = environment.url;
  Url= this.urlbase + '/tipo';

  constructor(private http:HttpClient) { }

  getList(){
    return this.http.get<Tipo[]>(this.Url);
  }
  create(obj: Tipo){
    return this.http.post<Tipo>(this.Url,obj);
  }
  getId(id: string){
    return this.http.get<Tipo>(this.Url+"/"+id);
  }
  update(obj: Tipo){
    return this.http.put<Tipo>(this.Url,obj);
  }
  delete(id: string){
    return this.http.delete(this.Url + "/" + id);
  }
}
