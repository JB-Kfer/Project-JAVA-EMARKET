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

    // Attributs pour la création d'un produit via le formulaire
    private Integer productId;
    private String productName;
    private Double productPrice;

    public catalogManager() {
    }

    @PostConstruct
    public void initCatalog() {
        catalog = new ArrayList<>();
        catalog.add(new Product(1, "Banana", 10.0));
        catalog.add(new Product(2, "Apple", 20.0));
        catalog.add(new Product(3, "Carrot", 30.0));
    }

    public ArrayList<Product> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Product> catalog) {
        this.catalog = catalog;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    // Méthode utilisée par le formulaire pour créer un nouveau produit
    public String createProduct() {
        Product newProduct = new Product(productId, productName, productPrice);
        catalog.add(newProduct);
        return "toCatalog"; // Assurez-vous que cela correspond au from-outcome dans faces-config.xml
    }

}
