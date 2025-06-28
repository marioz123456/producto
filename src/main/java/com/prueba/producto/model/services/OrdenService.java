package com.prueba.producto.model.services;

import com.prueba.producto.model.entities.Orden;
import com.prueba.producto.model.entities.Producto;
import com.prueba.producto.model.repositories.OrdenRepository;
import com.prueba.producto.model.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdenService {

    private final OrdenRepository ordenRepository;
    private final ProductoRepository productoRepository;

    @Transactional
    public Orden crearOrden(Orden orden) {
        Producto producto = productoRepository.findById(orden.getProducto().getId())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        if (producto.getStock() < orden.getCantidad()) {
            throw new IllegalArgumentException("Stock insuficiente para el producto solicitado");
        }

        // Actualizar stock
        producto.setStock(producto.getStock() - orden.getCantidad());
        productoRepository.save(producto);

        return ordenRepository.save(orden);
    }

    public Page<Orden> obtenerOrdenesPorUsuario(String usuario, Pageable pageable) {
        return ordenRepository.findByUsuario(usuario, pageable);
    }

    public Optional<Orden> obtenerPorId(Long id) {
        return ordenRepository.findById(id);
    }
}

