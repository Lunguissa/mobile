package com.example.mesadevoto;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListaMesas extends Activity {

	private ListView listView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_mesas);
		
		 
        listView1=(ListView) findViewById(R.id.listView1);
        
        ArrayList<String> lista= new ArrayList<String>();
        Mesa mesa1=new Mesa("Mesa1","Maputo-provincia","Matola","local1",1000);
        Mesa mesa2=new Mesa("Mesa2","Gaza","Bilene","local2",1400);
        Mesa mesa3=new Mesa("Mesa3","Inhambane","Inharrime","local3",2500);
        Mesa mesa4=new Mesa("Mesa4","Sofala","Beira","local4",3000);
        Mesa mesa5=new Mesa("Mesa5","Tete","Moatize","local5",1200);
        Mesa mesa6=new Mesa("Mesa6","Nampula","Nacala","local6",7000);
        lista.add(mesa1.toString());
        lista.add(mesa2.toString());
        lista.add(mesa3.toString());
        lista.add(mesa4.toString());
        lista.add(mesa5.toString());
        lista.add(mesa6.toString());
        
        
        ArrayAdapter<String> aa= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lista);
        
        listView1.setAdapter(aa);
        
        OnItemClickListener mClickListener=new OnItemClickListener() 
        {
        	public void onItemClick(AdapterView<?> av, View v,int position, long id)
        	{
        		Toast.makeText(av.getContext(), av.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
        	}
        
        };
        listView1.setOnItemClickListener(mClickListener);
    	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_mesas, menu);
		return true;
	}

}
