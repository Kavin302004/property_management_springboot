package com.mycompany.property_management.service;

import com.mycompany.property_management.entity.Buyer;
import com.mycompany.property_management.meta.PaginationMeta;
import com.mycompany.property_management.model.BuyerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuyerService {
    PaginationMeta getBuyers(Pageable pageable);
    PaginationMeta getBuyersWithNamedQuery(Pageable pageable);
}
