package com.tjerkw.slideexpandable.library;

import android.view.View;
import android.widget.ListAdapter;

/**
 * ListAdapter that adds sliding functionality to a list.
 * Uses R.id.expandalbe_toggle_button and R.id.expandable id's if no
 * ids are given in the contructor.
 *
 * @author tjerk
 * @date 6/13/12 8:04 AM
 */
public class FlipListAdapter extends AbstractFlipListAdapter {
	private int front_view;
	private int behind_view;

	public FlipListAdapter(ListAdapter wrapped, int front_view, int behind_view) {
		super(wrapped);
		this.front_view = front_view;
		this.behind_view = behind_view;
	}

	public FlipListAdapter(ListAdapter wrapped) {
		this(wrapped, R.id.front_view, R.id.behind_view);
	}

	@Override
	public View getFlipFrontView(View parent) {
		return parent.findViewById(front_view);
	}

	@Override
	public View getFlipBehindView(View parent) {
		return parent.findViewById(behind_view);
	}
}
