package com.andrewgood.appznov1201.ui.learn;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.andrewgood.appznov1201.R;
import com.andrewgood.appznov1201.ui.course.CourseFragment;

public class LearnFragment extends Fragment {

    public LearnFragment() {
    }

    public static LearnFragment newInstance() {
        return new LearnFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learn, container, false);
    }
}