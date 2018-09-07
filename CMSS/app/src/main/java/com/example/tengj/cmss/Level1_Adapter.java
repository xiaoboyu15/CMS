package com.example.tengj.cmss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Level1_Adapter extends ArrayAdapter<LevelOne>{
    private int resourceId;
    public Level1_Adapter(Context context, int textViewResourceId, List<LevelOne>objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LevelOne levelOne = getItem(position);
        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else {
            view = convertView;
        }

        TextView levelName = (TextView) view.findViewById(R.id.level_name);
        levelName.setText(levelOne.getName());
        return view;
    }

}
