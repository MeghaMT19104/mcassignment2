package com.example.mcassignment2;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class frag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag);
        fetchcontact();
    }
    private void fetchcontact()
    {
        ArrayList<String> contacts=new ArrayList<>();
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
        String selection=null;
        String[] selectionArgs=null;
        String sortOrder=null;
        ContentResolver resolver=getContentResolver();
        Cursor cursor=resolver.query(uri,projection,selection,selectionArgs,sortOrder);
        while(cursor.moveToNext())
        {
            String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String num=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contacts.add(name+"\n"+num);
        }
        ListView listView=(ListView)findViewById(R.id.listContacts);
        listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contacts));
    }
}

