package am.itspace.productcategoryservice.repository;

import am.itspace.productcategoryservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Integer> {
    List<Product> findAllByCategoryId(int id);

}
