package com.example.myapplication1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication1.Models.acaminic_listitem;
import com.example.myapplication1.Models.childItem;
import com.example.myapplication1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class acadimic_study_adapter extends BaseExpandableListAdapter {

    Context context;
    ArrayList<childItem> listGroup=new ArrayList<childItem>() ;
    HashMap<childItem, List<acaminic_listitem>> listItem = new HashMap<childItem,List<acaminic_listitem>>();

    public acadimic_study_adapter(Context context, ArrayList<childItem> listGroup, HashMap<childItem, List<acaminic_listitem>> listItem) {
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
        childItem group =(childItem) getGroup(groupPosition);
        if (convertView ==null){
            LayoutInflater layoutInflater =(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =layoutInflater.inflate(R.layout.acadimic_study_menuitem,null);
        }
        TextView textView = convertView.findViewById(R.id.acadimicstudy_list_parent);
        textView.setText(group.name);

        ImageView indicator = convertView.findViewById(R.id.acadimicstudy_list_parent_image_arrow);
        if (getChildrenCount( groupPosition ) == 0)
            indicator.setVisibility( View.INVISIBLE );
        else{
            indicator.setVisibility( View.VISIBLE );
            if (isExpanded) {
                indicator.setImageResource(R.drawable.up_arrow);
            } else {
                indicator.setImageResource(R.drawable.arrow);
            }
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        acaminic_listitem child =(acaminic_listitem) getChild(groupPosition,childPosition);
        if (convertView ==null){
            LayoutInflater layoutInflater =(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =layoutInflater.inflate(R.layout.acadimic_study_listitem,null);
        }

        TextView textView1 = convertView.findViewById(R.id.tv11);
        textView1.setText(child.tv11+"");
        TextView textView2 = convertView.findViewById(R.id.tv22);
        textView2.setText(child.tv22+"");
        TextView textView3 = convertView.findViewById(R.id.tv33);
        textView3.setText(child.tv33+"");
        TextView textView4 = convertView.findViewById(R.id.tv44);
        textView4.setText(child.tv44+"");
        TextView textView5 = convertView.findViewById(R.id.tv55);
        textView5.setText(child.tv55+"");
        TextView textView6 = convertView.findViewById(R.id.tv66);
        textView6.setText(child.tv66+"");
        TextView textView7 = convertView.findViewById(R.id.tv77);
        textView7.setText(child.tv77+"");

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
