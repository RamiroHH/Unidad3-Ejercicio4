package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import com.programacion4.unidad3ej4.config.exceptions.NotFoundException;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoDeleteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductoDeleteService implements IProductoDeleteService {

    private final IProductoRepository productoRepository;

    @Override
    public void delete(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        if (producto.isEstaEliminado()) {
            throw new NotFoundException("Producto no encontrado");
        }

        producto.setEstaEliminado(true);

        productoRepository.save(producto);
    }
}