package com.unir_app.buscadorservice.controller;

import com.unir_app.buscadorservice.model.Producto;
import com.unir_app.buscadorservice.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return service.guardarProducto(producto);
    }

    @GetMapping("/buscar")
    public List<Producto> buscarPorNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping
    public Iterable<Producto> obtenerTodos() {
        return service.obtenerTodos();
    }
}
