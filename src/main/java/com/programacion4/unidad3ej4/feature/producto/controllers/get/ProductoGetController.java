package com.programacion4.unidad3ej4.feature.producto.controllers.get;

import com.programacion4.unidad3ej4.config.BaseResponse;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoGetAllService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoGetController {

    private final IProductoGetAllService productoGetAllService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ProductoResponseDto>>> getAll() {

        return ResponseEntity.ok(
                BaseResponse.ok(
                        productoGetAllService.getAll(),
                        "Listado de productos"
                )
        );
    }
}