package com.adm.azs.shipping.domain.dto;

import com.adm.azs.shipping.domain.entity.FreightProperty;
import lombok.Data;

@Data
public class FreightParthenerResponse {
    private Long id;
    private FreightProperty freightProperty;
}
