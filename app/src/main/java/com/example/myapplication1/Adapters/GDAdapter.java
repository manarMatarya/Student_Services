package com.example.myapplication1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.myapplication1.Models.GDchild;
import com.example.myapplication1.Models.GDparent;
import com.example.myapplication1.R;

import java.util.HashMap;
import java.util.List;

public class GDAdapter extends BaseExpandableListAdapter {

    Context context;
    List<GDparent> listGroup;
    HashMap<GDparent, List<GDchild>> listItem;
    public GDAdapter(Context context, List<GDparent> listGroup, HashMap<GDparent, List<GDchild>> listItem){
        this.context=context;
        this.listGroup=listGroup;
        this.listItem=listItem;
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
        GDparent group =(GDparent) getGroup(groupPosition);
        if (convertView ==null){
            LayoutInflater layoutInflater =(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =layoutInflater.inflate(R.layout.gd_parent,null);
        }
        TextView gd_parent_NUMmasak = convertView.findViewById(R.id.gd_parent_NUMmasak);
        TextView gd_parent_NAMEmasak = convertView.findViewById(R.id.gd_parent_NAMEmasak);
        TextView gd_parent_daraja = convertView.findViewById(R.id.gd_parent_daraja);
        gd_parent_NUMmasak.setText(group.getNUMmasak());
        gd_parent_NAMEmasak.setText(group.getNAMEmasak());
        gd_parent_daraja.setText(group.getDaraja());

        ImageView gd_parent_sahem = convertView.findViewById(R.id.gd_parent_sahem);
        if (getChildrenCount( groupPosition ) == 0)
            gd_parent_sahem.setVisibility( View.INVISIBLE );
        else{
            gd_parent_sahem.setVisibility( View.VISIBLE );
            if (isExpanded) {
                gd_parent_sahem.setImageResource(R.drawable.up_arrow);
            } else {
                gd_parent_sahem.setImageResource(R.drawable.arrow);
            }
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        GDchild child =(GDchild) getChild(groupPosition,childPosition);
        if (convertView ==null){
            LayoutInflater layoutInflater =(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =layoutInflater.inflate(R.layout.gd_child,null);
        }
        TextView gd_child_mid = convertView.findViewById(R.id.gd_child_mid);
        TextView gd_child_a3mal = convertView.findViewById(R.id.gd_child_a3mal);
        TextView gd_child_final = convertView.findViewById(R.id.gd_child_final);
        TextView gd_child_daraja = convertView.findViewById(R.id.gd_child_daraja);
        TextView gd_child_tagdeer = convertView.findViewById(R.id.gd_child_tagdeer);
        gd_child_mid.setText(child.getMid());
        gd_child_a3mal.setText(child.getA3mal());
        gd_child_final.setText(child.getFinall());
        gd_child_daraja.setText(child.getDarajaa());
        gd_child_tagdeer.setText(child.getTagdeer());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

