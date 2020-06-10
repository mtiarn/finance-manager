/*
 * Copyright (c) 2015.
 */

package com.mtiarn.finance.tag;

/**
 * listener for tag delete
 */
public interface OnTagDeleteListener {
	void onTagDeleted(TagView view, Tag tag, int position);
}