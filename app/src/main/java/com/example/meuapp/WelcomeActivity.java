package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class WelcomeActivity extends AppCompatActivity {
    private ImageView myPhotoLogin;
    private TextView myUserName;
    private TextView myEmail;
    private Button btn_sign_out;
    private Button btn_confirmed_login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();

        myPhotoLogin = findViewById(R.id.myPhotoLogin);
        myEmail = findViewById(R.id.myEmail);
        myUserName = findViewById(R.id.myUserName);
        btn_sign_out = findViewById(R.id.btn_sign_out);
        btn_confirmed_login = findViewById(R.id.btn_confirmed_login);

        btn_confirmed_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
//                intent.putExtra("myPhotoLogin", myPhotoLogin.toString());
                intent.putExtra("my_email", myEmail.getText());
                intent.putExtra("my_user_name", myUserName.getText());
                startActivity(intent);
            }
        });

        btn_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();
                finish();
            }
        });

        if(mUser != null){
            String name = mUser.getDisplayName();
            String email = mUser.getEmail();
            String photo = mUser.getPhotoUrl().toString();

            Glide.with(this)
                    .load(photo).
                    transform(new RoundedCornersTransformation(200, 10))
                    .into(myPhotoLogin);
            myUserName.setText(name);
            myEmail.setText(email);
        }
    }
}