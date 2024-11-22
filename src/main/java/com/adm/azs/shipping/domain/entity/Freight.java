package com.adm.azs.shipping.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "freights")
@Data
public class Freight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parthener_id", referencedColumnName = "id")
    private Parthener parthener;

    @ManyToOne
    @JoinColumn(name = "freightproperty_id", referencedColumnName = "id")
    private FreightProperty freightProperty;

}
