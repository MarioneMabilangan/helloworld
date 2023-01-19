package com.example.joelvalera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;

public class Perfil extends AppCompatActivity {
    EditText nom, cognoms;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        nom = (EditText) findViewById(R.id.editNom);
        cognoms = (EditText) findViewById(R.id.editCognom);

        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.arrow_left:
                Intent intent = new Intent(Perfil.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.arrow_right:
                Intent intent2 = new Intent(Perfil.this, Perfil.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void Nadal(View view){
        Intent intent = new Intent(Perfil.this, JoelValera.class);
        intent.putExtra("nom", nom.getText().toString());
        intent.putExtra("cognoms", cognoms.getText().toString());
        startActivity(intent);
    }
}