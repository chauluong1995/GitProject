package com.kymdan.backend.services.product_type;

import com.kymdan.backend.entity.ProductType;
import com.kymdan.backend.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return this.productTypeRepository.findAll();
    }
}
