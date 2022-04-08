package com.example.vk11_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class FragmentSettings extends Fragment {
    View view = null;
    //Switch switch1 = null;
    Button button2 = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){
        button2 = (Button) this.view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToActivity();
            }
        });
        //super.onViewCreated(view, savedInstance);
        /*switch1 = (Switch) this.view.findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //jos on estetty -> editText.setEnabled() ja editText teksti textViewiin
                if(isChecked == true){
                    sendToActivity(true);
                }
            }
        });*/
    }

    public void sendToActivity(){
        Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
        intent.putExtra("key1", "estä");
        getActivity().startActivity(intent); //getActivity()?
    }


}