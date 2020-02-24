package com.thusitha.webservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CarNoSQL {

    @Id
    private String plateNumber;
    private String brand;
    private Integer price;
    private Rent rent;

    public CarNoSQL(String plateNumber, String brand, Integer price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

}
