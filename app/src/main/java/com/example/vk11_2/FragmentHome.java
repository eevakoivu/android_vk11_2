package com.example.vk11_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentHome extends Fragment {
    View view = null;
    EditText editText = null;
    TextView textView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){
        try {
            String arg = getArguments().getString("key2");
            editText = (EditText) this.view.findViewById(R.id.editText);
            textView = (TextView) this.view.findViewById(R.id.textView);

            System.out.println("FragementHome saatu arvo:" + arg);

            /*if(arg.equals("estä")){
                String text = editText.getText().toString();
                textView.setText(text);
                //editText.setEnabled(false);
            } */
        } catch (Exception e){
            System.out.println("virhe FragmentHome");
        }





    }

}