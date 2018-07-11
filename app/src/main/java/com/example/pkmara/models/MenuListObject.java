package com.example.pkmara.models;

public class MenuListObject {

    private int id;
    private String menuName;
    private int categoryId;
    private int price;

    public MenuListObject(int id, String menuName, int categoryId, int price) {
        this.id = id;
        this.menuName = menuName;
        this.categoryId = categoryId;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
