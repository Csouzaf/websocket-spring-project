package com.example.websocket;

import java.time.LocalDateTime;

public class CreatedProcess {

    
    private LocalDateTime timestamp;

    public CreatedProcess(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
}
