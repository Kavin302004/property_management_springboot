package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.entity.Buyer;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.meta.PaginationMeta;
import com.mycompany.property_management.model.BuyerModel;
import com.mycompany.property_management.repository.BuyerRepository;
import com.mycompany.property_management.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public PaginationMeta getBuyers(Pageable pageable) {
        Page<Buyer> buyerPage= buyerRepository.findAll(pageable);

        List<Buyer> buyerList=buyerPage.getContent(); // returns only the content data

        PaginationMeta paginationMeta=PaginationMeta.createPagination(buyerPage);
        return paginationMeta;
    }
    @Override
    public PaginationMeta getBuyersWithNamedQuery(Pageable pageable) {
        Page<Buyer> buyerPage= buyerRepository.findAllByOrderByIdDesc(pageable);  // function names are keywordss

        List<Buyer> buyerList=buyerPage.getContent(); // returns only the content data

        PaginationMeta paginationMeta=PaginationMeta.createPagination(buyerPage);
        return paginationMeta;
    }


}
