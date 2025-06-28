package com.prueba.producto.model.repositories;

import com.prueba.producto.model.entities.Orden;
import com.prueba.producto.model.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    // Consulta de órdenes por usuario con paginación
    Page<Orden> findByUsuario(String usuario, Pageable pageable);

    // Consulta de órdenes por producto (útil para depuración o estadísticas)
    Page<Orden> findByProducto(Producto producto, Pageable pageable);
}
