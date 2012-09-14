package org.syxc.tabdemo;

import org.syxc.tabdemo.ui.AndroidFragment;
import org.syxc.tabdemo.ui.DummyTabContent;
import org.syxc.tabdemo.ui.IOSFragment;
import org.syxc.tabdemo.ui.MoreFragment;
import org.syxc.tabdemo.ui.WP8Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	
	private TabHost mTabHost;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup();
		
		final TabHost.OnTabChangeListener tabChangeListener = setupOnTabChangeListener();
		
		mTabHost.setOnTabChangedListener(tabChangeListener);
		
		setupTabSpec();
	}

	private TabHost.OnTabChangeListener setupOnTabChangeListener() {
		TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				FragmentManager fm = getSupportFragmentManager();
				AndroidFragment androidFragment = (AndroidFragment) fm.findFragmentByTag("android");
				IOSFragment iosFragment = (IOSFragment) fm.findFragmentByTag("ios");
				WP8Fragment wp8Fragment = (WP8Fragment) fm.findFragmentByTag("wp8");
				MoreFragment moreFragment = (MoreFragment) fm.findFragmentByTag("more");
				
				FragmentTransaction ft = fm.beginTransaction();
				
				if (androidFragment != null) {
					ft.detach(androidFragment);
				}
				
				if (iosFragment != null) {
					ft.detach(iosFragment);
				}
				
				if (wp8Fragment != null) {
					ft.detach(wp8Fragment);
				}
				
				if (moreFragment != null) {
					ft.detach(moreFragment);
				}
				
				if (tabId.equalsIgnoreCase("android")) {
					if (androidFragment == null) {
						ft.add(R.id.realtabcontent, new AndroidFragment(), "android");
					} else {
						ft.attach(androidFragment);
					}
				} else if (tabId.equalsIgnoreCase("ios")) {
					if (iosFragment == null) {
						ft.add(R.id.realtabcontent, new IOSFragment(), "ios");
					} else {
						ft.attach(iosFragment);
					}
				} else if (tabId.equalsIgnoreCase("wp8")) {
					if (wp8Fragment == null) {
						ft.add(R.id.realtabcontent, new WP8Fragment(), "wp8");
					} else {
						ft.attach(wp8Fragment);
					}
				} else if (tabId.equalsIgnoreCase("more")) {
					if (moreFragment == null) {
						ft.add(R.id.realtabcontent, new MoreFragment(), "more");
					} else {
						ft.attach(moreFragment);
					}
				}
				ft.commit();
			}
		};
		return tabChangeListener;
	}

	private void setupTabSpec() {
		TabHost.TabSpec specAndroid = mTabHost.newTabSpec("android");
		specAndroid.setIndicator(setupIndicator("Android", R.drawable.tab_info));
		specAndroid.setContent(new DummyTabContent(getBaseContext()));
		mTabHost.addTab(specAndroid);
		
		TabHost.TabSpec specIOS = mTabHost.newTabSpec("ios");
		specIOS.setIndicator(setupIndicator("iOS", R.drawable.tab_info));
		specIOS.setContent(new DummyTabContent(getBaseContext()));
		mTabHost.addTab(specIOS);
		
		TabHost.TabSpec specWP8 = mTabHost.newTabSpec("wp8");
		specWP8.setIndicator(setupIndicator("WP8", R.drawable.tab_info));
		specWP8.setContent(new DummyTabContent(getBaseContext()));
		mTabHost.addTab(specWP8);
		
		TabHost.TabSpec specMore = mTabHost.newTabSpec("more");
		specMore.setIndicator(setupIndicator("More", R.drawable.tab_info));
		specMore.setContent(new DummyTabContent(getBaseContext()));
		mTabHost.addTab(specMore);
		
		mTabHost.setCurrentTab(0);
		
		TabWidget tabWidget = mTabHost.getTabWidget();
		for (int i = 0; i < tabWidget.getChildCount(); i++) {
			RelativeLayout layout = (RelativeLayout) tabWidget.getChildAt(i);
			layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.tab_indicator));
		}
	}
	
	private View setupIndicator(String label, int drawableId) {
		final View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.tab_indicator, mTabHost.getTabWidget(), false);
		((TextView) view.findViewById(R.id.title)).setText(label);
		((ImageView) view.findViewById(R.id.icon)).setImageResource(drawableId);
		return view;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
