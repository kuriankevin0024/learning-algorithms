package com.learning.algorithms;

public class Person implements Comparable<Person> {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person that) {
        if (this.id < that.id) {
            return -1;
        } else if (this.id > that.id) {
            return +1;
        }
        return 0;
    }
}
