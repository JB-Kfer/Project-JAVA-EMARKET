package logic;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import JavaModel.Product;
import JavaModel.ShoppingCartItem;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Named
@SessionScoped
public class ShoppingCartManager implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<ShoppingCartItem> cart;
    private Product prodToAdd;

    public ShoppingCartManager() {
        cart = new ArrayList<>();
    }

    public Product getProdToAdd() {
        return prodToAdd;
    }

    public void setProdToAdd(Product prodToAdd) {
        this.prodToAdd = prodToAdd;
    }

    public String addToCart() {
        cart.add(new ShoppingCartItem(cart.size() + 1, 1, prodToAdd));
        return "toShoppingCart";
    }

    @PostConstruct
    public void initCart() {
        cart.add(new ShoppingCartItem(1, 2, new Product(101, "Pommes", 1.99)));
        cart.add(new ShoppingCartItem(2, 1, new Product(202, "Oranges", 2.99)));
        cart.add(new ShoppingCartItem(3, 5, new Product(303, "Bananes", 0.99)));
    }

    public List<ShoppingCartItem> getCart() {
        return cart;
    }

    public void setCart(List<ShoppingCartItem> cart) {
        this.cart = cart;
    }

    public String addProductToCart(Product product) {
        if (product == null) {
            return null;
        }

        for (ShoppingCartItem item : cart) {
            if (item.getProduct() != null && item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + 1);
                return "toShoppingcart";
            }
        }

        cart.add(new ShoppingCartItem(cart.size() + 1, 1, product));
        return "toShoppingcart";
    }

    public void removeFromCart(ShoppingCartItem item) {
        cart.remove(item);
    }

    public void updateItemQuantity(ShoppingCartItem item, Integer newQuantity) {
        if (newQuantity > 0) {
            item.setQuantity(newQuantity);
        } else {
            removeFromCart(item);
        }
    }

    public double getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (ShoppingCartItem item : cart) {
            if (item != null && item.getProduct() != null) {
                BigDecimal itemTotal = BigDecimal.valueOf(item.getProduct().getSalePrice())
                        .multiply(BigDecimal.valueOf(item.getQuantity()));
                total = total.add(itemTotal);
            }
        }

        return total.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
