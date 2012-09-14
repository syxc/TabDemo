package org.syxc.tabdemo.ui;

import static org.syxc.tabdemo.MainActivity.main;

import org.syxc.tabdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LoginFragment extends Fragment {
	
	private static final String TAG = "LoginFragment";

	private View mRootView;
	private Button mLogin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "-- onCreate --");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "-- onCreateView --");
		mRootView = (View) inflater.inflate(R.layout.fragment_login, container, false);
		
		mLogin = (Button) mRootView.findViewById(R.id.btnLogin);
		mLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				main.mHandler.sendEmptyMessage(main.FRAGMENT_HOME);
			}
		});
		return mRootView;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		Log.i(TAG, "-- onResume --");
	}
	
	@Override
	public void onPause() {
		super.onPause();
		Log.i(TAG, "-- onPause --");
	}
	
	@Override
	public void onStop() {
		super.onStop();
		Log.i(TAG, "-- onStop --");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "-- onDestroy --");
	}
	
}
