package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);


//        EditText loginEm                                                                                                                                                                                                                                                                                                                         ail = findViewById(R.id.editTextEmail);
//        loginEmail.setText(sharedPref.getString("Email","default@gmail.com"));
//    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //make loginButton save previous email
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = findViewById(R.id.editTextEmail);
                EditText editText2 = findViewById(R.id.editTextPassword);
                String loginEmail = editText.getText().toString();
                String loginPassword = editText2.getText().toString();

                SharedPreferences sharedPref = v.getContext().getSharedPreferences("autoSave", Context.MODE_PRIVATE);

                SharedPreferences.Editor edit = sharedPref.edit();
                edit.putString("Email",loginEmail);
                edit.commit();

                Intent intent = new Intent(LoginActivity.this, ListItemsActivity.class);

                System.out.println(loginPassword);
                System.out.println(loginEmail);

                if (loginEmail.equals("wlo15410489@gmail.com")&&loginPassword.equals("123456")){
                    System.out.println("correct");
                    startActivity(intent);

                }


            }
        });

        //get previous email to login editText
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        SharedPreferences sharedPref2 = getSharedPreferences("autoSave", Context.MODE_PRIVATE);
        editTextEmail.setText( sharedPref2.getString("Email","default@mail.com"));
    }

//    activityActivityButton = findViewById(R.id.activityActivityButton);
//        activityActivityButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent intent = new Intent(MainActivity.this, ActivityActivity.class);
//            startActivity(intent);
//        }
//    });

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
