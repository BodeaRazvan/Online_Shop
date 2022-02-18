package com.onlineshopping.model;

public class OrderText {
    private int id;
    private String username;
    private String product;
    private int pId;
    private int quantity;

    public OrderText(int id,String u,String p,int pId,int quantity){
        this.id=id;
        this.username=u;
        this.product=p;
        this.quantity=quantity;
        this.pId=pId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }
}
