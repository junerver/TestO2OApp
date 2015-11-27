package com.junerver.testo2oapp.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.junerver.testo2oapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UnEvaluationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UnEvaluationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnEvaluationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_un_evaluation, container, false);
    }

}
