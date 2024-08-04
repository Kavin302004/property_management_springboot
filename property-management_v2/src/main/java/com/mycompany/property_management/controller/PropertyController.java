package com.mycompany.property_management.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.model.BulkPropertyModel;
import com.mycompany.property_management.model.PropertyModel;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//We should integrate spring controllers here
@RestController
@RequestMapping("/api/v1") //using versions v1 is a good practice
public class PropertyController {
    @Autowired //object of implementing class is repointed injected here
    private PropertyService propertyService;//Dependency injection

    @GetMapping("/{n1}+{n2}")
    public int SayHello(@PathVariable("n1") int n1,@PathVariable("n2") int n2) {
        return n1+n2 ;
    }
    @PostMapping("/properties")
    public ResponseEntity<PropertyModel> saveProperty(@RequestBody PropertyModel propertyModel) {
        ; //without autowire this will be NULL
        //System.out.println(propertyModel);
        return new ResponseEntity<PropertyModel>(propertyService.saveProperty(propertyModel), HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyModel>> getProperties(@RequestParam("buyer") boolean buyer) {
       List<PropertyModel> propertyEntityList=propertyService.getallProperties(buyer);
       ResponseEntity<List<PropertyModel>> responseEntity = new ResponseEntity<List<PropertyModel>>(propertyEntityList,HttpStatus.OK);
       return responseEntity;
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyModel> updateProperty(@RequestBody PropertyModel propertyModel,@PathVariable("id") Long propertyId) {
        ResponseEntity<PropertyModel> responseEntity=new ResponseEntity<>(propertyService.updateProperty(propertyModel,propertyId),HttpStatus.OK);
        return responseEntity;

    }

    //Partial update

    @PatchMapping("/properties/update-description/{id}")
    public ResponseEntity<PropertyModel> updatePropertyDescription(@RequestBody PropertyModel propertyModel, @PathVariable("id") Long propertyId) {
        ResponseEntity<PropertyModel> responseEntity=new ResponseEntity<>(propertyService.updatePropertyDescription(propertyModel,propertyId),HttpStatus.OK);
        return responseEntity;
    }

    //delete by id
    @DeleteMapping("/properties/delete/{id}")
    public ResponseEntity<PropertyModel> deleteProperty(@PathVariable("id") Long propertyId) {
        propertyService.deleteProperty(propertyId);
        ResponseEntity<PropertyModel> responseEntity=new ResponseEntity<>(null,HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/properties/insertbulk")
    public ResponseEntity<BulkPropertyModel> insertBulkProperties(@RequestBody BulkPropertyModel bulkPropertyModel) {
        ResponseEntity<BulkPropertyModel> responseEntity=new ResponseEntity<>(propertyService.saveBulkProperty(bulkPropertyModel),HttpStatus.OK);
        return responseEntity;
    }

}
