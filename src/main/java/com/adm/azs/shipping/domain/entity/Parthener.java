package com.adm.azs.shipping.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "partheners")
@Data
public class Parthener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
