package com.example.doubl.moodtrack.outils;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.doubl.moodtrack.R;


public class DialogFragment extends android.support.v4.app.DialogFragment {

    private static DatabaseManager databaseManager;
    private String text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle SaveInstanceState) {


        final View v = inflater.inflate(R.layout.fragment, container, false);

        Button commentBtn = v.findViewById(R.id.valider_btn);


        // enregistrer le message
        final EditText editText = v.findViewById(R.id.dialog_edittext_user_input);

        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //affiche un icone dans l'historique
                String text = editText.getText().toString();
                Log.i("DialogClick", text);
                databaseManager = new DatabaseManager(getContext());
                databaseManager.insertComment(text);
                Log.i("DATABASE", "insertComment invokedFragment : -> " + text);
                dismiss();

            }

        });return v;
    }


}
