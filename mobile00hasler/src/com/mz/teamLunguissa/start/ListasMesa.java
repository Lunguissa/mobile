package com.mz.teamLunguissa.start;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.mz.teamLunguissa.model.MesaVoto;

public class ListasMesa extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listas_mesa);
		TableLayout tabela= (TableLayout) findViewById(R.id.Tabela);
		TableRow heading=(TableRow)findViewById(R.id.tableRow1);
		Button btVoltar=(Button)findViewById(R.id.bt_voltar);
		Intent intent=getIntent();

		final ArrayList<MesaVoto> mesa=(ArrayList<MesaVoto>) intent.getSerializableExtra("mesa");

		heading.setBackgroundColor(Color.RED);

		for (int i = 0; i < mesa.size(); i++) 
		{
			TableRow row=new TableRow(this);
			if (i%2==0) 
			{
				row.setBackgroundColor(Color.CYAN);
			}
			else
			{
				row.setBackgroundColor(Color.GREEN);
			}
	
			TextView tvMesa=new TextView(this);
			tvMesa.setText(mesa.get(i).getNomeMesa());
			
			TextView tvProvincia=new TextView(this);
			tvProvincia.setText(mesa.get(i).getProvincia());
			
			TextView tvDistrito=new TextView(this);
			tvDistrito.setText(mesa.get(i).getDistrito());
			
			TextView tvLoclidade=new TextView(this);
			tvLoclidade.setText(mesa.get(i).getLocalidade());
			
			row.addView(tvMesa);
			row.addView(tvProvincia);
			row.addView(tvDistrito);
			row.addView(tvLoclidade);
			
			tabela.addView(row);
		}
		
		btVoltar.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View view)
			{
				Intent intent = new Intent(getApplicationContext(),Mesas.class);
				intent.putExtra("mesa", mesa);
		        startActivity(intent);
				
			}
		});
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listas_mesa, menu);
		return true;
	}

}
