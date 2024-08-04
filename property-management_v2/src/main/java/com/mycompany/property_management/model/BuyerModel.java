package com.mycompany.property_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BuyerModel {



    private String Name;

    private String Ph;



    public String getPh() {
        return Ph;
    }

    public void setPh(String ph) {
        Ph = ph;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
