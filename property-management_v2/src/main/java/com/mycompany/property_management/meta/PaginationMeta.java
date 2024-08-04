package com.mycompany.property_management.meta;

import com.mycompany.property_management.entity.Buyer;
import org.springframework.data.domain.Page;

import java.util.List;

public class PaginationMeta {
    //total count --> 100
    //total page -->10
    //page size --> 10
    //page numnber =1 {1-10}  2 { 11 - 20 } 3 {21 - 30 }....
    //isLast = true then it is the last page
    //isFirst = true then it is the First page
    //these all are displayed automatically when Page<T> is used in response entity
    // for altering these

    private Long totalCount;//total elements
    private Integer pageSize;
    private Integer totalPage;
    private Integer pageNumber;
    private Boolean isLast;
    private Boolean isFirst;

    private List<Buyer> buyerList;

    public Long getTotalCount() {
        return totalCount;
    }

    public List<Buyer> getBuyerList() {
        return buyerList;
    }

    public void setBuyerList(List<Buyer> buyerList) {
        this.buyerList = buyerList;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Boolean getLast() { // as this is Last not isLast Postman gives as last
        return isLast;
    }

    public void setLast(Boolean last) {
        isLast = last;
    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }

    public static PaginationMeta createPagination(Page<?> page) {


        List<Buyer> buyerList1=(List<Buyer>) page.getContent();
        PaginationMeta paginationMeta= new PaginationMeta();
        paginationMeta.setBuyerList(buyerList1);
        paginationMeta.setFirst(page.isFirst());
        paginationMeta.setLast(page.isLast());
        paginationMeta.setPageNumber(page.getNumber()+1);//updated
        paginationMeta.setPageSize(page.getSize());
        paginationMeta.setTotalCount(page.getTotalElements());
        paginationMeta.setTotalPage(page.getTotalPages());

        return paginationMeta;
    }
}
