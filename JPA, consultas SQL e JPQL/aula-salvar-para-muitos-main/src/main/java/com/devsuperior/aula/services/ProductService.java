package com.devsuperior.aula.services;

import com.devsuperior.aula.dtos.CategoryDTO;
import com.devsuperior.aula.dtos.ProductDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        for (CategoryDTO catDto : dto.getCategories()) {
            Category cat = categoryRepository.getReferenceById(catDto.getId());
            entity.getCategories().add(cat);
        }

        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }
}
