package com.sungkyul.customerinfofragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class OutputFragment extends Fragment {
    private static TextView resultName;
    private static TextView resultAge;
    private static TextView resultBirth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_output, container, false);
        Button btnReset = rootView.findViewById(R.id.btnReset);

        resultName = (TextView)rootView.findViewById(R.id.txtName) ;
        resultAge = (TextView)rootView.findViewById(R.id.txtAge) ;
        resultBirth = (TextView)rootView.findViewById(R.id.txtBirth) ;
        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultName.setText(" ");
                resultAge.setText(" ");
                resultBirth.setText(" ");


            }
        });

        return rootView;
    }

    public void setTextView(String Name, String Age, String Birth){
        resultName.setText(Name);
        resultAge.setText(Age);
        resultBirth.setText(Birth);
    }
}
