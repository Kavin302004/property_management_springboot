package com.mycompany.property_management.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Table
public class PropertyBuyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="Property_Id",referencedColumnName = "id",nullable = false)
    private PropertyEntity propertyEntity;

    @ManyToOne
    @JoinColumn(name="Buyer_Id",referencedColumnName = "id")
    private Buyer buyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Long getBuyer_id() {
        return Buyer_id;
    }

    public void setBuyer_id(Long buyer_id) {
        Buyer_id = buyer_id;
    }

    public Long getPropertyEntity_id() {
        return PropertyEntity_id;
    }

    public void setPropertyEntity_id(Long propertyEntity_id) {
        PropertyEntity_id = propertyEntity_id;
    }
*/
    public PropertyEntity getPropertyEntity() {
        return propertyEntity;
    }

    public void setPropertyEntity(PropertyEntity propertyEntity) {
        this.propertyEntity = propertyEntity;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
