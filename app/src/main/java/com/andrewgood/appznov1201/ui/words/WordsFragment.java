package com.andrewgood.appznov1201.ui.words;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewgood.appznov1201.R;

public class WordsFragment extends Fragment {

    public WordsFragment() {
    }

    public static WordsFragment newInstance() {
        return new WordsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_words, container, false);
    }
}