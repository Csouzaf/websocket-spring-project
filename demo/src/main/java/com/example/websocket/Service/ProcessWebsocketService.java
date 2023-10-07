package com.example.websocket.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessWebsocketService {
    
    private SimpMessagingTemplate template;

    @Autowired
    public ProcessWebsocketService(SimpMessagingTemplate template){
        this.template = template;
    }

    @Async
    public void execute(){
        try {
            Thread.sleep(2000L);//Simulate delay
            template.convertAndSend("/statusProcesoor", generateMessage(1));




        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private String generateMessage(int stage){
        return String.format("Executed the stage $s at $s", stage, 
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

}
