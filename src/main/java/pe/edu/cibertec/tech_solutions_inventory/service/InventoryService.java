package pe.edu.cibertec.tech_solutions_inventory.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.tech_solutions_inventory.model.Product;
import pe.edu.cibertec.tech_solutions_inventory.repository.ProductRepository;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private ProductRepository productRepository;

    @CircuitBreaker(name = "inventoryService") // Resiliencia aplicada aquí
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @CircuitBreaker(name = "inventoryService") // Resiliencia aplicada aquí
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @CircuitBreaker(name = "inventoryService") // Resiliencia aplicada aquí
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @CircuitBreaker(name = "inventoryService") // Resiliencia aplicada aquí
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
