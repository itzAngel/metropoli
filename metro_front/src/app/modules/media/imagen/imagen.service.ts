import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Imagen } from '../../../models/imagen';
@Injectable({
  providedIn: 'root'
})
export class ImagenService {
  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url=this.urlbase + "/foto/";

  constructor(private http:HttpClient) { }

  public list(): Observable<Imagen[]> {
    return this.http.get<Imagen[]>(this.Url + 'list');
  }

  public getImagenId(id: String){
    return this.http.get<Imagen>(this.Url+"listid/"+id);
  }

  public upload(imagen:File,id:String): Observable<any>{
    const formData = new FormData;
    formData.append('multipartFile',imagen);
    return this.http.post<any>(this.Url + 'upload/'+ id, formData);
  }

  public delete(id: string): Observable<any>{
    return this.http.delete<any>(this.Url + 'delete/'+id);
  }
}
