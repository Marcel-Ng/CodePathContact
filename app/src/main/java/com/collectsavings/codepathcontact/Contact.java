package com.collectsavings.codepathcontact;

import java.util.ArrayList;

/**
 * Created by Stanwaves on 12/16/2019.
 */

public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String name, boolean online){
        mName = name;
        mOnline = online;
    }

    public String getName(){
        return mName;
    }

    public boolean isOnline(){
        return mOnline;
    }


    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts =  new ArrayList<>();

        for (int i = 1; i <= numContacts; i++){
            contacts.add(new Contact("Person" + ++lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }
}
