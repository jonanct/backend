package com.unir_app.buscadorservice.service;

import com.unir_app.buscadorservice.model.Producto;
import com.unir_app.buscadorservice.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public Producto guardarProducto(Producto producto) {
        return repository.save(producto);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public Iterable<Producto> obtenerTodos() {
        return repository.findAll();
    }
}
