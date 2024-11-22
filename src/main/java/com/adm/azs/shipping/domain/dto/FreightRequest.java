package com.adm.azs.shipping.domain.dto;

import com.adm.azs.shipping.domain.entity.FreightProperty;
import com.adm.azs.shipping.domain.entity.Parthener;
import lombok.Getter;

@Getter
public class FreightRequest {
    private Long id;
    private Long parthener_id;
    private Long freightProperty_id;
    private Parthener parthener;
    private FreightProperty freightProperty;

}
