package com.shrish.shopapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shrish.shopapp.Domain.PopularDomain;
import com.shrish.shopapp.Helper.ManagmentCart;
import com.shrish.shopapp.R;

public class DetailActivity extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView tittleTxt,feeTxt,descriptionTxt, reviewTxt, scoreTxt;
    private ImageView picItem,backBtn;
    private PopularDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        managmentCart = new ManagmentCart(this);

        initView();
        getBundle();

    }

    private void getBundle() {
        object = (PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(),"drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picItem);

        tittleTxt.setText(object.getTitle());
        feeTxt.setText(""+object.getTitle());
        descriptionTxt.setText(object.getDescription());
        reviewTxt.setText(object.getTitle()+"");
        scoreTxt.setText(object.getScore()+"");
        addToCartBtn.setOnClickListener(v -> {
            object.setNumberinCart(numberOrder);
            managmentCart.insertFood(object);
        });
        backBtn.setOnClickListener(v -> finish());


    }

    private void initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        feeTxt = findViewById(R.id.priceTxt);
        tittleTxt = findViewById(R.id.titleTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        picItem = findViewById(R.id.itemPic);
        reviewTxt = findViewById(R.id.reviewTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        backBtn = findViewById(R.id.backBtn);

    }
}