import { Injectable } from '@angular/core';
import { WebsocketconnectComponent } from './components/websocketconnect/websocketconnect.component';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class WebsocketService {


  private URL = "http://localhost:8080/api";

  constructor(private http: HttpClient) { }


  startWebsocket():Observable<any>{
    return this.http.put<any>(this.URL, {})
  }


}
