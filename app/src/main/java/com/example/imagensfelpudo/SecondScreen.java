package com.example.imagensfelpudo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SecondScreen extends AppCompatActivity {
    ViewHolderCharacter viewHolderCharacter = new ViewHolderCharacter();
    Constants constants = new Constants();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        viewHolderCharacter.picture = findViewById(R.id.specificPictureView);
        viewHolderCharacter.name = findViewById(R.id.specificNameView);
        viewHolderCharacter.description = findViewById(R.id.specificDespritionView);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String name = extras.getString(constants.NAME_KEY);
            String description = extras.getString(constants.DESCRIPTION_KEY);
            int pictureId = extras.getInt(constants.PICTURE_KEY);

            viewHolderCharacter.name.setText(name);
            viewHolderCharacter.description.setText(description);
            viewHolderCharacter.picture.setImageResource(pictureId);

        }
    }
}
