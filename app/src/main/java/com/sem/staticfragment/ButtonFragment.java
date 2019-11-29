package com.sem.staticfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ButtonFragment extends Fragment {


    // 1 - Declare our interface that will be implemented by any container activity
    public interface ButtonFragmentCallback{
        void onBtnClicked();
    }

    //2 - Declare callback
    ButtonFragmentCallback callback;

    // 3 - Create callback to parent activity
    private void createCallbackToParentActivity(){
        try {
            //Parent activity will automatically subscribe to callback
            callback = (ButtonFragmentCallback) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }

    public static ButtonFragment newInstance() {
        ButtonFragment fragment = new ButtonFragment();

        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.button_fragment, container, false);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
// 4 - Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity();

    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // handle your fragment events here

      Button btn = (Button) view.findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 5 - Spread the click to the parent activity
                callback.onBtnClicked();
            }
        });




    }


}
