package logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

import JavaModel.Product;
import jakarta.annotation.PostConstruct;

@Named
@ApplicationScoped
public class catalogManager implements Serializable {

    private ArrayList<Product> catalog;

    public catalogManager() {
    }

    @PostConstruct
    public void initCatalog() {
        catalog = new ArrayList<>();
        catalog.add(new Product(1, "Banana", 10.0));
        catalog.add(new Product(2, "Apple", 20.0));
        catalog.add(new Product(3, "Carrot", 30.0));
    }

    // Getter for the list of products
    public ArrayList<Product> getCatalog() {
        return catalog;
    }

    // Setter for the list of products
    public void setCatalog(ArrayList<Product> catalog) {
        this.catalog = catalog;
    }

    // Method to add a product to the catalog
    public void createProduct(Product product) {
        catalog.add(product);
    }

    // Method to remove a product from the catalog
    public void removeProduct(Product product) {
        catalog.remove(product);
    }

    // Method to update a product in the catalog
    public void updateProduct(Product oldProduct, Product newProduct) {
        int index = catalog.indexOf(oldProduct);
        if (index != -1) {
            catalog.set(index, newProduct);
        }
    }

    // Method to create a new product with form field values
    public String createProduct(Integer id, String name, Double salePrice) {
        Product newProduct = new Product(id,name, salePrice);
        createProduct(newProduct);
        return "toCatalog"; // You can return a string that corresponds to the navigation rule for the successful creation of a product
    }

}

