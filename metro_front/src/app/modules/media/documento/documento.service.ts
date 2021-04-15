import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Documento } from '../../../models/documento';

@Injectable({
  providedIn: 'root'
})
export class DocumentoService {
  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url=this.urlbase + "/documento/";

  constructor(private http:HttpClient) { }

  public list(): Observable<Documento[]> {
    return this.http.get<Documento[]>(this.Url + 'list');
  }

  public upload(documento:File,id:String): Observable<any>{
    const formData = new FormData;
    formData.append('multipartFile',documento);
    return this.http.post<any>(this.Url + 'upload/'+id, formData);
  }

  public delete(id: string): Observable<any>{
    return this.http.delete<any>(this.Url + 'delete/'+id);
  }
}
