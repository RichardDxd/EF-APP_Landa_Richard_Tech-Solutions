package pe.edu.cibertec.tech_solutions_inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.tech_solutions_inventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
