package ca.nbcc.shoppinglist;

/*
    File:  ShoppingList.java

    Author: Justin Lange
    This assignment represents my own work and is in accordance with the College Academic Policy

    Copyright(c) 2019 All Right Reserved by Justin Lange

    Date: 10-02-19
*/

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShoppingList implements Serializable {

    //New String, Integer Map pair
    private Map shoppingList = new HashMap<String, Integer>();

    //Add an item to the shopping list
    public void addItemToList(String item) {
        if (shoppingList.containsKey(item)) {
            shoppingList.replace(item, (int) shoppingList.get(item) + 1);
        } else {
            shoppingList.put(item, 1);
        }
    }

    //Get the current shopping list
    public Map<String, Integer> getShoppingList() {
        return shoppingList;
    }
}
