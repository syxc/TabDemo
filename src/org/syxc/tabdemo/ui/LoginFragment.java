package org.syxc.tabdemo.ui;

import org.syxc.tabdemo.MainActivity;
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
		return mRootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i(TAG, "-- onActivityCreated --");
		final Button mLogin = (Button) getView().findViewById(R.id.btnLogin);
		mLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MainActivity main = (MainActivity) getActivity();
				main.mHandler.sendEmptyMessage(main.FRAGMENT_HOME);
			}
		});
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
