package com.onlineshopping.model;

import javax.persistence.*;

@Entity
@Table (name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "iduser")
    private Integer idUser;

    @Column(name = "idproduct")
    private Integer idProduct;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "seenByWorker")
    private Boolean seenByWorker;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="iduser",insertable=false,updatable=false)
    private User user;

    public User getUser() {
        return user;
    }

    public Orders(Integer idUser, Integer idProduct, Integer quantity) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.seenByWorker = false;
    }

    public Orders() {

    }


    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer user) {
        this.idUser = user;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer cantity) {
        this.quantity = cantity;
    }

    public Boolean getSeenByWorker() {
        return seenByWorker;
    }

    public void setSeenByWorker(Boolean seenByWorker) {
        this.seenByWorker = seenByWorker;
    }
}
