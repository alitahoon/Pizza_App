package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView main_img,first_index,mid_index,third_index,img_next,background_img;
    TextView title_txt,para_txt;
    Button btn_get_started;
    Animation anim;
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title_txt=findViewById(R.id.title_txt);
        para_txt=findViewById(R.id.para_txt);
        main_img=findViewById(R.id.main_img);
        first_index=findViewById(R.id.first_index);
        mid_index=findViewById(R.id.mid_index);
        third_index=findViewById(R.id.third_index);
        img_next=findViewById(R.id.img_next);
        background_img=findViewById(R.id.background_img);
        btn_get_started=findViewById(R.id.btn_get_started);
        anim= AnimationUtils.loadAnimation(this,R.anim.beganim);
        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (c==0) {
                    main_img.setImageResource(R.mipmap.basket_forground);
                    first_index.setImageResource(R.drawable.index_off);
                    mid_index.setImageResource(R.drawable.index);
                    title_txt.setText(getResources().getString(R.string.mid_index_main));
                    para_txt.setText(getResources().getString(R.string.third_index_para));
                    c++;

                   }else if(c==1){
                    main_img.setImageResource(R.mipmap.shopping_foreground);
                    first_index.setImageResource(R.drawable.index_off);
                    mid_index.setImageResource(R.drawable.index_off);
                    third_index.setImageResource(R.drawable.index);                    title_txt.setText(getResources().getString(R.string.third_index_main));
                    para_txt.setText(getResources().getString(R.string.third_index_para));
                    img_next.setVisibility(View.GONE);
                    btn_get_started.setVisibility(View.VISIBLE);
                    Intent i=new Intent(getApplicationContext(),login_page.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                }
            }
        });
    }
}