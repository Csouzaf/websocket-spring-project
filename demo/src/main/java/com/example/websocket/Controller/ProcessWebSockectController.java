package com.example.websocket.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.websocket.CreatedProcess;
import com.example.websocket.Service.ProcessWebsocketService;

@CrossOrigin()
@RestController
// @RequestMapping("/api")
public class ProcessWebSockectController {
   
   private ProcessWebsocketService processWebsocketService;

   // @Autowired
   // public ProcessWebSockectController(ProcessWebsocketService processWebsocketService){
   //  this.processWebsocketService = processWebsocketService;
   // }

   public ResponseEntity<CreatedProcess> execute(){
      
        processWebsocketService.execute();
        return ResponseEntity.ok().body(new CreatedProcess(LocalDateTime.now()));
   }










}
