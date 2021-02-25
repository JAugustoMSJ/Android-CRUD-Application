package com.example.meuapp;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ActivityNavigator;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meuapp.crud.Create;
import com.example.meuapp.crud.Read;
import com.example.meuapp.model.Pessoa;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends AppCompatActivity{
    private TextView tvUserEmail, tvUserName;
    private ImageView btn_add;
    private ImageView btn_pesquisar;
    private ImageView btn_atualizar;
    private ImageView btn_del;
    private DrawerLayout drawerLayoutProfile;
    private MenuItem item_email, item_userName;
    private NavigationView navigationViewProfile;
    private View header;
    private Toolbar toolbar_profile;
    private BottomAppBar bottomAppBarHome;
    private Pessoa pUsuario;
    private View layout_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new Create().createTable();
        btn_add = findViewById(R.id.btn_add);
        btn_pesquisar = findViewById(R.id.btn_pesquisar);
        btn_atualizar = findViewById(R.id.btn_atualizar);
        btn_del = findViewById(R.id.btn_del);
//        bottomAppBarHome = findViewById(R.id.bottomAppBarHome);
//        drawerLayoutProfile = findViewById(R.id.drawer_profile);
//        navigationViewProfile = drawerLayoutProfile.findViewById(R.id.navigationViewProfile);
//            header = navigationViewProfile.getHeaderView(0);
//                tvUserEmail = header.findViewById(R.id.tvUserEmail);
//                tvUserName = header.findViewById(R.id.tvUserName);
//        toolbar_profile = findViewById(R.id.toolbar_profile);
//        setSupportActionBar(toolbar_profile);

        Bundle userData = getIntent().getExtras();
        String email = null, userName = null;
        if (userData.getString("my_email") != null && userData.getString("my_user_name") != null) {
            email = userData.getString("my_email");
            userName = userData.getString("my_user_name");
//            Toast.makeText(getApplicationContext(), "Email: " + email, Toast.LENGTH_SHORT).show();
            tvUserEmail.setText(email);
            tvUserName.setText(userName);
        } else {
            Read read = new Read();
            pUsuario = new Pessoa();
            pUsuario = read.getPessoaById("dev.augusto");
//            Toast.makeText(getApplicationContext(), "Email: "+pUsuario.getEmail(), Toast.LENGTH_SHORT).show();
            userName = userData.getString("nome_usuario");
            tvUserName.setText(userName);
//            tvUserEmail.setText(pUsuario.getEmail());
        }
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CadastroActivity.class));
            }
        });

        btn_pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ConsultaActivity.class));
            }
        });

        btn_atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AtualizaActivity.class));
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, DeletaActivity.class));
            }
        });

//        layout_home = findViewById(R.id.constraintLayoutHome);
//        layout_home.setVisibility(View.VISIBLE);
//        layout_home.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    drawerLayoutProfile.setVisibility(View.VISIBLE);
//                }
//            });

//        bottomAppBarHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                drawerLayoutProfile.setVisibility(View.VISIBLE);
//                drawerLayoutProfile.openDrawer(GravityCompat.START);
//            }
//        });
    }
}


