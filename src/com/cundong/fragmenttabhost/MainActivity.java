package com.cundong.fragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;

	// 定义数组来存放Fragment界面
	private Class<?> mFragments[] = { Fragment1.class, Fragment2.class, Fragment3.class };

	// 定义数组来存放按钮图片
	private int mTabDrawables[] = { R.drawable.tabspec_chats, R.drawable.tabspec_contacts, R.drawable.tabspec_me };

	// Tab选项卡的文字
	private String mTabTitles[] = { "Chats", "Contacts", "Me" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		mTabHost.getTabWidget().setDividerDrawable(null);
		
		for (int i = 0; i < mFragments.length; i++) {
			Bundle b = new Bundle();
			b.putString("key", "Simple" + i);
			mTabHost.addTab(mTabHost.newTabSpec(String.valueOf(i)).setIndicator(getView(i)), mFragments[i], b);
		}

		mTabHost.setCurrentTab(1);
	}

	private View getView(int i) {
		
		View view = View.inflate(this, R.layout.tabspec_item, null);

		ImageView imageView = (ImageView) view.findViewById(R.id.image);
		TextView textView = (TextView) view.findViewById(R.id.text);

		imageView.setImageResource(mTabDrawables[i]);
		textView.setText(mTabTitles[i]);
		
		return view;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
