import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WebsocketconnectComponent } from './websocketconnect.component';

describe('WebsocketconnectComponent', () => {
  let component: WebsocketconnectComponent;
  let fixture: ComponentFixture<WebsocketconnectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WebsocketconnectComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WebsocketconnectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
