package com.example.vk11_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FragmentHome extends Fragment {
    View view;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance){
        editText = (EditText) this.view.findViewById(R.id.editText);
        Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
        //palautetaan editText
        intent.putExtra("key", editText.getText());
    }

}