package com.example.doubl.moodtrack;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



public class DialogFragment extends android.support.v4.app.DialogFragment {



    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle SaveInstanceState){


        final  View v = inflater.inflate(R.layout.fragment, container, false);

        Button comment_btn = v.findViewById(R.id.valider_btn);


      // enregistrer le message
        final EditText editText= v.findViewById(R.id.tv7);
        comment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enregistre le text dans les preferences
                //affiche un icone dans l'historique
                dismiss();
            }
        });
        return v;
    }


}
