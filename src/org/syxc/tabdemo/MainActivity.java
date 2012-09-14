package org.syxc.tabdemo;

import org.syxc.tabdemo.ui.AboutFragment;
import org.syxc.tabdemo.ui.HomeFragment;
import org.syxc.tabdemo.ui.LoginFragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	public static MainActivity main = null;
	
	public final int FRAGMENT_LOGIN = 0x01;
	public final int FRAGMENT_HOME = 0x02;
	public final int FRAGMENT_ABOUT = 0x03;
	
	private boolean isAutoLogin = false;
	
	public Handler mHandler = new Handler() {
		
		@Override
		public void handleMessage(Message msg) {
			final FragmentManager fm = getFragmentManager();
			final LoginFragment loginFragment = (LoginFragment) fm.findFragmentByTag("login");
			final HomeFragment homeFragment = (HomeFragment) fm.findFragmentByTag("home");
			final AboutFragment aboutFragment = (AboutFragment) fm.findFragmentByTag("about");
			FragmentTransaction ft = null;
			
			switch (msg.what) {
			case FRAGMENT_LOGIN: // Login
				ft = detachFragment(fm, loginFragment, homeFragment,
						aboutFragment, ft);
				
				if (loginFragment == null) {
					ft.add(R.id.main_container, new LoginFragment(), "login");
				} else {
					ft.attach(loginFragment);
				}
				
				ft.commit();
				
				break;
				
			case FRAGMENT_HOME: // Home
				ft = detachFragment(fm, loginFragment, homeFragment,
						aboutFragment, ft);
				
				if (homeFragment == null) {
					ft.add(R.id.main_container, new HomeFragment(), "home");
				} else {
					ft.attach(homeFragment);
				}
				
				ft.commit();
				break;
				
			case FRAGMENT_ABOUT: // About
				ft = detachFragment(fm, loginFragment, homeFragment,
						aboutFragment, ft);
				
				if (aboutFragment == null) {
					ft.add(R.id.main_container, new AboutFragment(), "about");
				} else {
					ft.attach(aboutFragment);
				}
				
				ft.commit();
				break;
			}
		}

		private FragmentTransaction detachFragment(final FragmentManager fm,
				final LoginFragment loginFragment,
				final HomeFragment homeFragment,
				final AboutFragment aboutFragment, FragmentTransaction ft) {
			if (ft == null) {
				ft = fm.beginTransaction();
			}
			
			if (loginFragment != null) {
				ft.detach(loginFragment);
			}
			
			if (homeFragment != null) {
				ft.detach(homeFragment);
			}
			
			if (aboutFragment != null) {
				ft.detach(aboutFragment);
			}
			return ft;
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		main = this;
		
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
	
	
	protected FragmentManager getFragmentManager() {
		return getSupportFragmentManager();
	}
}
