package com.sem.staticfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ButtonFragment.ButtonFragmentCallback {


    ButtonFragment b;
    MessageFragment m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         b = ButtonFragment.newInstance();
        // Create an object of FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        // Begin the transaction
        FragmentTransaction ft = fm.beginTransaction();
        // Replace the container with the new fragment
        ft.replace(R.id.buttonframe,b);
        ft.commit();

        m = MessageFragment.newInstance();

        // Begin the transaction
        ft = fm.beginTransaction();
        // Replace the container with the new fragment
        ft.replace(R.id.messageframe,m);
        ft.commit();

    }

    @Override
    public void onBtnClicked() {
       // Toast.makeText(this,"button clicked",Toast.LENGTH_LONG).show();

m.Increment();


    }
}
