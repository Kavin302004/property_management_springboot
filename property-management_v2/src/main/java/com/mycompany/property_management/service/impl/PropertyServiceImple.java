package com.mycompany.property_management.service.impl;
import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.entity.Buyer;
import com.mycompany.property_management.entity.PropertyBuyer;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.exception.BusinessException;
import com.mycompany.property_management.model.BulkPropertyModel;
import com.mycompany.property_management.model.BuyerModel;
import com.mycompany.property_management.model.PropertyModel;
import com.mycompany.property_management.repository.PropertyBuyerRepository;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImple implements PropertyService{

    @Autowired
    public PropertyRepository propertyRepository;

    @Autowired
    public PropertyConverter propertyConverter;

    @Autowired
    private PropertyBuyerRepository propertyBuyerRepository;


    @Override
    public PropertyModel saveProperty(PropertyModel propertyModel) {
        //save needs propertyEntity type so we should convert this
        //we added another layer - converter Layer for conversion
        PropertyEntity pe =propertyConverter.convertModelTOEntity(propertyModel);
        /*
        PropertyEntity pe=new PropertyEntity();

        //not a good practice to convert like this
        //So you can create a package called converter layer
        pe.setTitle(propertyModel.getTitle());
        pe.setAddress(propertyModel.getAddress());
        pe.setDescription(propertyModel.getDescription());
        pe.setOwnerEmail(propertyModel.getOwnerEmail());
        pe.setOwnerName(propertyModel.getOwnerName());
        pe.setPrice(propertyModel.getPrice());
         */
        pe=propertyRepository.save(pe); //LHS pe will have the current row saved with id
        PropertyModel pm = propertyConverter.convertEntitytoModel(pe);
        return pm;
    }

    @Override
    public List<PropertyModel> getallProperties(boolean buyer) {
       // List<PropertyEntity> propertyEntityList= (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyEntity> propertyEntities= (List<PropertyEntity>) propertyRepository.findAll();

        List<PropertyModel> propertyModelList=new ArrayList<>();

        for(PropertyEntity propertyEntity : propertyEntities) {
            PropertyModel propertyModel = new PropertyModel();
            propertyModel.setTitle(propertyEntity.getTitle());
            propertyModel.setDescription(propertyEntity.getDescription());
            propertyModel.setPrice(propertyEntity.getPrice());
            propertyModel.setAddress(propertyEntity.getAddress());
            propertyModel.setOwnerEmail(propertyEntity.getOwnerEmail());
            propertyModel.setOwnerName(propertyEntity.getOwnerName());

            if(buyer) {
                PropertyBuyer propertyBuyer= propertyBuyerRepository.findByPropertyEntityId(propertyEntity.getId());
                Buyer buyer1 =propertyBuyer.getBuyer();
                BuyerModel buyerModel=new BuyerModel();
                buyerModel.setName(buyer1.getName());
                buyerModel.setPh(buyer1.getPh());

                propertyModel.setBuyerModel(buyerModel);

            }
            else {
                propertyModel.setBuyerModel(null);
            }

                propertyModelList.add(propertyModel);


        }
        return propertyModelList;




    }

    @Override
    public PropertyModel updateProperty(PropertyModel propertyModel, Long propertyId) {
       Optional<PropertyEntity>  propertyEntityOptional=propertyRepository.findById(propertyId);
       PropertyModel dto=null;
        if(propertyEntityOptional.isPresent()) {
            PropertyEntity pe=propertyEntityOptional.get();
            pe.setTitle(propertyModel.getTitle());
            pe.setPrice(propertyModel.getPrice());
            pe.setOwnerName(propertyModel.getOwnerName());
            pe.setAddress(propertyModel.getAddress());
            pe.setDescription(propertyModel.getDescription());
            pe.setOwnerEmail(propertyModel.getOwnerEmail());
            propertyRepository.save(pe);
            PropertyModel pm=propertyConverter.convertEntitytoModel(pe);


            return pm;
        }
        else {
            throw new BusinessException("No Property Found");
        }

    }

    @Override
    public PropertyModel updatePropertyDescription(PropertyModel propertyModel, Long propertyId) throws BusinessException {
        Optional<PropertyEntity>  propertyEntityOptional=propertyRepository.findById(propertyId);
        PropertyModel dto=null;
        if(propertyEntityOptional.isPresent()) {
            PropertyEntity pe=propertyEntityOptional.get();

            pe.setDescription(propertyModel.getDescription());
            propertyRepository.save(pe);
            PropertyModel pm=propertyConverter.convertEntitytoModel(pe);

            return pm;
        }
        else {
            throw new BusinessException("No Property Found for Update");
        }
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    @Override
    public BulkPropertyModel saveBulkProperty(BulkPropertyModel bulkPropertyModel) {
        List<PropertyModel> propertyModels=bulkPropertyModel.getProperties();
        List<PropertyEntity> propertyEntities=new ArrayList<>();
        for(PropertyModel propertyModel:propertyModels) {
            PropertyEntity pe =propertyConverter.convertModelTOEntity(propertyModel);
            propertyEntities.add(pe);
        }
        propertyRepository.saveAll(propertyEntities);
        return bulkPropertyModel;
    }


}
