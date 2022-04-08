package com.miniproject.api.spesification;

import com.miniproject.api.dto.ProductSearchDTO;
import com.miniproject.api.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductSpesification {
    public static Specification<Product> getSpesification(ProductSearchDTO productSearchDTO) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (productSearchDTO.getSearchProductName() != null) {
                    Predicate productNamePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("productName")), "%" + productSearchDTO.getSearchProductName() + "%");
                    predicates.add(productNamePredicate);
                }
                Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicates);
            }
        };
    }
}
