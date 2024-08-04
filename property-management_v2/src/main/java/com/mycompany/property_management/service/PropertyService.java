package com.mycompany.property_management.service;

import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.exception.BusinessException;
import com.mycompany.property_management.model.BulkPropertyModel;
import com.mycompany.property_management.model.PropertyModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {
     PropertyModel saveProperty(PropertyModel propertyModel);
     List<PropertyModel> getallProperties(boolean buyer);
     PropertyModel updateProperty(PropertyModel propertyModel, Long propertyId);
     PropertyModel updatePropertyDescription( PropertyModel propertyModel,Long propertyId) throws BusinessException;
     void deleteProperty(Long propertyId);
     BulkPropertyModel saveBulkProperty(BulkPropertyModel bulkPropertyModel);

}
