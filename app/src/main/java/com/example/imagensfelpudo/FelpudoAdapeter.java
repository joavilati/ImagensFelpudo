package com.example.imagensfelpudo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;


public class FelpudoAdapeter extends ArrayAdapter {
    public FelpudoAdapeter(@NonNull Context context, int resource) {
        super(context, resource);

    }

    @Override
    public void add(@NonNull Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myView = convertView;
        ViewHolderCharacter viewHolderCharacter;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.row,parent,false);

            viewHolderCharacter = new ViewHolderCharacter();
            viewHolderCharacter.picture = myView.findViewById(R.id.pictureRowView);
            viewHolderCharacter.name = myView.findViewById(R.id.specificNameView);
            //viewHolderCharacter.description = myView.findViewById(R.id.despritionView);

            myView.setTag(viewHolderCharacter);

        }else{
            viewHolderCharacter = (ViewHolderCharacter) myView.getTag();
        }
        DataCharacter dataCharacter = (DataCharacter) this.getItem(position);

        viewHolderCharacter.picture.setImageResource(dataCharacter.picture);
        viewHolderCharacter.name.setText(dataCharacter.name);
        //viewHolderCharacter.description.setText(dataCharacter.description);

        return myView;

    }


}
