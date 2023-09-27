package com.shrish.shopapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.shrish.shopapp.Adapter.PopularListAdapter;
import com.shrish.shopapp.Domain.PopularDomain;
import com.shrish.shopapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPupolar;
    private RecyclerView recylerViewPupolar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        bottom_navigation();
    }

    private void bottom_navigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain>items = new ArrayList<>();
        items.add(new PopularDomain("MacBook Pro 13 M2 chip","Discover the new MacBook Pro 14 featuring the powerful M2 chip. This cutting edge laptop redefines performance and probability. With its sleek design and advanced technology, the MacBook Pro 13 M2 chip is your ultimate companion for productivity, creativity, and entertainment. Experience seamless multitasking,stunning visuals on the Retina display, and enhanced security with Touch ID.Take your computing experince to the next level with the MacBook Pro 13 M2 chip.","pic1",15,4,500));
        items.add(new PopularDomain("Ps-5 Digital","Discover the new MacBook Pro 14 featuring the powerful M2 chip. This cutting edge laptop redefines performance and probability. With its sleek design and advanced technology, the MacBook Pro 13 M2 chip is your ultimate companion for productivity, creativity, and entertainment. Experience seamless multitasking,stunning visuals on the Retina display, and enhanced security with Touch ID.Take your computing experince to the next level with the MacBook Pro 13 M2 chip.","pic2",10,4.5,450));
        items.add(new PopularDomain("Iphone 14","Discover the new MacBook Pro 14 featuring the powerful M2 chip. This cutting edge laptop redefines performance and probability. With its sleek design and advanced technology, the MacBook Pro 13 M2 chip is your ultimate companion for productivity, creativity, and entertainment. Experience seamless multitasking,stunning visuals on the Retina display, and enhanced security with Touch ID.Take your computing experince to the next level with the MacBook Pro 13 M2 chip.","pic3",13,4.2,800));

        recylerViewPupolar=findViewById(R.id.view1);
        recylerViewPupolar.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterPupolar=new PopularListAdapter(items);
        recylerViewPupolar.setAdapter(adapterPupolar);
    }
}