package com.programacion4.unidad3ej4.feature.producto.controllers.put;

import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoUpdateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoUpdateController {

    private final IProductoUpdateService productoUpdateService;

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductoCreateRequestDto dto) {

        return ResponseEntity.ok(productoUpdateService.update(id, dto));
    }
}