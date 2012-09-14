package org.syxc.tabdemo.ui;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

public class DummyTabContent implements TabContentFactory {
	
	private Context mContext;
	
	public DummyTabContent(Context context) {
		mContext = context;
	}

	@Override
	public View createTabContent(String tag) {
		final View view = new View(mContext);
		return view;
	}

}
