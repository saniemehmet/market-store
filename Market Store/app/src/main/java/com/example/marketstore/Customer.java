package com.example.marketstore;

public class Customer {
    String name, email, phone, address;

    Customer(String name, String email, String phone, String address){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    Customer(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    Customer(){}
}
