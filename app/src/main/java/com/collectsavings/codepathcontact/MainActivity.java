package com.collectsavings.codepathcontact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lookup the the Recycler view in the activity
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        //Initialize contacts
        contacts = Contact.createContactsList(20);
        //Create adapter passing in the sample user data
        ContactsAdapter adapter =  new ContactsAdapter(contacts);
        //Attach the adapter to the recycler view to populate items
        rvContacts.setAdapter(adapter);
        //set the layout manager to position the item
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all
    }
}
