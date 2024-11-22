package com.adm.azs.shipping.domain.dto;

import java.util.List;

public record ApiResponse<T>(List<T> data,
                             PaginationResponse pagination) {
}