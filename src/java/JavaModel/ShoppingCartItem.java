package JavaModel;

import java.io.Serializable;

public class ShoppingCartItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer quantity;
    private Product product;

    public ShoppingCartItem() {
        
    }

    public ShoppingCartItem(Integer id, Integer quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
