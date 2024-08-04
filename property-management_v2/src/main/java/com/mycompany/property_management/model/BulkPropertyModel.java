package com.mycompany.property_management.model;

import java.util.ArrayList;
import java.util.List;

public class BulkPropertyModel {
    List<PropertyModel> properties=new ArrayList<>();

    public List<PropertyModel> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyModel> properties) {
        this.properties = properties;
    }
}
