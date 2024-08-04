package com.mycompany.property_management.repository;

import com.mycompany.property_management.entity.Buyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// We have PagingandSortingRepository tooo which provides crud
//Its also like Crud , Jpa Repo but helps in Pagination
public interface BuyerRepository extends PagingAndSortingRepository<Buyer,Long> {
    Page<Buyer> findAllByOrderByIdDesc(Pageable pageable);
}
