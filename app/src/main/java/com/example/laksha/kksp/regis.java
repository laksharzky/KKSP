package com.example.laksha.kksp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class regis extends AppCompatActivity implements View.OnClickListener{

    private Button buttonregis;
    private EditText edtregisemail;
    private EditText edtregispass;
    private TextView textView2;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),home.class));
        }




        progressDialog = new ProgressDialog(this);
        buttonregis = (Button) findViewById(R.id.buttonlogin);
        edtregisemail = (EditText) findViewById(R.id.edt_nama_lengkap);
        edtregispass = (EditText) findViewById(R.id.edtloginpass);
        textView2 = (TextView) findViewById(R.id.textView2);

        buttonregis.setOnClickListener(this);
        textView2.setOnClickListener(this);
    }
    private void registerUser(){
        String email = edtregisemail.getText().toString().trim();
        String password = edtregispass.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            //jika email kosong
            Toast.makeText(this,"Email anda kosong",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"Password anda kosong",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),home.class));
                        }else {
                            Toast.makeText(regis.this,"Couldn't register, please try again",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    @Override
    public void onClick(View v) {
        if (v == buttonregis){
            registerUser();
        }
        if (v == textView2){
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
