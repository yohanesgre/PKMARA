package com.example.pkmara.models;

public class MenuObject{
    String menuName;
    int quantitiy;
    int price;

    public MenuObject(){

    }

    public MenuObject (String m, int q, int p){
        menuName = m;
        quantitiy = q;
        price = p;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setQuantitiy(int quantitiy) {
        this.quantitiy = quantitiy;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getQuantitiy() {
        return quantitiy;
    }

    public double getPrice() {
        return price;
    }
}