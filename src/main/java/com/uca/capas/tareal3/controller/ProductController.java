package com.uca.capas.tareal3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tareal3.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	
	@GetMapping("/comprarProducto")
	public ModelAndView comprarProducto() {
		ModelAndView mav = new ModelAndView();
		productos.clear();
		productos.add(new Product(0, "Naranjas", 9));
		productos.add(new Product(1, "Manzanas", 7));
		productos.add(new Product(2, "Peras", 5));
		productos.add(new Product(3, "Tomates", 3));
		productos.add(new Product(4, "Lechugas", 1));
		
		mav.setViewName("productos");
		mav.addObject("product",new Product());
		mav.addObject("products", productos);
		
		return mav;
		
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		
		if(productos.get(product.getId()).getCantidad() < product.getCantidad()) {
			mav.addObject("result", "El producto "+ productos.get(product.getId()).getNombre() + " no se puede adquirir");
			mav.setViewName("error");
			return mav;
		}
		else {
			mav.addObject("result", "El producto "+ productos.get(product.getId()).getNombre() + " se adquirio");
			mav.setViewName("compra");
			return mav;
		}
	}
	
}
