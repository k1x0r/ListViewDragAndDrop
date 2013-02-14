package com.example.listviewdraganddrop.listview;


import com.example.listviewdraganddrop.R;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.DragEvent;
import android.view.View;
import android.view.View.*;


public class ListViewItem extends LinearLayout implements OnDragListener, OnLongClickListener {

	private ListViewData data;
	private ListViewAdapter adapter;
	private TextView textData;
	private Context context;

	private boolean containsDragable;
	
	public ListViewItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOnDragListener(this);
		setOnLongClickListener(this);
		this.context = context;
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		textData = (TextView)findViewById(R.id.textView1);
	}

	@Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        int dragAction = dragEvent.getAction();
        ListViewItem lView = (ListViewItem) view;
        ListViewItem dragView = (ListViewItem) dragEvent.getLocalState();
        if (dragAction == DragEvent.ACTION_DRAG_EXITED) {
            containsDragable = false;
        } else if (dragAction == DragEvent.ACTION_DRAG_ENTERED) {
            containsDragable = true;
        } else if (dragAction == DragEvent.ACTION_DRAG_ENDED) {
            if (dropEventNotHandled(dragEvent)) {
                dragView.setVisibility(View.VISIBLE);
            }
        } else if (dragAction == DragEvent.ACTION_DROP && containsDragable) {
        	adapter.replace(lView.getData(), dragView.getData());
        }
        return true;
    }
	
	private boolean dropEventNotHandled(DragEvent dragEvent) {
		        return !dragEvent.getResult();
		}

	@Override
	public boolean onLongClick(View view) {
        ClipData clipData = ClipData.newPlainText("", "");
        View.DragShadowBuilder dsb = new View.DragShadowBuilder(view);
        view.startDrag(clipData, dsb, view, 0);
//      view.setVisibility(View.INVISIBLE);
        return true;	
	}


	public ListViewData getData() {
		return data;
	}

	public void setData(ListViewData data)
	{
		this.data = data;
		textData.setText(data.getText());
	}

	public ListViewAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(ListViewAdapter adapter) {
		this.adapter = adapter;
	}
	
	
}
