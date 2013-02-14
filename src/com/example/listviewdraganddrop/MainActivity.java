package com.example.listviewdraganddrop;

import com.example.listviewdraganddrop.listview.ListViewAdapter;
import com.example.listviewdraganddrop.listview.ListViewData;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListViewAdapter listViewAdapter;
	private ListView listView;
	private Button printButton;


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
		
		printButton = (Button) findViewById(R.id.printButton);
		printButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("ListDragAndDrop", listViewAdapter.toString());
			}
		});
		
		fillAdapter();
	}

	
	private void fillAdapter() {
		for(int i = 0; i < 20; i++) {
			listViewAdapter.add(new ListViewData("Item "+ i));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	

}
