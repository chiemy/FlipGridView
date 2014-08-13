package com.example.viewflipdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tjerkw.slideexpandable.library.FlipGridView;

public class MainActivity extends Activity {
	private String [] arr = new String[20];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FlipGridView gridView = (FlipGridView) this.findViewById(R.id.flip_gridview);
		initData();
		gridView.setAdapter(new MyAdapter());
	}

	private void initData() {
		for(int i = 0 ; i < 20 ; i++){
			arr[i] = "android " + i;
		}
	}
	
	class MyAdapter extends BaseAdapter{
		@Override
		public int getCount() {
			return arr.length;
		}

		@Override
		public Object getItem(int arg0) {
			return arr[arg0];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null){
				convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.flip_gridview_item, parent,false);
				LayoutParams params = (LayoutParams) convertView.getLayoutParams();
				int width = (int)(parent.getWidth() - 2*getResources().getDimension(R.dimen.gridview_spacing))/ 3;
				params.width = width;
				params.height = width;
				convertView.setLayoutParams(params);
			}
			TextView frontView = (TextView) convertView.findViewById(R.id.front_view);
			frontView.setText(arr[position]);
			TextView behindView = (TextView) convertView.findViewById(R.id.behind_view);
			behindView.setText(arr[position] + " 1");
			return convertView;
		}
		
	}
	
}
