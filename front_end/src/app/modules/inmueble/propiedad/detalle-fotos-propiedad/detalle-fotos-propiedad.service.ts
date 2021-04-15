import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { DetalleFotosPropiedad } from 'src/app/models/detalle-fotos-propiedad';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DetalleFotosPropiedadService {
  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url=this.urlbase + "/detalleFotosPropiedad";

  constructor(private http:HttpClient) { }

  getList(){
    return this.http.get<DetalleFotosPropiedad[]>(this.Url+"/listar");
  }
  getListxProp(id: string){
    return this.http.get<DetalleFotosPropiedad[]>(this.Url+"/listarPorPropiedad/"+id);
  }
  create(obj: DetalleFotosPropiedad){
    return this.http.post<DetalleFotosPropiedad>(this.Url,obj);
  }
  getId(id: string){
    return this.http.get<DetalleFotosPropiedad>(this.Url+"/"+id);
  }
  update(obj: DetalleFotosPropiedad){
    return this.http.put<DetalleFotosPropiedad>(this.Url,obj);
  }
  delete(id: string){
    return this.http.delete(this.Url + "/" + id);
  }
}
