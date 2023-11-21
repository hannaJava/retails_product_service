package com.labiba.ProductService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductServiceExceptionResponse {
    private String errorMessage;
    private String errorCode;
}
