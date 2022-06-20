package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class EnterInfoActivity extends AppCompatActivity implements
        BasicInfoFragment.OnFloatingButtonClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicinfo);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new BasicInfoFragment())
                    .commit();


            FirebaseUser  user = FirebaseAuth.getInstance().getCurrentUser();
            {
                if(user != null)
                {
                    String name = user.getUid();
                }
            }
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
//       setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Information");
    }

    @Override
    public void onFloatingButtonClicked() {
        Intent myIntent = new Intent(this, SetGoalActivity.class);
        startActivity(myIntent);
    }
}
