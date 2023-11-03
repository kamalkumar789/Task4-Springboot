package com.wavetec.Task4.Controllers;

import com.wavetec.Task4.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Queue;

@RestController
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping(value = "/add/value/{number}")
    public ResponseEntity<String> insertValues(@PathVariable(name = "number") Integer number){
        logger.info("In user controller");
        logger.debug("In InsertValues function");
        return userService.addValues(number);
    }

    @GetMapping(value = "/getAllValues")
    public Queue<Integer> getAllValues(){
        logger.info("In user controller");
        logger.debug("In getAllValues function");
        return userService.getAllValues();
    }
    @DeleteMapping(value = "/delete")
    public Integer deleteFromQueue() throws InterruptedException {
        logger.info("In user controller");
        logger.debug("In deleteFromQueue function");
        return userService.deleteFromQueue();
    }
}
