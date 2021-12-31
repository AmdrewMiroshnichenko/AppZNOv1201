package com.andrewgood.appznov1201.ui.course;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.andrewgood.appznov1201.R;
import com.andrewgood.appznov1201.adapters.CourseArrayAdapter;
import com.andrewgood.appznov1201.adapters.CourseItemClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class CourseFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener{

    private int [] imageArray = new int[]{R.drawable.ic_profile_people, R.drawable.ic_profile_home, R.drawable.ic_profile_school, R.drawable.ic_profile_work, R.drawable.ic_profile_leisure, R.drawable.ic_profile_world};
    private String[] topics, countUnit, countLessons, countTest;
    private GridView list;
    private List<CourseItemClass> listItemMain = new ArrayList<>();
    private CourseItemClass listItem;
    private CourseArrayAdapter adapter;


    public CourseFragment() {
    }

    public static CourseFragment newInstance() {
        return new CourseFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);

        list = view.findViewById(R.id.course_grid_view);

        topics = getActivity().getResources().getStringArray(R.array.course_title_array);
        countUnit = getActivity().getResources().getStringArray(R.array.course_count_units_array);
        countLessons = getActivity().getResources().getStringArray(R.array.course_count_lessons_array);
        countTest = getActivity().getResources().getStringArray(R.array.course_count_tests_array);

        fillArray(getActivity().getResources().getStringArray(R.array.course_title_array), getResources().getStringArray(R.array.course_count_units_array), getResources().getStringArray(R.array.course_count_lessons_array), getResources().getStringArray(R.array.course_count_tests_array), imageArray);


        adapter = new CourseArrayAdapter(getActivity().getApplicationContext(), R.layout.course_item_grid, listItemMain, getLayoutInflater());
        list.setAdapter(adapter);

        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }


    private void fillArray(String[] item, String[] countUnits, String[] countLessons, String[] countTests, int[] image){
        if(adapter != null) adapter.clear();
        for (int i = 0; i < item.length; i++){
            listItem = new CourseItemClass();

            listItem.setTitle(item[i]);
            listItem.setUnitsCount(countUnits[i]);
            listItem.setLessonsCount(countLessons[i]);
            listItem.setTestsCount(countTests[i]);
            listItem.setImageId(image[i]);
            listItemMain.add(listItem);
        }
        if(adapter != null) adapter.notifyDataSetChanged();

    }
}