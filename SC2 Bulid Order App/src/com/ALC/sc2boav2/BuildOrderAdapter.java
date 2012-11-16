package com.ALC.sc2boav2;

import java.util.ArrayList;

import com.ALC.sc2boav2.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class BuildOrderAdapter extends ArrayAdapter<BuildOrder>{
	
	//Context context;
    //int layoutResourceId;   
    private ArrayList<BuildOrder> unfilteredBOs;
    private ArrayList<BuildOrder> filteredBOs;
   
    
	//@SuppressWarnings("unchecked")
	public BuildOrderAdapter(Context context, int layoutResourceId, ArrayList<BuildOrder> data) {
        super(context, layoutResourceId, data);
        //this.layoutResourceId = layoutResourceId;
        //this.context = context;
        this.unfilteredBOs =new ArrayList<BuildOrder>(data);
        this.filteredBOs=new ArrayList<BuildOrder>(data);//(ArrayList<BuildOrder>) data.clone();
        //this.filter = new BuildOrderNameFilter();
    }
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	        View row = convertView;
	        //BuildOrderHolder holder = null;
	        if (row == null) {
	            LayoutInflater viewInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            row = viewInflater.inflate(R.layout.row, null);
	            
	            
	        }
	        //holder = new BuildOrderHolder();
            //holder.imgIcon = (ImageView)row.findViewById(R.id.RowIcon);
            //holder.txtTitle = (TextView)row.findViewById(R.id.RowText);
            //holder.rating=(RatingBar)row.findViewById(R.id.RowRatingBar);
	        BuildOrder bo = filteredBOs.get(position);
	        if(bo!=null){
		        ((TextView)row.findViewById(R.id.RowText)).setText(bo.GetName());
		        ((ImageView)row.findViewById(R.id.RowIcon)).setImageResource(bo.getIconID());
		        ((RatingBar)row.findViewById(R.id.RowRatingBar)).setStepSize((float) 0.1);//allow fractional stars
		        ((RatingBar)row.findViewById(R.id.RowRatingBar)).setRating(bo.getRating());
		        
		        
	        }
	        
	        
	        return row;
	}

    
    
    
   
    /*static class BuildOrderHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
        long id;
        RatingBar rating;
    }*/
    
    private Filter filter;
    
    @Override
    public Filter getFilter()
    {
        if(filter == null) filter = new BuildOrderNameFilter();
        return filter;
    }

    private class BuildOrderNameFilter extends Filter
    {

    	@Override
        protected FilterResults performFiltering(CharSequence constraint)
        {   
            FilterResults results = new FilterResults();
            String searchString = constraint.toString().toLowerCase();

            if (searchString == null || searchString.length() == 0)
            {
                ArrayList<BuildOrder> list = new ArrayList<BuildOrder>(unfilteredBOs);
                results.values = list;
                results.count = list.size();
            }
            else
            {
                final ArrayList<BuildOrder> list = new ArrayList<BuildOrder>(unfilteredBOs);
                final ArrayList<BuildOrder> nlist = new ArrayList<BuildOrder>();
                int count = list.size();

                for (int i=0; i<count; i++)
                {
                    final BuildOrder buildorder = list.get(i);
                    final String value = buildorder.GetName().toLowerCase();

                    if (value.toLowerCase().contains(searchString))
                    {
                        nlist.add(buildorder);
                    }
                }
                results.values = nlist;
                results.count = nlist.size();
            }
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredBOs = (ArrayList<BuildOrder>)results.values;

            clear();
            int count = filteredBOs.size();
            for (int i=0; i<count; i++)
            {
                BuildOrder BuildOrder = (BuildOrder)filteredBOs.get(i);
                add(BuildOrder);
            }
        }

    }

}
