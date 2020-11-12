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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonlogin;
    private EditText edtloginemail;
    private EditText edtloginpass;
    private TextView textView2;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),home.class));
        }


        progressDialog = new ProgressDialog(this);
        edtloginemail = (EditText) findViewById(R.id.edt_nama_lengkap);
        edtloginpass  =(EditText) findViewById(R.id.edtloginpass);
        buttonlogin = (Button) findViewById(R.id.buttonlogin);
        textView2 = (TextView) findViewById(R.id.textView2);

        buttonlogin.setOnClickListener(this);
        textView2.setOnClickListener(this);
    }

    private void userLogin() {
        String email = edtloginemail.getText().toString().trim();
        String password = edtloginpass.getText().toString().trim();

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

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),home.class));

                        }
                    }
                });
    }


    @Override
    public void onClick(View v) {
        if (v == buttonlogin){
            userLogin();
        }
        if (v == textView2){
            finish();
            startActivity(new Intent(this, regis.class));
        }
    }


}
