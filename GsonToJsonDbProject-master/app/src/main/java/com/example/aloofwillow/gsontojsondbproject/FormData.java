package com.example.aloofwillow.gsontojsondbproject;

import java.util.ArrayList;

public class FormData {
    String name;
    int age;
    ArrayList<String> addressList=new ArrayList<>();

    public FormData(String name, int age, ArrayList<String> addressList) {
        this.name = name;
        this.age = age;
        this.addressList = addressList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<String> addressList) {
        this.addressList = addressList;
    }
}
