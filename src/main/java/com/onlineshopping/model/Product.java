package com.onlineshopping.model;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Float price;
    private String pic1;
    private String pic2;
    private String pic3;

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

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic1() {return pic1;}

    public void setPic1(String pic1) {this.pic1 = pic1;}

    public String getPic2() {return pic2;}

    public void setPic2(String pic2) {this.pic2 = pic2;}

    public String getPic3() { return pic3;}

    public void setPic3(String pic3) { this.pic3 = pic3;}
}
