package com.example.pkmara.models;

import android.view.Menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OrderJSON {
    JSONObject orderObject;
    MenuObject menuObject;
    ArrayList<MenuObject> arrMenuObj;
    Set<MenuObject> setMenuObj;
    Gson objGson;

    public OrderJSON(String n, int s){
        objGson = new GsonBuilder().setPrettyPrinting().create();
        orderObject = new JSONObject();
        arrMenuObj = new ArrayList<MenuObject>();
        try{
            orderObject.put("custName", n);
            orderObject.put("seat", s);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    public String getName(){
        String name = "";
        try{
            name = orderObject.getString("custName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return name;
    }

    public int getSeat(){
        int seat = 0;
        try{
            seat = orderObject.getInt("seat");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return seat;
    }

    public void addMenuObj (MenuObject mO){
        menuObject = mO;
        arrMenuObj.add(mO);
    }

    public void removeMenuObj (String menuName){
        arrMenuObj.remove(findIndexMenuObjectByName(menuName));
    }

    public void updateMenuObjByObject(MenuObject mO){
        arrMenuObj.set(findIndexMenuObjectByName(mO.getMenuName()), mO);
    }

    public void updateMenuObjByValue (String menuName, int quantity, int price){
        MenuObject mMO = new MenuObject();
        mMO.setMenuName(menuName);
        mMO.setQuantitiy(quantity);
        mMO.setPrice(price);
        arrMenuObj.set(findIndexMenuObjectByName(menuName), mMO);
    }

    public MenuObject getMenuByName(String menuName){
        MenuObject menu = arrMenuObj.get(findIndexMenuObjectByName(menuName));
        return menu;
    }

    public int findIndexMenuObjectByName(String menuName) {
        int index = 0;
        for (MenuObject mO : arrMenuObj) {
            if (mO.getMenuName().equals(menuName)) {
                index = arrMenuObj.indexOf(mO);
                break;
            }
        }
        return index;
    }

    public void addMenuToOrderJson(){
        setMenuObj = new HashSet<>(arrMenuObj);
        try{
            orderObject.put("Menus", setMenuObj);
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public ArrayList<MenuObject> getArrMenuObj() {
        return arrMenuObj;
    }
}

