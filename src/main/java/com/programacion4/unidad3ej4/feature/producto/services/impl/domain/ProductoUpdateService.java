package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import com.programacion4.unidad3ej4.config.exceptions.BadRequestException;
import com.programacion4.unidad3ej4.config.exceptions.NotFoundException;
import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej4.feature.producto.models.Categoria;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.ICategoriaRepository;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductoUpdateService implements IProductoUpdateService {

    private final IProductoRepository productoRepository;
    private final ICategoriaRepository categoriaRepository;

    @Override
    public ProductoResponseDto update(Long id, ProductoCreateRequestDto dto) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        if (producto.isEstaEliminado()) {
            throw new NotFoundException("Producto no encontrado");
        }

        if (!producto.getNombre().equalsIgnoreCase(dto.getNombre())
                && productoRepository.existsByNombre(dto.getNombre())) {
            throw new BadRequestException("El producto ya existe");
        }

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));

        String nombre = capitalizar(dto.getNombre());
        String descripcion = capitalizar(dto.getDescripcion());

        producto.setNombre(nombre);
        producto.setCodigo(dto.getCodigo());
        producto.setDescripcion(descripcion);
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setCategoria(categoria);

        productoRepository.save(producto);

        return ProductoMapper.toResponseDto(producto);
    }

    private String capitalizar(String texto) {
        texto = texto.toLowerCase();
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}