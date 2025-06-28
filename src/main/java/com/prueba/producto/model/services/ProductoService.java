package com.prueba.producto.model.services;

import com.prueba.producto.model.entities.Producto;
import com.prueba.producto.model.repositories.ProductoRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Page<Producto> listarConFiltros(String nombre, BigDecimal precioMin, BigDecimal precioMax, Pageable pageable) {
        Specification<Producto> spec = (root, query, cb) -> {
            Predicate predicate = cb.conjunction();
            if (nombre != null && !nombre.isEmpty()) {
                predicate = cb.and(predicate, cb.like(cb.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"));
            }
            if (precioMin != null) {
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("precio"), precioMin));
            }
            if (precioMax != null) {
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("precio"), precioMax));
            }
            return predicate;
        };
        return productoRepository.findAll(spec, pageable);
    }

    public List<Producto> listarTodo() {
        return productoRepository.findAll(Sort.by("nombre"));
    }
}

