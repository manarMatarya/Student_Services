package com.example.myapplication1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication1.Models.childItem;
import com.example.myapplication1.Models.itemView;
import com.example.myapplication1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class maneAdapter extends BaseExpandableListAdapter {

    // 4 Child types
    private static final int CHILD_TYPE_1 = 0;
    private static final int CHILD_TYPE_2 = 1;
    private static final int GROUP_TYPE_1 = 0;

    Context context;
    ArrayList<itemView> listGroup = new ArrayList<itemView>();
    HashMap<itemView, List<childItem>> listItem = new HashMap<itemView, List<childItem>>();

    public maneAdapter(Context context, ArrayList<itemView> listGroup, HashMap<itemView, List<childItem>> listItem) {
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

       itemView group =(itemView) getGroup(groupPosition);
       if (convertView ==null){
           LayoutInflater layoutInflater =(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView =layoutInflater.inflate(R.layout.menu_item,null);
       }
        TextView textView = convertView.findViewById(R.id.list_parent);
        textView.setText(group.name);
        ImageView imageView = convertView.findViewById(R.id.list_parent_image);
        imageView.setImageResource(group.imageUrl);

        ImageView indicator = convertView.findViewById(R.id.list_parent_image_arrow);
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
        childItem child =(childItem) getChild(groupPosition,childPosition);
        if (convertView ==null){
            LayoutInflater layoutInflater =(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =layoutInflater.inflate(R.layout.list_item,null);
        }

            TextView textView = convertView.findViewById(R.id.list_child);
            textView.setText(child.name);
            ImageView imageView = convertView.findViewById(R.id.list_child_image);
            imageView.setImageResource(child.imageUrl);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
