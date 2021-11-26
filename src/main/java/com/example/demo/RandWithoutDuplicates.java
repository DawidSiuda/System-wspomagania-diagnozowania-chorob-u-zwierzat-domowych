package com.example.demo;

import java.util.ArrayList;
import java.util.Random;

public class RandWithoutDuplicates {

    Random rand = new Random();
    ArrayList<Integer> list;
    int size;

    public RandWithoutDuplicates(int range){
        size = range;
        list = new ArrayList<Integer>(size);

        for(int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    public int getNextNumber() {
        if (list.size() > 0) {
            int index = rand.nextInt(list.size());
            return list.remove(index);
        }
        else{
            return -1;
        }
    }
}
