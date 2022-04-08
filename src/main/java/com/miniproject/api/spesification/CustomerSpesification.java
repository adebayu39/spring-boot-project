package com.miniproject.api.spesification;

import com.miniproject.api.dto.CustomerSearchDTO;
import com.miniproject.api.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpesification {
    public static Specification<Customer> getSpesification(CustomerSearchDTO customerSearchDTO) {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (!(customerSearchDTO.getSearchCustomerFirstName() == null)) {
                    Predicate customerNamePredicate = criteriaBuilder.like(root.get("firstName"), "%" + customerSearchDTO.getSearchCustomerFirstName() + "%");
                    predicates.add(customerNamePredicate);
                }
                if (!(customerSearchDTO.getSearchCustomerEmail() == null)) {
                    Predicate customerEmailPredicate = criteriaBuilder.like(root.get("email"), "%" + customerSearchDTO.getSearchCustomerEmail() + "%");
                    predicates.add(customerEmailPredicate);
                }
                if (!(customerSearchDTO.getSearchCustomerAddress() == null)) {
                    Predicate customerAddressPredicate = criteriaBuilder.like(root.get("address"), "%" + customerSearchDTO.getSearchCustomerAddress() + "%");
                    predicates.add(customerAddressPredicate);
                }
                if (!(customerSearchDTO.getSearchCustomerDateOfBirth() == null)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String modifiedDateFormated = sdf.format(customerSearchDTO.getSearchCustomerDateOfBirth());

                    final Predicate createdDataPredicate = criteriaBuilder.equal(criteriaBuilder.function("TO_CHAR",
                            String.class, root.get("dateOfBirth"), criteriaBuilder.literal("yyyy-MM-dd")), modifiedDateFormated);
                    predicates.add(createdDataPredicate);
                }
                Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicates);
            }
        };
    }
}
