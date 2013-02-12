package com.example.listviewdraganddrop.listview;

import java.io.IOException;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListViewItem extends LinearLayout {

	private ListViewData data;

	private TextView textData;
	private ImageView imageData;
	private Context context;
	private Bitmap bitmap;


	String url;
	
	public ListViewItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();

	}
	
	public void setData(ListViewData tweet)
	{
		this.data = tweet;
		
	}
		

	

}
