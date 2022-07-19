package com.gestion.producto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestion.producto.entidades.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
	
	@Query("SELECT p FROM Producto p WHERE "
			+ " CONCAT(p.id, p.nombre, p.marca, p.hechoEn, p.precio)"
			+ " LIKE %?1%" )//estoy haciendo una query donde voy a buscar al producto por todos los campos con un concat
	public List<Producto> findAll(String palabraClave);

}
