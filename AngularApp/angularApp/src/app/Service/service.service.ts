import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Usuarios} from "../Modelo/Usuarios";
import {Observable} from "rxjs/Rx";
import {map} from "rxjs/internal/operators";

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  Url1 = 'http://localhost:8080/login';
  Url2 = 'http://localhost:8080/consultar';

  constructor(private http: HttpClient ) { }

  private extractData(res: Response) {
    let body = res;
    return body || { };
  }



  getLogin(username, pass): Observable<any> {
    return this.http.get(this.Url1 + '?user=' + username + '&pass=' + pass).pipe(
      map(this.extractData));
  }

  getProducto(codigo): Observable<any> {
    return this.http.get(this.Url2 + '?codigo=' + codigo ).pipe(
      map(this.extractData));
  }
}
