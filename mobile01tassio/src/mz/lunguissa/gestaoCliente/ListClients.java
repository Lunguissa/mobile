package mz.lunguissa.gestaoCliente;

import java.util.ArrayList;

import mz.lunguissa.Cliente.Client;
import mz.lunguissa.gestaoCliente.R;

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

/**
 * @author Tassio Do Rosario
 *Este a classe lista os clientes ja registados... porem tou com problemas na hora de chamar na 
 *aplicacao
 */
public class ListClients extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_clients);
		TableLayout tabela = (TableLayout) findViewById(R.id.Tabela);
		TableRow heading = (TableRow) findViewById(R.id.tableRow1);
		Button backButton = (Button) findViewById(R.id.backButton);
		Intent intent = getIntent();

		ArrayList<Client> serializableExtra = extracted(intent);
		ArrayList<Client> clients = serializableExtra;

		heading.setBackgroundColor(Color.RED);

		for (int i = 0; i < clients.size(); i++) {
			TableRow row = new TableRow(this);
			if (i % 2 == 0) {
				row.setBackgroundColor(Color.CYAN);
			} else {
				row.setBackgroundColor(Color.GREEN);
			}

			TextView tvName = new TextView(this);
			tvName.setText(clients.get(i).getName());

			TextView tvCelNum = new TextView(this);
			tvCelNum.setText(clients.get(i).getCelNumber());

			TextView tvTreatment = new TextView(this);
			tvTreatment.setText(clients.get(i).getTreatment());

			TextView tvTime = new TextView(this);
			tvTime.setText(clients.get(i).getTime());

			row.addView(tvName);
			row.addView(tvCelNum);
			row.addView(tvTreatment);
			row.addView(tvTime);

			tabela.addView(row);
		}

		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent troca = new Intent(getApplicationContext(),
						CreateClient.class);
				startActivity(troca);

			}
		});

	}

	@SuppressWarnings("unchecked")
	private ArrayList<Client> extracted(Intent intent) {
		return (ArrayList<Client>) intent.getSerializableExtra("clientes");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_client, menu);
		return true;
	}

}
