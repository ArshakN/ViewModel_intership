package com.example.mvvm_intership;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button increment;
    Button decrement;
    TextView number;
    private NumberViewModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        increment=findViewById(R.id.id_incr);
        decrement=findViewById(R.id.id_dec);
        number=findViewById(R.id.id_numb);

        model= ViewModelProviders.of(this).get(NumberViewModel.class);
        final Observer<Integer> numberObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                number.setText(integer.toString());
            }
        };

        model.getNumber().observe(this,numberObserver);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.increment();
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.decremetn();
            }
        });
    }

}
