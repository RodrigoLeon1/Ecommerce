package com.rodrigoleon.ecommerce.repositories;

import com.rodrigoleon.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.externalId = :externalId")
    Optional<Product> findByExternalId(@Param("externalId") String externalId);

    Page<Product> findByDisabledAtIsNull(Pageable pageable);
}
