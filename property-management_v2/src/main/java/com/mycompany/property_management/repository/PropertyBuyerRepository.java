package com.mycompany.property_management.repository;

import com.mycompany.property_management.entity.PropertyBuyer;
import org.springframework.data.repository.CrudRepository;

public interface PropertyBuyerRepository extends CrudRepository<PropertyBuyer,Long> {
    //dont know how this magic is happening here but it gets the id and function and returns the type
    PropertyBuyer findByPropertyEntityId(Long id);
}
