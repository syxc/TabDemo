package org.syxc.tabdemo.ui;

import org.syxc.tabdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AndroidFragment extends Fragment {
	
	private View mRootView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = (View) inflater.inflate(R.layout.fragment_android, container, false);
		
		return mRootView;
	}
	
}
