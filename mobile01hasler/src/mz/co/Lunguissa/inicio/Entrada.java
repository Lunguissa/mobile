package mz.co.Lunguissa.inicio;

import java.util.ArrayList;


import mz.co.Lunguissa.mobile01hasler.ListasCliente;
import mz.co.Lunguissa.mobile01hasler.R;
import mz.co.Lunguissa.modelo.Cliente;
import mz.co.Lunguissa.modelo.Servico;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Entrada extends Activity
{


	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entrada);
		
		final EditText etNome=(EditText)findViewById(R.id.etNome);
		final EditText etApelito=(EditText)findViewById(R.id.etApelito);
		 final EditText etTelefone=(EditText)findViewById(R.id.etTelefone);
		 final EditText etEnderenco=(EditText)findViewById(R.id.etEnderenco);
		 final RadioButton rbSim=(RadioButton)findViewById(R.id.rbSim);
		 final RadioButton rbNao=(RadioButton)findViewById(R.id.rbNao);
		 final CheckBox cbCortar=(CheckBox) findViewById(R.id.cbCortar);
		 final CheckBox cbDesflizagem=(CheckBox) findViewById(R.id.cbDesflizagem);
		 final CheckBox cbLavagem=(CheckBox) findViewById(R.id.cbLavagem);
		 final Button btbtAddicionar=(Button)findViewById(R.id.btAddicionar);
		 final Button btListar=(Button)findViewById(R.id.btListar);
		 final ArrayList<Cliente> clientes= new ArrayList<Cliente>();
		
	ArrayList<Cliente> load= new ArrayList<Cliente>();
   	 Intent intent=getIntent();
   	 
   	if (intent.getExtras()!=null)
		{
   		load=(ArrayList<Cliente>) intent.getSerializableExtra("mesa");
		}
   	  clientes.addAll(load);
		
		btbtAddicionar.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				
				String nomes=etNome.getText().toString();
				boolean nome=!nomes.equals("");
				String apelitos=etApelito.getText().toString();
				boolean apelito=!apelitos.equals("");
				String tels=etTelefone.getText().toString();
				boolean tel=!tels.equals("");
				String enderencos=etEnderenco.getText().toString();
				boolean enderenco=!enderencos.equals("");
				
				boolean servico=cbCortar.isSelected() || cbDesflizagem.isSelected() || cbLavagem.isSelected();

				
			//	if (nome && apelito && tel && enderenco && servico)
				{
					boolean reg=rbSim.isSelected();
					Servico s=new Servico(cbCortar.isSelected(),cbDesflizagem.isSelected(),cbLavagem.isSelected());
					Cliente cliente=new Cliente(nomes, apelitos, tels, reg, enderencos,s);
					clientes.add(cliente);
					Toast.makeText(getApplicationContext(), "addicionado", Toast.LENGTH_SHORT).show();
				}
			//	else
				{
					Toast.makeText(getApplicationContext(), "Preencher todos campos", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
		btListar.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(getApplicationContext(),ListasCliente.class);
				
				intent.putExtra("mesa", clientes);
		        startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.entrada, menu);
		return true;
	}


}
