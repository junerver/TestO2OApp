package com.junerver.testo2oapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.junerver.testo2oapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AllIndentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AllIndentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllIndentFragment extends Fragment {
    private Button btn_new_indent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_indent, container, false);

        btn_new_indent = (Button) view.findViewById(R.id.btn_new_indent);
        btn_new_indent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),NewIndentActivity.class));
            }
        });

        return view;

    }


}
