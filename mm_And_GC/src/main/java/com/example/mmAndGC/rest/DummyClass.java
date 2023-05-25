package com.example.mmAndGC.rest;

public class DummyClass {
    private int[] largeArray;
    public void allocateHeapMemory(){
        this.largeArray = new int[10000000];
    }
}
