package com.unir_app.buscadorservice.repository;

import com.unir_app.buscadorservice.model.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends ElasticsearchRepository<Producto, String> {
    List<Producto> findByNombre(String nombre);
}
