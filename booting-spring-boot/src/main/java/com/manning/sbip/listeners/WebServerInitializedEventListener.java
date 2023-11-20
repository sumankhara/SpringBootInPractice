package com.manning.sbip.listeners;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

import java.time.LocalDateTime;

public class WebServerInitializedEventListener implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        System.out.println("WebServer Initialized Event generated at " + LocalDateTime.now());
    }
}
