package com.example.speechtotext;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import com.example.documentretrival.R;

public class UserRegistration extends Activity {

    EditText Uname, Upass, Umail, Umob;
    Button userreg;
    private static final String REGISTER_URL = "http://192.168.43.56/speech_to_text/user_register.php";
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        userreg = (Button) findViewById(R.id.btnUserSubmit);
        Uname = (EditText) findViewById(R.id.editUname);
        Upass = (EditText) findViewById(R.id.editUpass);
        Umail = (EditText) findViewById(R.id.editUmail);
        Umob = (EditText) findViewById(R.id.editUmob);


        userreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser();
                Intent intent = new Intent(UserRegistration.this, UserLogin2.class);
//                Toast.makeText(getApplicationContext(), "Successfull Registered", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

    }

    private void registerUser() {

        String name = Uname.getText().toString().trim().toLowerCase();
//        String acc_no1 = Long.toString(acc_no);
        String password = Upass.getText().toString().trim().toLowerCase();
        String email = Umail.getText().toString().trim().toLowerCase();
        String mob = Umob.getText().toString().trim();
//        Double lat=14.87654,lon=45.98765;
//        String lat1=Double.toString(lat);
//        String lon1=Double.toString(lon);
        Log.d("details", name + password + email + mob);
//        String lat1 = lat;
//        String lon1 = lon;

        register(name, password, email, mob);
    }

    private void register(String name, String password, String email, String mob) {
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            com.example.speechtotext.RegisterUserClass ruc = new com.example.speechtotext.RegisterUserClass();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(UserRegistration.this, "Please Wait", null, true, true);
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
                data.put("name", params[0]);
                data.put("password", params[1]);
                data.put("email", params[2]);
               data.put("mob", params[3]);

                String result = ruc.sendPostRequest(REGISTER_URL, data);

                return result;
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(name, password, email, mob);

    }


}
