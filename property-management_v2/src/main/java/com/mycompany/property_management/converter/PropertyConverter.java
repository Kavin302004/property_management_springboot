package com.mycompany.property_management.converter;

import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.model.PropertyModel;
import org.springframework.stereotype.Component;

//so that the class will now become singleton instance for autowiring
@Component
public class PropertyConverter {
    public PropertyEntity convertModelTOEntity(PropertyModel propertyModel) {

        PropertyEntity pe=new PropertyEntity();

        pe.setTitle(propertyModel.getTitle());
        pe.setAddress(propertyModel.getAddress());
        pe.setDescription(propertyModel.getDescription());
        pe.setOwnerEmail(propertyModel.getOwnerEmail());
        pe.setOwnerName(propertyModel.getOwnerName());
        pe.setPrice(propertyModel.getPrice());
         return pe;
    }
    public PropertyModel convertEntitytoModel(PropertyEntity propertyEntity) {
        //making the model more loosely coupled

        PropertyModel pm=new PropertyModel();

        pm.setTitle(propertyEntity.getTitle());
        pm.setAddress(propertyEntity.getAddress());
        pm.setDescription(propertyEntity.getDescription());
        pm.setOwnerEmail(propertyEntity.getOwnerEmail());
        pm.setOwnerName(propertyEntity.getOwnerName());
        pm.setPrice(propertyEntity.getPrice());
        return pm;
    }
}
