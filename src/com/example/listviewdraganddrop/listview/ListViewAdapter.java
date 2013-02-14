package com.example.listviewdraganddrop.listview;

import java.util.LinkedList;

import com.example.listviewdraganddrop.R;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListViewAdapter extends BaseAdapter {
	
    private LinkedList<ListViewData> list;
	private Context context;


	public ListViewAdapter(Context context)
    {
		this.context = context;
    	list = new LinkedList<ListViewData>();   	
    }
    
    public void add(ListViewData data)
    {
    	list.add(data);
    }
    
    public void replace(ListViewData el1, ListViewData el2) {
    	    	
    	int index1 = list.indexOf(el1);
    	int index2 = list.indexOf(el2);
    	list.set(index1, el2);
    	list.set(index2, el1);
       	
    	notifyDataSetChanged();
    }
    
    public void clear()
    {
    	list.clear(); 	
    }
    
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int num) {
		return (list == null )? null :list.get(num);
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ListViewItem tweetItem;
		if(null == convertView)
		{
			tweetItem = (ListViewItem)View.inflate(context, R.layout.item_listview, null);
		}
		else 
		{
			tweetItem = (ListViewItem)convertView;
		}
		
		tweetItem.setData(list.get(position));
		tweetItem.setAdapter(this);
		
		return tweetItem;
	}
	
    @Override
	public String toString() {
		return list.toString();
	}

	
}

