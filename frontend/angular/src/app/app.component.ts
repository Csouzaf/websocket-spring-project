import { Component } from '@angular/core';
import { WebsocketService } from '../app/websocket.service';
import { WebsocketconnectComponent } from './components/websocketconnect/websocketconnect.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  items: any[] = [];


  constructor(private websocketService : WebsocketService,
    private websocketConnect: WebsocketconnectComponent) { }

  ngOnInit(): void {
    // this.websocketConnect = new this.websocketConnect(
    //     ''
    //     this.onMessage.bind(this);
    // )
  }



  onMessage(message: any){
    this.items.push(message.body);
  }

  start(){
    this.websocketService.startWebsocket().subscribe(success => {
      console.log(success)
    })
  };
}
