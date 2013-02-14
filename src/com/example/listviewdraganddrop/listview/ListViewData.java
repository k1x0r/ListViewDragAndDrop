package com.example.listviewdraganddrop.listview;

import android.graphics.Bitmap;

public class ListViewData {

	private String text;
	private Bitmap bitmap;
	
	public ListViewData(String text)
	{
		this.text = text;
	}
	
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
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof ListViewData) {
			return ((ListViewData) o).getText().equals(text);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return text.hashCode();
	}
	
	@Override
	public String toString() {
		return text;
	}
}
