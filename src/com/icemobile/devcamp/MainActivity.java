package com.icemobile.devcamp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	private EditText editUsername;
	private EditText editPassword;
	private Button loginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editUsername = (EditText)findViewById(R.id.edit_username);
		editPassword = (EditText)findViewById(R.id.edit_password);
		loginButton = (Button)findViewById(R.id.login_button);
		loginButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.equals(loginButton)) {
			String username = editUsername.getText().toString();
			String password = editPassword.getText().toString();
			if(username.equals("foo") && password.equals("pass")) {
				Toast.makeText(this, R.string.login_successful, Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(this, R.string.login_error, Toast.LENGTH_LONG).show();
			}
		}
	}

}
