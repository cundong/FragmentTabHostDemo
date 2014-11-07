package com.cundong.fragmenttabhost;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment1 extends Fragment {

	private static final String KEY = "com.cundong.fragmenttabhost.Fragment1.KEY";

	private TextView mTextView;
	private String mKey = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (savedInstanceState == null) {
			Bundle bundle = this.getArguments();
			if (bundle != null && bundle.containsKey("key")) {
				mKey = bundle.getString("key");
			}
		} else {
			mKey = savedInstanceState.getString(KEY);
		}
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {

		super.onSaveInstanceState(outState);
		outState.putString(KEY, mKey);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment, container, false);
		mTextView = (TextView) rootView.findViewById(R.id.text);
		
		return rootView;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		mTextView.setText(mKey);
	}
}
