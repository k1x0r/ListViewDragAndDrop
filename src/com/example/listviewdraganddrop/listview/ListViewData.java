package com.example.listviewdraganddrop.listview;

import android.graphics.Bitmap;

public class ListViewData {

	private String text;
	private Bitmap bitmap;
	

	public Bitmap getBitmap() {
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
