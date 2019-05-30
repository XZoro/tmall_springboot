package com.xie.tmall.config;

import org.springframework.beans.factory.annotation.Value;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.awt.*;
import org.slf4j.Logger;
import java.net.URI;

@Component
public class MyCommandRunner implements CommandLineRunner{
    @Value("${spring.web.homeurl}")
    private String homeUrl;

    @Value("${spring.web.fireexcute}")
    private String fireExcutePath;

    @Value("${spring.auto.openurl}")
    private boolean isOpen;


    @Override
    public void run(String... args) throws Exception{
        if (isOpen){
            String cmd = fireExcutePath +" "+ homeUrl;
            Runtime run = Runtime.getRuntime();
            try {
                run.exec(cmd);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

