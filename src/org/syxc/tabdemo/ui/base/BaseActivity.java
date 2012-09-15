package org.syxc.tabdemo.ui.base;

import org.syxc.tabdemo.R;
import org.syxc.tabdemo.ui.AboutFragment;
import org.syxc.tabdemo.ui.HomeFragment;
import org.syxc.tabdemo.ui.LoginFragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class BaseActivity extends FragmentActivity {
	
	protected void goLogin() {
		final FragmentManager fm = getFragmentManager();
		
		final LoginFragment loginFragment = (LoginFragment) fm.findFragmentByTag("login");
		final HomeFragment homeFragment = (HomeFragment) fm.findFragmentByTag("home");
		
		final FragmentTransaction ft = fm.beginTransaction();
		
		if (homeFragment != null) {
			ft.remove(homeFragment);
		}
		
		if (loginFragment == null) {
			ft.replace(R.id.main_container, new LoginFragment(), "login");
		} else {
			ft.attach(loginFragment);
		}
		
		ft.commit();
	}
	
	protected void goHome() {
		final FragmentManager fm = getFragmentManager();
		
		final LoginFragment loginFragment = (LoginFragment) fm.findFragmentByTag("login");
		final HomeFragment homeFragment = (HomeFragment) fm.findFragmentByTag("home");
		
		final FragmentTransaction ft = fm.beginTransaction();
		
		if (loginFragment != null) {
			ft.remove(loginFragment);
		}
		
		if (homeFragment == null) {
			ft.replace(R.id.main_container, new HomeFragment(), "home");
		} else {
			ft.attach(homeFragment);
		}
		
		ft.commit();
	}
	
	protected void goAbout() {
		final FragmentManager fm = getFragmentManager();
		final HomeFragment homeFragment = (HomeFragment) fm.findFragmentByTag("home");
		final AboutFragment aboutFragment = (AboutFragment) fm.findFragmentByTag("about");
		FragmentTransaction ft = null;
		
		ft = detachFragment(fm, homeFragment, aboutFragment, ft);
		
		if (aboutFragment == null) {
			ft.add(R.id.main_container, new AboutFragment(), "about");
			ft.addToBackStack(null);
		} else {
			ft.attach(aboutFragment);
		}
		
		ft.commit();
	}
	
	private FragmentTransaction detachFragment(final FragmentManager fm,
			final HomeFragment homeFragment, final AboutFragment aboutFragment,
			FragmentTransaction ft) {
		if (ft == null) {
			ft = fm.beginTransaction();
		}

		if (homeFragment != null) {
			ft.detach(homeFragment);
		}

		if (aboutFragment != null) {
			ft.detach(aboutFragment);
		}
		return ft;
	}

	protected FragmentManager getFragmentManager() {
		return getSupportFragmentManager();
	}
}
