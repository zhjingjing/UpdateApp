package com.szy.update;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 */
public class MainActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button updateBtn = (Button) findViewById(R.id.btnUpdate);
		updateBtn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				UpdateManager manager = new UpdateManager(MainActivity.this);
				// 检查软件更新
				manager.checkUpdate();
			}
		});
 
	}
}