package com.example.mesadevoto;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AddMesa extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_mesa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_mesa, menu);
		return true;
	}

}
