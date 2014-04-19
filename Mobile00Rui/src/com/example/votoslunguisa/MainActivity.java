package com.example.votoslunguisa;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	int frel;
	int ren; 
	int mdm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		frel=0;
		 ren=0; 
		mdm=0;
		Button Frelimo= (Button) findViewById(R.id.Frelimo);
		Button Renamo= (Button) findViewById(R.id.Renamo);
		Button Mdm= (Button) findViewById(R.id.MDM);
		TextView Fre= (TextView) findViewById(R.id.tvFrelimo);
		TextView Md= (TextView) findViewById(R.id.tvMDM);
		TextView Ren= (TextView) findViewById(R.id.tvRenamo);
		Fre.setText("Frelimo tem : "+frel);
		Ren.setText("Renamo tem : "+ren);
		Md.setText("MDM tem : "+mdm);
		
		Frelimo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				frel=frel+1;
				TextView Fre= (TextView) findViewById(R.id.tvFrelimo);
				Fre.setText("Frelimo tem : "+frel);
			}
		});
	Renamo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ren=ren+1;
				TextView Ren= (TextView) findViewById(R.id.tvRenamo);
				Ren.setText("Renamo tem : "+ren);
			}
		});
	Mdm.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			mdm=mdm+1;
			TextView Md= (TextView) findViewById(R.id.tvMDM);
			
			Md.setText("MDM tem : "+mdm);
		}
	});
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
