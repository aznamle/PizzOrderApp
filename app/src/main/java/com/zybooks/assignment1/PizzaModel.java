package com.zybooks.assignment1;

public class PizzaModel {

    double size_price = 0;
    double cb1;
    double cb2;
    double cb3;
    double cb4;
    double cb5;
    double cb6;

    String size = "";
    String toppings = "";
    String name = "";
    String phone = "";
    String email = "";
    String address = "";

    //size price
    public double getSize_price() {
        return size_price;
    }

    public void setSize_price(double size_price) {
        this.size_price = size_price;
    }

    //toppings
    public double getCb1() {
        return cb1;
    }

    public void setCb1(double cb1) {
        this.cb1 = cb1;
    }

    public double getCb2() {
        return cb2;
    }

    public void setCb2(double cb2) {
        this.cb2 = cb2;
    }

    public double getCb3() {
        return cb3;
    }

    public void setCb3(double cb3) {
        this.cb3 = cb3;
    }

    public double getCb4() {
        return cb4;
    }

    public void setCb4(double cb4) {
        this.cb4 = cb4;
    }

    public double getCb5() {
        return cb5;
    }

    public void setCb5(double cb5) {
        this.cb5 = cb5;
    }

    public double getCb6() {
        return cb6;
    }

    public void setCb6(double cb6) {
        this.cb6 = cb6;
    }


    //size and topping Strings
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }


    //customer information
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
