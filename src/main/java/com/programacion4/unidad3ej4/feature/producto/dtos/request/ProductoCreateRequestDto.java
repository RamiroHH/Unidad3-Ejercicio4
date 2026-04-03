package com.programacion4.unidad3ej4.feature.producto.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCreateRequestDto {

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "El código es requerido")
    private String codigo;

    @NotBlank(message = "La descripción es requerida")
    private String descripcion;

    @NotNull(message = "El precio es requerido")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;

    @NotNull(message = "El stock es requerido")
    @PositiveOrZero(message = "El stock no puede ser negativo")
    private Integer stock;


    @NotNull(message = "La categoría es requerida")
    private Long categoriaId;

}
