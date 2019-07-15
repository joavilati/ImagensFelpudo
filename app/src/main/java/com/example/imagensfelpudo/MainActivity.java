package com.example.imagensfelpudo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    Constants constants = new Constants();

    String[] listName = {"Felpudo","Fofura","Lesmo","Bugado","Uruca","Racing","iOS","Android","RealidadeAumentada","Sound FX","3D Studio Max","Games"},
            listDescription = {"Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras","Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras","Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras","Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras","Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras","Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras","Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras","Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras","Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras","Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras","Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras","Este é o protagonista dos cursus de IOS e Android. Ele vive se metendo em muitas aventuras"};

    int[] listPicture = {R.drawable.felpudo,R.drawable.fofura,R.drawable.lesmo,R.drawable.bugado,R.drawable.uruca,R.drawable.carrinho,R.drawable.ios,R.drawable.android,R.drawable.realidade_aumentada,R.drawable.sound_fx,R.drawable.max,R.drawable.games,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView characterList = findViewById(R.id.felpudoListView);
        final FelpudoAdapeter felpudoAdapeter = new FelpudoAdapeter(getApplicationContext(),R.layout.row);

        for(int i = 0; i< listName.length;i++){
            DataCharacter dataCharacter = new DataCharacter(listName[i],listDescription[i],listPicture[i]);
            felpudoAdapeter.add(dataCharacter);
        }
        characterList.setAdapter(felpudoAdapeter);
        characterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                DataCharacter dataCharacter = (DataCharacter) felpudoAdapeter.getItem(position);
                Intent intent = new Intent(MainActivity.this,SecondScreen.class);
                intent.putExtra(constants.NAME_KEY,dataCharacter.getName());
                intent.putExtra(constants.DESCRIPTION_KEY,dataCharacter.getDescription());
                intent.putExtra(constants.PICTURE_KEY,dataCharacter.getPicture());
                startActivity(intent);


            }
        });

    }


}

