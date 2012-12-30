package com.orange.phonemanage;


import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.orange.peoplemanage.ContactInfo;
import com.orange.peoplemanage.PeopleInfo;


/**
 * @author Orange
 * 
 */
public class MyAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Map<String, Object>> list;
	private int layoutID;
	private String flag[];
	private int ItemIDs[];
	private Context context;
	private ContactInfo contactInfo=null;
	

	public MyAdapter(Context context, List<Map<String, Object>> list,
			int layoutID, String flag[], int ItemIDs[],ContactInfo contactInfo) {
		this.mInflater = LayoutInflater.from(context);
		this.list = list;
		this.layoutID = layoutID;
		this.flag = flag;
		this.ItemIDs = ItemIDs;
		this.context=context;
		this.contactInfo=contactInfo;

		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = mInflater.inflate(layoutID, null);
		for (int i = 0; i < flag.length; i++) {//备注1
			if (convertView.findViewById(ItemIDs[i]) instanceof ImageView) {
				ImageView iv = (ImageView) convertView.findViewById(ItemIDs[i]);
				iv.setBackgroundResource((Integer) list.get(position).get(
						flag[i]));
			} else if (convertView.findViewById(ItemIDs[i]) instanceof TextView) {
				TextView tv = (TextView) convertView.findViewById(ItemIDs[i]);
				tv.setText((String) list.get(position).get(flag[i]));
			}else{
				//...备注2
			}
		}
		addListener(convertView);
		return convertView;
	}
/**
 * 只需要将需要设置监听事件的组件写在下面这方法里就可以啦！
 * 别的不需要修改！
 * 
 */
	public void addListener(View convertView) {
		((TextView)convertView.findViewById(R.id.bigtv)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	            String c_name=contactInfo.getC_name();
	            String c_phone=contactInfo.getC_phone();
                Intent intent=new Intent(context,PeopleInfo.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", c_name);
                bundle.putString("phone",c_phone);
                
                
                intent.putExtras(bundle);
                
				context.startActivity(intent);
	            
				
			}

			
		});
		((ImageButton)convertView.findViewById(R.id.btn)).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						String phone="tel:"+contactInfo.getC_phone();
						Uri uri =Uri.parse(phone);
						Intent intent =new Intent(Intent.ACTION_DIAL,uri);
						context.startActivity(intent);
						
//						new AlertDialog.Builder(Main.ma)
//						.setTitle("自定义通用SimpleAdapter")
//						.setMessage("按钮成功触发监听事件！")
//						.show();
					}
				});
		
		((ImageButton)convertView.findViewById(R.id.b_sendMassage)).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String smsphone="smsto:"+contactInfo.getC_phone();
				   Uri uri =Uri.parse(smsphone);
				   Intent intent= new Intent(Intent.ACTION_SENDTO,uri);
				   context.startActivity(intent);
			}
		});
			
			
		
	}
}