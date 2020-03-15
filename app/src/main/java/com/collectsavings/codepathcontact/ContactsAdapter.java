package com.collectsavings.codepathcontact;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Stanwaves on 12/16/2019.
 */

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview

        public ViewHolder(View itemView){
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.

            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }

    }

    //Store member variable for the contacts

    private List<Contact> mContacts;

    //Pass in the contact arrary into the constructor
    public ContactsAdapter(List<Contact> contacts){
        mContacts =  contacts;
    }

//    usually this involves inflating  a layout from XML and returning the holder

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context =  parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_contact, parent, false);


        //return a new holder instance
        ViewHolder viewHolder =  new ViewHolder(contactView);
        return viewHolder;

    }

//    Involves populating data onto item through
    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder viewHolder, int position){
        //Get data model based on position
        Contact contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(contact.getName());
        Button button =  viewHolder.messageButton;
        button.setText(contact.isOnline() ? "Message" : "Offline" );
        button.setEnabled(contact.isOnline());
    }

    //Return the total count of item int the list

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
