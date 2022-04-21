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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView main_img,first_index,mid_index,third_index,img_next;
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
                    main_img.setImageResource(R.mipmap.shopping_h);
                    first_index.setImageResource(R.drawable.index_off);
                    mid_index.setImageResource(R.drawable.index_off);
                    third_index.setImageResource(R.drawable.index);                    title_txt.setText(getResources().getString(R.string.third_index_main));
                    para_txt.setText(getResources().getString(R.string.third_index_para));
                    img_next.setVisibility(View.GONE);
                    btn_get_started.setVisibility(View.VISIBLE);

                }
            }
        });
        btn_get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginActivity=new Intent(MainActivity.this,login_page.class);
                MainActivity.this.startActivity(loginActivity);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }
}