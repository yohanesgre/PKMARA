package com.example.pkmara.models;

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
        int index = searchMenu(menuName);
        arrMenuObj.remove(index);
    }

    public void updateMenuObjByObject(MenuObject mO){
        arrMenuObj.set(searchMenu(mO.getMenuName()), mO);
    }

    public void updateMenuObjByValue (String menuName, int quantity, int price){
        MenuObject mMO = new MenuObject();
        mMO.setMenuName(menuName);
        mMO.setQuantitiy(quantity);
        mMO.setPrice(price);
        int index = searchMenu(menuName);
        arrMenuObj.set(index, mMO);
    }

    public MenuObject getMenuByName(String menuName){
        MenuObject menu = arrMenuObj.get(searchMenu(menuName));
        return menu;
    }

    public int searchMenu (String menuName){
        boolean found = false;
        Iterator<MenuObject> iter = arrMenuObj.iterator();
        MenuObject curMO = null;
        int pos = 0;
        while (iter.hasNext() == true){
            pos++;
            curMO = (MenuObject)iter.next();
            if ((curMO.getMenuName()).equals(menuName)){
                found = true;
                break;
            }
        }
        if (found == false){
            pos = 0;
        }
        return pos;
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

