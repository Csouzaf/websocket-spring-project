import { Component, OnInit } from '@angular/core';
import { WebsocketService } from '../../websocket.service';

@Component({
  selector: 'app-websocketconnect',
  templateUrl: './websocketconnect.component.html',
  styleUrls: ['./websocketconnect.component.css']
})
export class WebsocketconnectComponent {

  private stomClient: any;

  constructor(private websocketEndPoint : string,
    private topic: string,
    private onMessage: Function,
    private callBackError?: Function,
    const errorCallBack = callBackError || this.onError,
    this.connect(errorCallback)) { }

  ngOnInit(): void {
    // this.onMessage.bind(this);
  }



  // onMessage(message: any){
  //   this.items.push(message.body);
  // }

}
