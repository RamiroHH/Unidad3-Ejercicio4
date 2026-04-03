package com.programacion4.unidad3ej4.feature.producto.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoPatchRequestDto {

    private Double precio;
    private Integer stock;
    private Long categoriaId;

}