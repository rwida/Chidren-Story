package com.rwida.childern_story;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<RecyclerHomeItem> recyclerhomeList = new ArrayList<>();
        recyclerhomeList.add(new RecyclerHomeItem("Beauty and the Beast ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("Cinderella ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("Mulan ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("Pinocchio ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("Rapunzel ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("Snow White ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("Ugly Ducking ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("Robin Hood ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("Sleeping Beauty ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("The White Rabbit ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("The Boy Who Disappeared ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("The Dancing Mouse ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("The Emperor's Clothes ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("The Golden Goose ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("The Hidden Scar ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("The Magic Mirror ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("Ring and a Wish for Love ❤"));
        recyclerhomeList.add(new RecyclerHomeItem("The Princess and the Frog ❤"));

        recyclerView = findViewById(R.id.recyclerviewhome);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerHomeAdapter(recyclerhomeList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Button btn_share = findViewById(R.id.btn_share);
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT,"My App");
                String applink = "https://play.google.com/store/apps/details?id=com.rwida.childern_story";
                share.putExtra(Intent.EXTRA_SUBJECT,"Try My App" + applink);
                startActivity(Intent.createChooser(share, "Share Via"));
            }
        });


        /*Button btn_more = findViewById(R.id.btn_more);
        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moreApp = new Intent(Intent.ACTION_VIEW);
                moreApp.setData(Uri.parse("https://play.google.com/store/apps/developer?id="));
                startActivity(moreApp);
            }
        });*/

        Button btn_email = findViewById(R.id.btn_email);
        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txt = "Hello !! \n Please enter your Suggestion : ";
                Intent sendemail = new Intent(Intent.ACTION_SEND);
                sendemail.setData(Uri.parse("mailto:"));
                sendemail.setType("message/rfc822");
                sendemail.putExtra(Intent.EXTRA_EMAIL,"www.rwidaosama33@gmail.com");
                sendemail.putExtra(Intent.EXTRA_SUBJECT,"Children Story");
                sendemail.putExtra(Intent.EXTRA_TEXT,txt);
                startActivity(sendemail);
            }
        });

        Button btn_close = findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure you want to exit?")
                        .setTitle("Confirm exit")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();

            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Are you sure you want to exit?")
                    .setTitle("Confirm exit")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
            return true;
        }
        return false;
    }


}
