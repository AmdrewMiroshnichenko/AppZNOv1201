package com.andrewgood.appznov1201.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.andrewgood.appznov1201.R;
import com.andrewgood.appznov1201.ui.course.CourseFragment;

import java.util.ArrayList;
import java.util.List;

public class CourseArrayAdapter extends ArrayAdapter<CourseItemClass> {

    private LayoutInflater inflater;
    private List<CourseItemClass> listItem = new ArrayList<>();
    private Context context;

    public CourseArrayAdapter(@NonNull Context context, int resource, List<CourseItemClass> listItem, LayoutInflater inflater){
        super(context, resource, listItem);
        this.inflater = inflater;
        this.listItem = listItem;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        CourseItemClass listItemMain = listItem.get(position);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.course_item_grid, null, false);
            viewHolder = new ViewHolder();
            viewHolder.image = convertView.findViewById(R.id.ImageMainTitle);
            viewHolder.title = convertView.findViewById(R.id.item_topic);
            viewHolder.unitsCount = convertView.findViewById(R.id.item_unit_count);
            viewHolder.lessonsCount = convertView.findViewById(R.id.item_lessons_count);
            viewHolder.testsCount = convertView.findViewById(R.id.item_tests_count);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(listItemMain.getTitle());
        viewHolder.unitsCount.setText(listItemMain.getUnitsCount());
        viewHolder.lessonsCount.setText(listItemMain.getLessonsCount());
        viewHolder.testsCount.setText(listItemMain.getTestsCount());
        viewHolder.image.setImageResource(listItemMain.imageId);

        return convertView;
    }


    private class ViewHolder{
        TextView title;
        TextView unitsCount;
        TextView lessonsCount;
        TextView testsCount;
        ImageView image;

    }

}
