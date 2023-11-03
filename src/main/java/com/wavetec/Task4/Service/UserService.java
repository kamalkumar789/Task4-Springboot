package com.wavetec.Task4.Service;


import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class UserService {

    @Autowired
    private LinkedBlockingQueue<Integer> queue;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public ResponseEntity<String> addValues(Integer number){
        logger.info("In UserService...");
        logger.debug("In addValues function");

        String ans = "Successfully added to queue";
        try{
            queue.add(number);
        }
        catch (IllegalStateException exception){
            ans = exception.getMessage();
            logger.debug(ans);
            return new ResponseEntity<>(ans,HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }

    public Queue<Integer> getAllValues(){
        logger.info("In UserService");
        return this.queue;
    }
    public Integer deleteFromQueue() throws InterruptedException {
        logger.info("In UserService");
        return queue.poll();
    }
}
