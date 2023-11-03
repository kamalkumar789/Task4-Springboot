package com.wavetec.Task4.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Configuration
public class Config {


    @Value("${QueueCapacity}")
    private Integer capacity;

    @Bean
    public LinkedBlockingQueue<Integer> createLinkedBlockingQueue(){
        return new LinkedBlockingQueue<>(capacity);
    }
}
