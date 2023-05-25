package com.example.mmAndGC.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private void allocateHeapMemory(int count) {
        ArrayList<DummyClass> dummyClassArrayList = new ArrayList<>();
        while(count<10){
            dummyClassArrayList.add(allocateHeapMemoryFromDummyClass());
//            allocateHeapMemoryFromDummyClass();
            count++;
        }
    }

    private DummyClass allocateHeapMemoryFromDummyClass(){
        DummyClass obj = new DummyClass();
        obj.allocateHeapMemory();
        return obj;
    }
}
