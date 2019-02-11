package ca.nbcc.shoppinglist;

/*
    File:  ShoppingItems.java

    Author: Justin Lange
    This assignment represents my own work and is in accordance with the College Academic Policy

    Copyright(c) 2019 All Right Reserved by Justin Lange

    Date: 10-02-19
*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ShoppingItems extends AppCompatActivity {

    public static final String EXTRA_REPLY = "ca.nbcc.shoppinglist.ShoppingItems.extra.reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_items);
    }

    //Get the tag of the item that was selected and send it back to the main Activity as a result
    //The Tag of the button contains the name of the item that was clicked on
    public void selectItem(View view) {
        Intent reply = new Intent();
        String item = view.getTag().toString();

        reply.putExtra(EXTRA_REPLY, item);
        setResult(RESULT_OK, reply);
        finish();
    }
}
