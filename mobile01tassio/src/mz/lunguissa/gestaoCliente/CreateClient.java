package mz.lunguissa.gestaoCliente;

import java.util.ArrayList;

import mz.lunguissa.Cliente.Client;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * @author Tassio Do Rosario
 * esta tela representa a tela inicial onde se pode
 * inserir um novo cliente
 * 
 */
public class CreateClient extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_client);

		final EditText nameBox = (EditText) findViewById(R.id.nameField);
		final EditText celNum = (EditText) findViewById(R.id.NumField);
		final Spinner options = (Spinner) findViewById(R.id.CareSpinner);
		final TimePicker timePick = (TimePicker) findViewById(R.id.timePicker);
		final Button addClient = (Button) findViewById(R.id.addButton);
		final Button list = (Button) findViewById(R.id.listButton);
		final ArrayList<Client> clientList = new ArrayList<Client>();
		ArrayList<String> careOptions = Client.tratamentos();

		ArrayAdapter<String> adap = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, careOptions);

		options.setAdapter(adap);

		addClient.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View action) {
				String name = nameBox.getText().toString();
				String celNumber = celNum.getText().toString();
				String treatment = (String) options.getSelectedItem();
				String time = timePick.toString();

				if (!name.equals("")) {
					Client newClient = new Client(name, celNumber, treatment,
							time);

					if (clientList.contains(newClient)) {
						Toast.makeText(getApplicationContext(),
								"Marcaçao já feita", Toast.LENGTH_SHORT).show();

					} else {
						clientList.add(newClient);
						Toast.makeText(getApplicationContext(), "Inserido",
								Toast.LENGTH_SHORT).show();
						nameBox.setText("");
					}
				} else {
					Toast.makeText(getApplicationContext(),
							"Introduzir nome do Cliente", Toast.LENGTH_SHORT)
							.show();

				}

			}
		});

		list.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View action) {
				Intent intent = new Intent(getApplicationContext(),
						ListClients.class);

				// intent.putExtra("list", clientList);
				startActivity(intent);

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
