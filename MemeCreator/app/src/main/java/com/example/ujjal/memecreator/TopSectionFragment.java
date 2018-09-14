package com.example.ujjal.memecreator;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TopSectionFragment extends Fragment implements View.OnClickListener {

    private EditText topTextInput;
    private EditText bottomTextInput;
    private Button meme;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
        public void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCommander = (TopSectionListener) activity;
        } catch (ClassCastException e) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_screen_fragment, container, false);
        
        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);
        meme = (Button) view.findViewById(R.id.meme);

        meme.setOnClickListener(this);
        
        return view;
    }

    @Override
    public void onClick(View v) {
        activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
    }
}
