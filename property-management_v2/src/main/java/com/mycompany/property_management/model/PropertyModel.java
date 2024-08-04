package com.mycompany.property_management.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mycompany.property_management.entity.Buyer;
import com.mycompany.property_management.entity.PropertyBuyer;

//DTO
public class PropertyModel {

    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BuyerModel buyerModel;

    public BuyerModel getBuyerModel() {
        return buyerModel;
    }

    public void setBuyerModel(BuyerModel buyerModel) {
        this.buyerModel = buyerModel;
    }




    //Can also use lombok for getters and setters - @Getter, @Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
