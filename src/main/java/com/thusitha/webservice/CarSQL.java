package com.thusitha.webservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CarSQL {

    @Id
    private String plateNumber;
    private String brand;
    private Integer price;
    
    @Transient
    private Rent rent;

    public CarSQL() {
    }

    public CarSQL(String plateNumber, String brand, Integer price) {
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
