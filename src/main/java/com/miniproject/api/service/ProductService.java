package com.miniproject.api.service;

import com.miniproject.api.dto.ProductSearchDTO;
import com.miniproject.api.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public Product getProductById(Integer id);

    public Product saveProduct(Product product);

    public Product saveProductPicture(Product product, MultipartFile file);

    public List<Product> getAllProduct();

    public Page<Product> getProductsByPage(Pageable pageable, ProductSearchDTO productSearchDTO);

    public void editProduct(Product product);

    public void deleteProduct(Integer id);
}
