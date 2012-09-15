package org.syxc.tabdemo;

import org.syxc.tabdemo.ui.base.BaseActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;

public class MainActivity extends BaseActivity {

	//public static MainActivity main = null;
	
	public final int FRAGMENT_LOGIN = 0x01;
	public final int FRAGMENT_HOME = 0x02;
	public final int FRAGMENT_ABOUT = 0x03;
	
	private boolean isAutoLogin = false;
	
	public final Handler mHandler = new Handler() {
		
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case FRAGMENT_LOGIN:
				goLogin();
				break;
				
			case FRAGMENT_HOME:
				goHome();
				break;
				
			case FRAGMENT_ABOUT:
				goAbout();
				break;
			}
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//main = this;
		
		if (isAutoLogin) {
			mHandler.sendEmptyMessage(FRAGMENT_HOME);
		} else {
			mHandler.sendEmptyMessage(FRAGMENT_LOGIN);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
}
