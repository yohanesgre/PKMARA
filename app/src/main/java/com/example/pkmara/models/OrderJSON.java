package com.example.pkmara.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class OrderJSON {
    JSONObject orderObject;
    MenuObject menuObject;
    ArrayList<MenuObject> arrMenuObj;

    public OrderJSON(String n, int s){
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

    public String getStringSeat(){
        int seat = 0;
        String s = "";
        try{
            seat = orderObject.getInt("seat");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        s = String.valueOf(seat);
        return s;
    }

    public void addMenuObj (MenuObject mO){
        menuObject = mO;
        arrMenuObj.add(menuObject);
    }

    public void removeMenuObj (String menuName){
        int index = searchMenu(menuName);
        arrMenuObj.remove(index);
    }

    public void updateMenuObj (String menuName, int quantity){
        MenuObject mMO = new MenuObject();
        mMO.setMenuName(menuName);
        mMO.setQuantitiy(quantity);
        int index = searchMenu(menuName);
        arrMenuObj.set(index, mMO);
    }

    private int searchMenu (String menuName){
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
}

