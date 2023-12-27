package com.example.websocket;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebsocketApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private final WebSocketStompClient stompClient = new WebSocketStompClient(new SockJsClient(
            java.util.List.of(new WebSocketTransport(new StandardWebSocketClient()))));

    @Test
    void testWebSocketApi() throws Exception {
        // Connect to the WebSocket server
        StompSession session = stompClient.connect("ws://localhost:" + port + "/socket", new StompSessionHandlerAdapter() {}).get(5, TimeUnit.SECONDS);

        // Subscribe to the WebSocket topic you want to test
        session.subscribe("/statusProcesoor", new StompFrameHandler() {
            @Override
            public Type getPayloadType(StompHeaders headers) {
                return String.class;
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                // Handle received WebSocket messages here
                // You can add assertions or verifications here
            }
        });

        // You can send a message to your WebSocket server if needed
        // session.send("/app/yourWebSocketEndpoint", "Your message payload");

        // Sleep for a while to allow receiving WebSocket messages
        Thread.sleep(5000);

        // Optionally, disconnect the WebSocket session
        session.disconnect();
    }

}
