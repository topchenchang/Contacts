package com.orange.peoplemanage;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.Contacts.People;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.orange.phonemanage.Main;
import com.orange.phonemanage.R;

public class PeopleInfo extends Activity{

	private ImageView p_imageView;
	private EditText e_p_name;
	private EditText e_p_phone;
	private EditText p_email; 
	private EditText p_birthday;
	private EditText p_qq;
	private EditText p_address;
	private String p_name;
	private String p_phone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.people_info);
		e_p_name=(EditText)findViewById(R.id.e_p_name);
		e_p_phone=(EditText)findViewById(R.id.e_p_phone);
	    Bundle bundle= this.getIntent().getExtras();
	    String name=bundle.getString("name");
	    String phone=bundle.getString("phone");
    
	    e_p_name.setText(name);
	    e_p_phone.setText(phone);
	    
	    
	    
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(0, 1, 1, "Cancel");
		menu.add(0,2,2,"Save");
		return super.onCreateOptionsMenu(menu);
	}
	@SuppressWarnings("deprecation")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		if(item.getItemId()== 1){
			Toast to= Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT);
			to.show();
			Intent intent =new Intent(PeopleInfo.this ,Main.class);
			startActivity(intent);
		}
		else if(item.getItemId()==2){
//			ContentResolver resolver= this.getContentResolver();
//			Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
			
			
//			long id =ContentUris.parseId(resolver.insert(uri,values));
			//add name
			
			
//			uri= Uri.parse("content://com.android.contacts/data");
//			values.put("raw_contact_id", id);
//			values.put("data2", "chenchang");
//			values.put("mimetype", "vnd.android.cursor.item/name");
//			resolver.insert(uri, values);
			
			
			p_name=e_p_name.getText().toString();
		    p_phone=e_p_phone.getText().toString();
			ContentValues  values= new ContentValues();
			values.put(People.NAME, p_name);
			Uri uri=getContentResolver().insert(People.CONTENT_URI, values);
			Uri numberUri=Uri.withAppendedPath(uri, People.Phones.CONTENT_DIRECTORY);
			values.clear();
			values.put(Contacts.Phones.TYPE, People.Phones.TYPE_MOBILE);
			values.put(People.NUMBER, p_phone);
			getContentResolver().insert(numberUri, values);
			
			values.clear();
			
			
			
			
			
	
			Toast to= Toast.makeText(this, "Ìí¼Ó³É¹¦", Toast.LENGTH_SHORT);
			to.show();
			
			Intent intent =new Intent(PeopleInfo.this ,Main.class);
			startActivity(intent);
			
		}
	
		return super.onOptionsItemSelected(item);
	}

	
}
