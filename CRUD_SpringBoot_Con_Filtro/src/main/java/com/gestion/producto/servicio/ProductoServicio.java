package com.gestion.producto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.producto.entidades.Producto;
import com.gestion.producto.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {
	
	@Autowired
	private ProductoRepositorio repo;
	
	//Metodo para listar todos los productos
	public List<Producto> listAll(String palabraClave){
		
		if(palabraClave !=null) {
			return repo.findAll(palabraClave);
		}
		
		return repo.findAll();
	}
	
	//Metodo para guardar
	public void save(Producto producto) {
		
		repo.save(producto);
	
	}
	
	//Metodo para obtener un producto
	public Producto get(Long id) {
		
		return repo.findById(id).get();
	}
	
	//Método para eliminar un producto por su id
	public void delete(Long id) {
		
		repo.deleteById(id);
	}

}
