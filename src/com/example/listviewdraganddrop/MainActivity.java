package com.example.listviewdraganddrop;

import com.example.listviewdraganddrop.listview.ListViewAdapter;
import com.example.listviewdraganddrop.listview.ListViewData;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListViewAdapter listViewAdapter;
	private ListView listView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setUpViews();
		
	}

	private void setUpViews() {
		setContentView(R.layout.activity_main);
		listViewAdapter = new ListViewAdapter(this);
		listView = (ListView)findViewById(R.id.listView1);
		listView.setAdapter(listViewAdapter);
		fillAdapter();
	}

	
	private void fillAdapter() {
		for(int i = 0; i < 20; i++) {
			listViewAdapter.add(new ListViewData());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
