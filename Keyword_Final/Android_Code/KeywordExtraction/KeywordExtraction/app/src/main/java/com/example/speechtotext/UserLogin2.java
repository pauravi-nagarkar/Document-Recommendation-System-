package com.example.speechtotext;

import org.apache.http.Header;
import org.json.JSONObject;

import com.example.documentretrival.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import SharedPreferences.SharedPreferenceManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin2 extends Activity {
	
	 private ProgressDialog pDialog;
	    String name, password;
	    EditText Uname, Upass;
	    Button userlogin,userreg;
	    private SharedPreferenceManager prefManager;

	    private String loginStr = "http://192.168.43.56/speech_to_text/user_login.php";

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_login);
		
		prefManager= new SharedPreferenceManager(UserLogin2.this);
		
		
		
		 userlogin = (Button) findViewById(R.id.btnUserLogin);
		 userreg = (Button) findViewById(R.id.btnReg);

	        Uname = (EditText) findViewById(R.id.editUname);
	        Upass = (EditText) findViewById(R.id.editUpass);

	        userlogin.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {

	             login();
	            }
	        });
	        
	        userreg.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {

	            	 Intent intent = new Intent(UserLogin2.this, UserRegistration.class);
//	                Toast.makeText(getApplicationContext(), "Successfull Registered", Toast.LENGTH_LONG).show();
	                startActivity(intent);
	            }
	        });
		

	}
	
	
	private void login() {

        name = Uname.getText().toString().trim();
        password = Upass.getText().toString().trim();
        RequestParams params = new RequestParams();
        Log.d("name", name);
        Log.d("pass", password);
        params.put("name", name);
        params.put("password", password);
//        params.put("hint", "login");

        pDialog = new ProgressDialog(UserLogin2.this);
        pDialog.setMessage("Verifing Details..");
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(false);
        pDialog.show();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(loginStr, params, new AsyncHttpResponseHandler() {
			
			public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
				// TODO Auto-generated method stub
				 pDialog.dismiss();
	                String response = new String(responseBody);
	                try {
	                    System.out.println(response.toString());
	                    JSONObject obj = new JSONObject(response.toString());

	                    if (obj.getString("success").equals("200")) {

	                        prefManager.connectDB();
	                        prefManager.setBoolean("login",true);
	                        prefManager.setString("id",obj.getString("userId"));
	                        prefManager.closeDB();

	                        Toast.makeText(UserLogin2.this, "Login Successfully", Toast.LENGTH_LONG).show();
	                        Intent i = new Intent(UserLogin2.this, MainActivity.class);
	                        	   i.putExtra("id",obj.getString("userId"));
	                        	   System.out.println("Login Value "+obj.getString("userId"));

	                        startActivity(i);
	                        finish();


	                    } else {
	                        Toast.makeText(UserLogin2.this, "Login Failed", Toast.LENGTH_LONG).show();
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    Toast.makeText(UserLogin2.this, "Login Failed At exception", Toast.LENGTH_LONG).show();
	                }
			}

			@Override
			public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

			}


		});

              }

	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_login2, menu);
		return true;
	}

}
