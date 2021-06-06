package com.sungkyul.customerinfofragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class InputFragment extends Fragment {

    private OnFragmentInteractionListenr mListener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_input, container, false);
        Button btnStore = rootView.findViewById(R.id.btnStore);

        final EditText edtName = rootView.findViewById(R.id.edtName);
        final EditText edtAge = rootView.findViewById(R.id.edtAge);
        final EditText edtBirth = rootView.findViewById(R.id.edtBirth);

        btnStore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String inputName = edtName.getText().toString();
                String inputAge = edtAge.getText().toString();
                String inputBirth = edtBirth.getText().toString();
                edtName.setText(" ");
                edtBirth.setText(" ");
                edtAge.setText(" ");
                mListener.onFragmentInteraction(inputName,inputAge,inputBirth);

            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListenr){
            mListener = (OnFragmentInteractionListenr)context;
        }else  {
            throw new RuntimeException(context.toString()
                                    + "must implemet OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListenr{
        void onFragmentInteraction(String Name, String Age, String Birth);
    }
}
