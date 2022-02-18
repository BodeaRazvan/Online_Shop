package com.onlineshopping.model;

public class Photo {
    private String id;
    private String source;

    public Photo(String id,String source){
        this.id=id;
        this.source=source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
