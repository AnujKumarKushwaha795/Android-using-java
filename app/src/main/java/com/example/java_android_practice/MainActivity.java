package com.example.java_android_practice;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import com.example.java_android_practice.databinding.ActivityMainBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    CheckBox javaCheckBox, pythonCheckBox, cppCheckBox;
    RadioButton maleRadioButton, femaleRadioButton;
    RadioGroup radioGroup;
    ProgressBar progressBar;
    EditText editText;TextView visibleText;
    MaterialCardView materialCardView;
    RecyclerView recyclerView;

    public void  onClick(View view){
        if(view.getId()==R.id.javaCheckBox){
            javaCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        Toast.makeText(MainActivity.this, "Java selected", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Java not selected",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if(view.getId()==R.id.pythonCheckBox){
            pythonCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        Toast.makeText(MainActivity.this, "Python selected", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Python not selected",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if(view.getId()==R.id.cppCheckBox){
            cppCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        Toast.makeText(MainActivity.this, "C++ selected", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"C++ not selected",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editText = findViewById(R.id.editFirstName);
        visibleText = findViewById(R.id.visibleText);
        Button editNameButton=findViewById(R.id.editNameButton);
        editNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visibleText.setText(editText.getText().toString());
                showSnackBar();
            }
        });

        javaCheckBox=findViewById(R.id.javaCheckBox);
        pythonCheckBox=findViewById(R.id.pythonCheckBox);
        cppCheckBox=findViewById(R.id.cppCheckBox);

        javaCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Java", Toast.LENGTH_LONG).show();
            }
        });
        pythonCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Python", Toast.LENGTH_LONG).show();
            }
        });
        cppCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "C++", Toast.LENGTH_LONG).show();
            }
        });

        // checkBox
        javaCheckBox.setOnClickListener(this);
        pythonCheckBox.setOnClickListener(this);
        cppCheckBox.setOnClickListener(this);



        // Radio Button
        maleRadioButton=findViewById(R.id.maleRadioButton);
        femaleRadioButton=findViewById(R.id.femaleRadioButton);

        radioGroup=findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.maleRadioButton){
                    Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_LONG).show();
                    progressBar=findViewById(R.id.progressBar);
                    progressBar.setVisibility(View.INVISIBLE);
                }
                else if(i==R.id.femaleRadioButton){
                    Toast.makeText(MainActivity.this, "Female", Toast.LENGTH_LONG).show();
                    progressBar=findViewById(R.id.progressBar);
                    progressBar.setVisibility(View.VISIBLE);
                }
                else{
                    Toast.makeText(MainActivity.this, "No option selected", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Card View
//        materialCardView=findViewById(R.id.cardView);
//        materialCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"Card View Clicked",Toast.LENGTH_SHORT).show();
//            }
//        });


        // recycler view
        ArrayList<Contact> contacts = new ArrayList<>();
        // Add 5 Contact objects to the ArrayList with real image URLs
        contacts.add(new Contact("John Doe", "john.doe@example.com", "https://randomuser.me/api/portraits/men/1.jpg"));
        contacts.add(new Contact("Jane Smith", "jane.smith@example.com", "https://randomuser.me/api/portraits/women/2.jpg"));
        contacts.add(new Contact("Alice Johnson", "alice.johnson@example.com", "https://randomuser.me/api/portraits/women/3.jpg"));
        contacts.add(new Contact("Bob Brown", "bob.brown@example.com", "https://randomuser.me/api/portraits/men/4.jpg"));
        contacts.add(new Contact("Charlie Davis", "charlie.davis@example.com", "https://randomuser.me/api/portraits/men/5.jpg"));

        recyclerView=findViewById(R.id.recyclerView);
        ContactRecViewAdaptor contactRecViewAdaptor=new ContactRecViewAdaptor(this);
        contactRecViewAdaptor.setContacts(contacts);

        recyclerView.setAdapter(contactRecViewAdaptor);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(
                this,
                2,
                RecyclerView.VERTICAL,
                false
        ));




    }
    // SnackBar
    public void showSnackBar(){
         Snackbar.make(binding.getRoot(),"This is SnackBar",Snackbar.LENGTH_SHORT)
                 .setAction("OK", new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Toast.makeText(MainActivity.this, "OK Clicked", Toast.LENGTH_SHORT).show();
                     }
                 })
                 .setActionTextColor(Color.RED)
                 .show();
    }

}


