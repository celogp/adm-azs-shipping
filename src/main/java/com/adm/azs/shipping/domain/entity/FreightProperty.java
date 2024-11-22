package com.adm.azs.shipping.domain.entity;

import com.adm.azs.shipping.domain.enums.PropertyType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "freightproperties")
@Data
public class FreightProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private PropertyType propertytype;

}
