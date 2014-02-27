package com.definidev.netcat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText ipEdit = (EditText)findViewById(R.id.ip_address);
		final EditText portEdit = (EditText)findViewById(R.id.port);
		final EditText bodyEdit = (EditText)findViewById(R.id.body);
		
		final Button sendButton = (Button)findViewById(R.id.send_button);
        final Button recvButton = (Button)findViewById(R.id.receive_button);

		sendButton.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				String ip = ipEdit.getText().toString();
				String port = portEdit.getText().toString();
				String body = bodyEdit.getText().toString();

				new SendBodyTask().execute(ip, port, body);
			}
		});

        recvButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String port = portEdit.getText().toString();
                new ReceiveBodyTask().execute(port);
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
