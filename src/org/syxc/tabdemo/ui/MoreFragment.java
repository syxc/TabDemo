package org.syxc.tabdemo.ui;

import static org.syxc.tabdemo.MainActivity.main;

import org.syxc.tabdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MoreFragment extends Fragment {

	private View mRootView;
	private Button mAbout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = (View) inflater.inflate(R.layout.fragment_more, container, false);
		
		mAbout = (Button) mRootView.findViewById(R.id.btnAbout);
		mAbout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				main.mHandler.sendEmptyMessage(main.FRAGMENT_ABOUT);
			}
		});
		return mRootView;
	}
}
