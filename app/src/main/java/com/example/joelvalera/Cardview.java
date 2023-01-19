package com.example.joelvalera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

public class Cardview extends AppCompatActivity {
    Toolbar toolbar, tbCard;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        toolbar = findViewById(R.id.appbar);
        imageView = findViewById(R.id.imageView6);
        tbCard = findViewById(R.id.tbCard);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tbCard.setTitle("Joel tarjeta");
        tbCard.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.five:
                        imageView.setImageResource(R.drawable.image111);
                        return true;
                    case R.id.four:
                        imageView.setImageResource(R.drawable.image_2023_01_12_171250508_removebg_preview);
                        return true;
                    case R.id.three:
                        imageView.setImageResource(R.drawable.goku);
                        return true;
                    case R.id.two:
                        imageView.setImageResource(R.drawable.image_2023_01_12_172158210_removebg_preview);
                        return true;
                    case R.id.one:
                        imageView.setImageResource(R.drawable.joelsadin);
                        return true;
                    default:
                        return true;
                }
            }
        });
        tbCard.inflateMenu(R.menu.menu_tarjeta);

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
                Intent intent = new Intent(Cardview.this, Buscador.class);
                startActivity(intent);
                return true;
            case R.id.arrow_right:
                Intent intent2 = new Intent(Cardview.this, Perfil.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}