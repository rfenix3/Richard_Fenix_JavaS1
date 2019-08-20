package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {
    private List<Classmate> classmate = new ArrayList<Classmate>();

    public void add(Classmate classmate){
        this.classmate.add(classmate);
    }

    public Classmate get(int i){
        return this.classmate.get(i);
    }

    public List<Classmate> getAll(){
        return this.classmate;
    }
}
