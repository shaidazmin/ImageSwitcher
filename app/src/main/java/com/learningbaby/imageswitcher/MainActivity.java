package com.learningbaby.imageswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    int [] flags = {R.drawable.afghanistan, R.drawable.albania, R.drawable.algeria, R.drawable.andorra, R.drawable.angola,
            R.drawable.bahrain, R.drawable.bangladesh, R.drawable.belarus, R.drawable.belgium, R.drawable.cambodia,
            R.drawable.cameroon, R.drawable.canada};
    int i = 0;

    ImageSwitcher imageSwitcher;
    Button preBtn, nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      final   Animation in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.in);
      final   Animation out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.out);


        imageSwitcher = findViewById(R.id.imageSwitcher);
        preBtn = findViewById(R.id.preButton);
        nextBtn = findViewById(R.id.nextButton);




        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

                return imageView;
            }
        });
        
        imageSwitcher.setImageResource(flags[6]);

        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageSwitcher.setInAnimation(in);
                imageSwitcher.setInAnimation(out);
                if(i>0){
                    i--;
                    imageSwitcher.setImageResource(flags[i]);
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageSwitcher.setInAnimation(in);
                imageSwitcher.setInAnimation(out);
                if(i<flags.length){
                    i++;
                    imageSwitcher.setImageResource(flags[i]);
                }
            }
        });



    }
}
