package com.joytechnologies.rentacar.Recyclerview;

public class top_Class {

    String car_name;
    String car_amount;
    String car_capacity;
    String car_rating;
    String car_img;

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_amount() {
        return car_amount;
    }

    public void setCar_amount(String car_amount) {
        this.car_amount = car_amount;
    }

    public String getCar_capacity() {
        return car_capacity;
    }

    public void setCar_capacity(String car_capacity) {
        this.car_capacity = car_capacity;
    }

    public String getCar_rating() {
        return car_rating;
    }

    public void setCar_rating(String car_rating) {
        this.car_rating = car_rating;
    }

    public String getCar_img() {
        return car_img;
    }

    public void setCar_img(String car_img) {
        this.car_img = car_img;
    }

    public top_Class() {
    }

    public top_Class(String car_name, String car_amount, String car_capacity, String car_rating, String car_img) {
        this.car_name = car_name;
        this.car_amount = car_amount;
        this.car_capacity = car_capacity;
        this.car_rating = car_rating;
        this.car_img = car_img;
    }
}
