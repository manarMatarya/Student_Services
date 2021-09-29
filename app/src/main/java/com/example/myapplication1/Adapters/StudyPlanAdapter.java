package com.example.myapplication1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication1.Models.SPchild;
import com.example.myapplication1.Models.*;
import com.example.myapplication1.R;

import java.util.HashMap;
import java.util.List;

public class StudyPlanAdapter extends BaseExpandableListAdapter {

    Context context;
    List<studyplan_info> listGroup;
    HashMap<studyplan_info, List<SPchild>> listItem;

    public StudyPlanAdapter(Context context, List<studyplan_info> listGroup, HashMap<studyplan_info, List<SPchild>> listItem) {
        this.context = context;
        this.listGroup = listGroup;
        this.listItem = listItem;
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listItem.get(this.listGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listItem.get(this.listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        studyplan_info group = (studyplan_info) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.sp_parent, null);
        }
        TextView textView = convertView.findViewById(R.id.sp_parent_NUMmasak);
        textView.setText(group.getSubject_cd());
        TextView textView1 = convertView.findViewById(R.id.sp_parent_NAMEmasak);
        textView1.setText(group.getSubject_name_ar());
        TextView textView2 = convertView.findViewById(R.id.sp_parent_sa3atmasak);
        textView2.setText(group.getSubject_hour());
        TextView textView3 = convertView.findViewById(R.id.sp_parent_daraja);
        textView3.setText(group.getTotal_mark());


        ImageView indicator = convertView.findViewById(R.id.sp_parent_sahem);
        if (getChildrenCount(groupPosition) == 0)
            indicator.setVisibility(View.INVISIBLE);
        else {
            indicator.setVisibility(View.VISIBLE);
            if (isExpanded) {
                indicator.setImageResource(R.drawable.up_arrow2);
            } else {
                indicator.setImageResource(R.drawable.arrow2);
            }
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SPchild child = (SPchild) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.sp_child, null);
        }

        TextView textView = convertView.findViewById(R.id.sp_child_mid);
        textView.setText(child.getMid());
        TextView textView1 = convertView.findViewById(R.id.sp_child_a3mal);
        textView1.setText(child.getA3mal());
        TextView textView2 = convertView.findViewById(R.id.sp_child_final);
        textView2.setText(child.getFinall());
        TextView textView3 = convertView.findViewById(R.id.sp_child_daraja);
        textView3.setText(child.getDaraja());
        TextView textView4 = convertView.findViewById(R.id.sp_child_tagdeer);
        textView4.setText(child.getTagdeer());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
