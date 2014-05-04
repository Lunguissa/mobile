package mz.co.Lunguissa.mobile01hasler;



import java.util.ArrayList;

import mz.co.Lunguissa.inicio.Entrada;
import mz.co.Lunguissa.modelo.Cliente;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ListasCliente extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listar);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		TableLayout tabela= (TableLayout) findViewById(R.id.tabela);
		TableRow heading=(TableRow)findViewById(R.id.tableRow1);
		Button btVoltar=(Button)findViewById(R.id.btVoltar);
		
		Intent intent=getIntent();
		
		final ArrayList<Cliente> clientes=(ArrayList<Cliente>) intent.getSerializableExtra("mesa");
		
		heading.setBackgroundColor(Color.RED);
		
		for (int i = 0; i < clientes.size(); i++) 
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
	
			TextView tvNome=new TextView(this);
			tvNome.setText(clientes.get(i).getNome());
			
			TextView tvApelito=new TextView(this);
			tvApelito.setText(clientes.get(i).getApelito());
			
			TextView tvTel=new TextView(this);
			tvTel.setText(clientes.get(i).getNumCel());
			
			TextView tvEnderenco=new TextView(this);
			tvEnderenco.setText(clientes.get(i).getEnderenco());
			
			TextView tvRegistrado=new TextView(this);
			String reg=clientes.get(i).isReg() ? "Sim":"Nao";
			tvRegistrado.setText(reg);
			
			TextView tvCorte=new TextView(this);
			String corte=clientes.get(i).getServico().isCorte() ? "Sim":"Nao";
			tvRegistrado.setText(corte);
			
			TextView tvDesflizagem=new TextView(this);
			String desflizagem=clientes.get(i).getServico().isDesflizagem() ? "Sim":"Nao";
			tvRegistrado.setText(desflizagem);
			
			TextView tvLavagem=new TextView(this);
			String lavagem=clientes.get(i).getServico().isLavagem() ? "Sim":"Nao";
			tvRegistrado.setText(lavagem);
			
			row.addView(tvNome);
			row.addView(tvApelito);
			row.addView(tvTel);
			row.addView(tvEnderenco);
			
			row.addView(tvRegistrado);
			row.addView(tvCorte);
			row.addView(tvDesflizagem);
			row.addView(tvLavagem);
			
			
			tabela.addView(row);
		}
		
		btVoltar.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(getApplicationContext(),Entrada.class);
				
				intent.putExtra("mesa", clientes);
		        startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listas_clientes, menu);
		return true;
	}

}
