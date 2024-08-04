package com.mycompany.property_management.controller;

import com.mycompany.property_management.entity.Buyer;
import com.mycompany.property_management.meta.PaginationMeta;
import com.mycompany.property_management.model.BuyerModel;
import com.mycompany.property_management.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/buyers")
    public ResponseEntity<PaginationMeta> getAuthors(@SortDefault(sort="id",direction = Sort.Direction.DESC) Pageable pageable) {

        return new ResponseEntity<>(buyerService.getBuyers(pageable),HttpStatus.OK);

    }
    @GetMapping("/buyerswithnamed")
    public ResponseEntity<PaginationMeta> getAuthorsWithNamedQuery( Pageable pageable) {

        return new ResponseEntity<>(buyerService.getBuyersWithNamedQuery(pageable),HttpStatus.OK);

    }
}
