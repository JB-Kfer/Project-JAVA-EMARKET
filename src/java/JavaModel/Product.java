/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaModel;

import java.io.Serializable;

public class Product implements Serializable {

    private Integer id;
    private String name;
    private Double salePrice;

    public Product() {
        // Default constructor
    }
    
    public Product(int id, String name, double salePrice) {
    this.id = id;
    this.name = name;
    this.salePrice = salePrice;
}
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }
}