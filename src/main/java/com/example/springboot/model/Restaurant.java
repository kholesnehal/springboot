package com.example.springboot.model;

public class Restaurant {
    private int id;
    private String name;
    private String ownerName;


    public Restaurant(int id, String name, String authorName) {
        this.id = id;
        this.name = name;
        this.ownerName = authorName;
    }
    public Restaurant(){}

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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
