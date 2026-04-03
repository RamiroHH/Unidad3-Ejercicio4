package com.programacion4.unidad3ej4.feature.producto.controllers.patch;

import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoPatchRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoPatchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoPatchController {

    private final IProductoPatchService productoPatchService;

    @PatchMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> patch(
            @PathVariable Long id,
            @RequestBody ProductoPatchRequestDto dto) {

        return ResponseEntity.ok(productoPatchService.patch(id, dto));
    }
}