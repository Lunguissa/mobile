package com.mz.teamLunguissa.start;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mz.teamLunguissa.accao.Accao;
import com.mz.teamLunguissa.model.MesaVoto;


public class Mesas extends Activity 
{

 
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesas);
        
    	 final EditText etNomeMesa=(EditText) findViewById(R.id.etNomeMesa);
    	 final Spinner spProvincia=(Spinner)findViewById(R.id.spProvincia);
    	 final Spinner spDistrito=(Spinner)findViewById(R.id.spDistrito);
    	 final Spinner spLocalidade=(Spinner)findViewById(R.id.spLocalidade);
    	 Button btAddiconar=(Button)findViewById(R.id.btAdicionar);
    	 Button btListar=(Button)findViewById(R.id.btListar);
    	 final ArrayList<MesaVoto> mesa= new ArrayList<MesaVoto>();
    	 
    	 //loading
    	 ArrayList<MesaVoto> load= new ArrayList<MesaVoto>();
    	 Intent intent=getIntent();
    	 
    	if (intent.getExtras()!=null)
		{
    		load=(ArrayList<MesaVoto>) intent.getSerializableExtra("mesa");
		}
    	  mesa.addAll(load);
         
    	 ArrayList<String> listaPro=Accao.addProvincia();
    	 ArrayList<String> listaDir=Accao.addDistrito();
    	 ArrayList<String> listaLoc=Accao.addLocalidade();
    	 
        ArrayAdapter<String> ProAdapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_spinner_item, listaPro);
        ArrayAdapter<String> DirAdapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_spinner_item, listaDir);
        ArrayAdapter<String> LocAdapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_spinner_item, listaLoc);
        
        spProvincia.setAdapter(ProAdapter);
        spDistrito.setAdapter(DirAdapter);
        spLocalidade.setAdapter(LocAdapter);
        
        btAddiconar.setOnClickListener(new OnClickListener() 
        {		
			@Override
			public void onClick(View accao) 
			{
				String provincia=(String) spProvincia.getSelectedItem();
				String distrito=(String) spDistrito.getSelectedItem();
				String localidade=(String) spLocalidade.getSelectedItem();
				
				String nomeMesa=etNomeMesa.getText().toString();
				if (!nomeMesa.equals("")) 
				{
					MesaVoto novo= new MesaVoto(provincia, distrito, localidade, nomeMesa);
					if (mesa.contains(nomeMesa))
					{
						Toast.makeText(getApplicationContext(), "Mesa ja existe", Toast.LENGTH_SHORT).show();
						
					}
					else
					{
						mesa.add(novo);
						Toast.makeText(getApplicationContext(), "Insirido", Toast.LENGTH_SHORT).show();
						etNomeMesa.setText("");
					}
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Introduzir nome da mesa", Toast.LENGTH_SHORT).show();
					
				}
				
			}
		});
        
        btListar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View accao) 
			{
				Intent intent = new Intent(getApplicationContext(),ListasMesa.class);
				
				intent.putExtra("mesa", mesa);
		        startActivity(intent);
		      
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mesas, menu);
        return true;
    }
    
}
