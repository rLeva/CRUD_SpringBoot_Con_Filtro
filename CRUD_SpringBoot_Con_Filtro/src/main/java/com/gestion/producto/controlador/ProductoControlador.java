package com.gestion.producto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.producto.entidades.Producto;
import com.gestion.producto.servicio.ProductoServicio;

@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoServicio servicio;
	
	@RequestMapping("/")
	public String verPaginaDeInicio(Model model,@Param("palabraClave") String palabraClave ) {
		//@Param es para pasar un parametro, en este caso será la palabraClave
		//lista productos
		List<Producto> listaProductos = servicio.listAll(palabraClave);

		//con esto en el html podemos acceder a la lista arriba creada.
		model.addAttribute("listaProductos",listaProductos);
		//pasamos al html la palabraClave para poder buscarla
				model.addAttribute("palabraClave", palabraClave);
		
		return "index";
	}
	
	@RequestMapping("/nuevo")
	public String mostrarFormuladoDeRegistro(Model model) {
		//Creamos una instancia de producto, sirve para indicarle un nuevo objeto que se va a guardar en la BBDD
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "nuevo_producto";
		
	}
	
	//método para guardar lo que introducimos en el formulario
	@RequestMapping(value="/guardar", method=RequestMethod.POST)
	public String guardarProducto(@ModelAttribute("producto") Producto producto) {
		servicio.save(producto);
		return "redirect:/";
		
	}
	
	//metodo para modificar producto
	@RequestMapping("/editar/{id}")
	//
	public ModelAndView mostrarFormuladoDeEditarProducto(@PathVariable(name="id") Long id) {
		//mando el producto a la vista editar
		ModelAndView modelo= new ModelAndView("editar_producto");
		//recogemos un producto por su id
		Producto producto = servicio.get(id);
		//añadimos un objeto 
		modelo.addObject("producto",producto);
		
		return modelo;
		
	}
	
	//metodo eliminar producto
	@RequestMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable(name="id") Long id) {
		servicio.delete(id);
		return "redirect:/";
	}
	

}
