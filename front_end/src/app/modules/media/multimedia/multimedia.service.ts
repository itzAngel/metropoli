import { HttpClient } from '@angular/common/http';
import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Multimedia } from '../../../models/multimedia';

@Injectable({
  providedIn: 'root'
})
export class MultimediaService {
  enviroment : CoreEnvironment; 
  urlbase = environment.url;
  Url=this.urlbase + "/multimedia/";

  constructor(private http:HttpClient) { }

  public list(): Observable<Multimedia[]> {
    return this.http.get<Multimedia[]>(this.Url + 'list');
  }

  public upload(multimedia:File,id:String): Observable<any>{
    const formData = new FormData;
    formData.append('multipartFile',multimedia);
    return this.http.post<any>(this.Url + 'upload/' + id, formData);
  }

  public delete(id: string): Observable<any>{
    return this.http.delete<any>(this.Url + 'delete/'+id);
  }
}
