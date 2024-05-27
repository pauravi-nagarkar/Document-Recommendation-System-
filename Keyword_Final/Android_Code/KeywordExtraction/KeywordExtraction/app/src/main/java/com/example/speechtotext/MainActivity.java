package com.example.speechtotext;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import com.example.documentretrival.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String servletName = "", myText = "";
	Object ret = null, inp = null;
	boolean cancel = false, responseRecd = false;
	protected static final int RESULT_SPEECH = 1;
	private ImageButton btnSpeak;
	private TextView txtText;
	String userId;
	String servletPath = "";
	public int status = 0;
	boolean running = true;
	Button submit;
	int cid;
	Handler h;
	String UID, DOCNAME, DOCPATH;
	 private static final String REGISTER_URL = "http://192.168.43.56/speech_to_text/user_speech.php";


   EditText ip;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtText = (TextView) findViewById(R.id.txtText);
		servletPath = "http://" + Setting.ip + ":8080/ServletsModule/";
		submit = (Button) findViewById(R.id.butnSubmit);
		ip=(EditText)findViewById(R.id.editText1);
		Intent i = getIntent();
		userId = i.getStringExtra("id");
		System.out.println("Main ID : "+userId);
		//servletPath = "http://" + ip.getText().toString().trim() + ":8080/ServletsModule/";
		
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//servletPath = "http://" + ip.getText().toString().trim() + ":8080/ServletsModule/VoiceControl";
			//	servletPath = "http://" + ip.getText().toString().trim() + ":8080/ServletsModule/VoiceControl";
				//	LongOperation lo = new LongOperation();
				//	lo.execute("");

			//	RegisterUser ru = new RegisterUser();
				register(myText,userId);
				
			}
		});

		btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);

		btnSpeak.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				running = false;
				Intent intent = new Intent(
						RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

				try {
					startActivityForResult(intent, RESULT_SPEECH);
					txtText.setText("");
				} catch (ActivityNotFoundException a) {
					Toast t = Toast.makeText(getApplicationContext(),
							"Ops! Your device doesn't support Speech to Text",
							Toast.LENGTH_SHORT);
					t.show();
				}
			}
		});
		// h = new Handler(Looper.getMainLooper());
		// h.post(new Runnable() {
		// @Override
		// public void run() {
		// // TODO Auto-generated method stub
		// if(!running){
		//
		// System.out.println("Running");
		// LongOperation op = new LongOperation();
		// op.execute("");
		// }
		// h.postAtTime(this, SystemClock.uptimeMillis()+3000);
		// }
		// });
		//
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
		case RESULT_SPEECH: {
			if (resultCode == RESULT_OK && null != data) {

				ArrayList<String> text = data
						.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
				myText = text.get(0);
				txtText.setText(text.get(0));
				myText=txtText.getText().toString();
				registerUser();
				Toast.makeText(getApplicationContext(), myText,Toast.LENGTH_LONG).show();

			}
			break;
		}

		}
	}

	private class LongOperation extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			System.out.println("In doInBackground");
			try {
				URL url = new URL(servletPath);
				URLConnection connection = url.openConnection();

				connection.setDoOutput(true);
				connection.setDoInput(true);

				// don't use a cached version of URL connection
				connection.setUseCaches(false);
				connection.setDefaultUseCaches(false);
				connection.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");

				// specify the content type that binary data is sent
				connection.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
				ObjectOutputStream out = new ObjectOutputStream(
						connection.getOutputStream());

				// send and serialize the object
				out.writeObject(myText);
				out.close();

				ObjectInputStream in = new ObjectInputStream(
						connection.getInputStream());
				cid = (Integer) in.readObject();
				System.out.println("cid " + cid);
				in.close();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error : " + e);
			}

			return "";
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}

	}

	  private void registerUser() {

//	        String name1 = name.getText().toString().trim().toLowerCase();
//	        String pass1 = pass.getText().toString().trim().toLowerCase();
//	        String email1 = email.getText().toString().trim().toLowerCase();
//	        String mob11 = mob1.getText().toString().trim();
//	        String mob12 = mob2.getText().toString().trim();
//	        String add = address.getText().toString().trim();
//	        String health1 = health.getText().toString().trim();
	       // String bgrp = "A";
//	        Double lat=14.87654,lon=45.98765;
//	        String lat1=Double.toString(lat);
//	        String lon1=Double.toString(lon);
	        // Log.d("details", name + password + email + mob);
//	        String lat1 = lat;
//	        String lon1 = lon;

	        register(myText,userId);
	    }

	    private void register(String myText,String id) {
	        class RegisterUser extends AsyncTask<String, Void, String> {
	            ProgressDialog loading;
	            com.example.speechtotext.RegisterUserClass ruc = new com.example.speechtotext.RegisterUserClass();


	            @Override
	            protected void onPreExecute() {
	                super.onPreExecute();
	                loading = ProgressDialog.show(MainActivity.this, "Please Wait", null, true, true);
	            }

	            @Override
	            protected void onPostExecute(String s) {
	                super.onPostExecute(s);
	                loading.dismiss();
	                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

	            }

	            @Override
	            protected String doInBackground(String... params) {

	                HashMap<String, String> data = new HashMap<String, String>();
	                data.put("text", params[0]);
	                data.put("id",userId);
//	                data.put("password", params[1]);
//	                data.put("email", params[2]);
//	                data.put("mob1", params[3]);
//	                data.put("mob2", params[4]);
//	                data.put("add", params[5]);
//	                data.put("bgrp", params[6]);
//	                data.put("health", params[7]);

					System.out.println("User ID"+userId);

	                String result = ruc.sendPostRequest(REGISTER_URL, data);

	                return result;
	            }
	        }

	        RegisterUser ru = new RegisterUser();
	        ru.execute(myText,id);

	    }
	
	
	
}
