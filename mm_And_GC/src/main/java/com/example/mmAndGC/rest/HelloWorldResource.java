package com.example.mmAndGC.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class HelloWorldResource {

    @GetMapping("/")
    @ApiOperation(value = "Gets Sample String", notes = "Just a Sample API that returns String", response = String.class)
    public String getString(){
        allocateHeapMemory(0);
        allocateStackMemory(0);
        return "Hello World It is Friday";
    }

    // Set Stack Size to 200KB to cause Stack Overflow
    private void allocateStackMemory(int count) {
        if (count < 2150) {
            allocateStackMemory(count + 1);
        }
    }

    // Set Heap Size to 100MB to cause Heap Overflow
    // -XX:+UseSerialGC Make GC Serial
    private void allocateHeapMemory(int count) {
        LocalDateTime startTime = LocalDateTime.now();
        while(count<100){
            allocateHeapMemoryFromDummyClass();
            count++;
        }
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(Duration.between(startTime, endTime).toMillis());
    }

    private DummyClass allocateHeapMemoryFromDummyClass(){
        DummyClass obj = new DummyClass();
        obj.allocateHeapMemory();
        return obj;
    }
}
