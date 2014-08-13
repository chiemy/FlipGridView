package com.tjerkw.slideexpandable.library;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

/**
 * Simple subclass of listview which does nothing more than wrap
 * any ListAdapter in a SlideExpandalbeListAdapter
 */
public class FlipGridView extends GridView {
	private FlipListAdapter adapter;

	public FlipGridView(Context context) {
		super(context);
	}

	public FlipGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public FlipGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * Collapses the currently open view.
	 *
	 * @return true if a view was collapsed, false if there was no open view.
	 */
	public boolean collapse() {
		if(adapter!=null) {
			return adapter.collapseLastOpen();
		}
		return false;
	}

	public void setAdapter(ListAdapter adapter) {
		this.adapter = new FlipListAdapter(adapter);
		super.setAdapter(this.adapter);
	}

	@Override
	public Parcelable onSaveInstanceState() {
		return adapter.onSaveInstanceState(super.onSaveInstanceState());
	}

	@Override
	public void onRestoreInstanceState(Parcelable state) {
		if(!(state instanceof AbstractSlideExpandableListAdapter.SavedState)) {
			super.onRestoreInstanceState(state);
			return;
		}

		AbstractFlipListAdapter.SavedState ss = (AbstractFlipListAdapter.SavedState)state;
		super.onRestoreInstanceState(ss.getSuperState());

		adapter.onRestoreInstanceState(ss);
	}
}