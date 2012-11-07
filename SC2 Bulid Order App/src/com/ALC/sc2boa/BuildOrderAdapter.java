package com.ALC.sc2boa;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BuildOrderAdapter extends ArrayAdapter<BuildOrder>{
	
	Context context;
    int layoutResourceId;   
    BuildOrder data[] = null;
   
    public BuildOrderAdapter(Context context, int layoutResourceId, BuildOrder[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        BuildOrderHolder holder = null;
       
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
           
            holder = new BuildOrderHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.RowIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.RowText);
           
            row.setTag(holder);
        }
        else
        {
            holder = (BuildOrderHolder)row.getTag();
        }
       
        BuildOrder bo = data[position];//weather
        holder.txtTitle.setText(bo.GetName());
        holder.imgIcon.setImageResource(bo.getIcon());
       
        return row;
    }
   
    static class BuildOrderHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
        long id;
    }

}
