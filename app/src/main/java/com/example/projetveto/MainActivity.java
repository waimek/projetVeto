package com.example.projetveto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCreationCompte(View view){
        Intent intent = new Intent(this, CreationCompteActivity.class);
        startActivity(intent);

    }
    public void onClickConnexion(View view){
        Intent intent = new Intent(this, ConnexionActivity.class);
        startActivity(intent);
    }
}
