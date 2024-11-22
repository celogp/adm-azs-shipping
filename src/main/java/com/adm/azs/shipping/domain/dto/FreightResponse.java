package com.adm.azs.shipping.domain.dto;

import com.adm.azs.shipping.domain.entity.FreightProperty;
import com.adm.azs.shipping.domain.entity.Parthener;
import lombok.Data;

@Data
public class FreightResponse {
    private Long id;
    private Parthener parthener;
    private FreightProperty freightProperty;
}
