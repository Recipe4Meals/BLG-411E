package com.two.project.computer.recipe4meals;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuItemAdapter extends ArrayAdapter<MenuItem>{
    Context mContext;
    int mLayoutResourceId;
    MenuItem mData[] = null;

    public MenuItemAdapter(Context context, int resource, MenuItem[] data){
        super(context, resource, data);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;
    }

    @Override
    public MenuItem getItem(int position){
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        /*Static list view
        View row = convertView;
        //inflate the layour for a single row
        LayoutInflater inflater = LayoutInflater.from(mContext);
        row = inflater.inflate(mLayoutResourceId,parent,false);

        //get a reference to the different view elements we wish to update
        TextView nameView = (TextView) row.findViewById(R.id.nameTextView);
        TextView infoView = (TextView) row.findViewById(R.id.infoTextView);
        ImageView imageView = (ImageView) row.findViewById(R.id.imageView);

        //get the data from the data array
        MenuItem MI = mData[position];

        //setting the view to reflect the data we need to display
        nameView.setText(MI.MealName);
        infoView.setText(MI.MealInfo);

        int resId = mContext.getResources().getIdentifier(MI.NameOfImage,"drawable",mContext.getPackageName());
        imageView.setImageResource(resId);

        //returnning the row view (because this is called getView after all)
        return row;
        */

        View row = convertView;
        MenuItemHolder holder = null;

        if(row == null){
            //Create a new view
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId,parent,false);

            holder = new MenuItemHolder();

            holder.nameView = (TextView) row.findViewById(R.id.nameTextView);
            holder.infoView = (TextView) row.findViewById(R.id.infoTextView);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);

            row.setTag(holder);
        }else{
            //Otherwise use an existing one
            holder = (MenuItemHolder) row.getTag();
        }

        //Getting the data form the data array
        MenuItem MI = mData[position];

        //Setup and reuse the same listener for each row
        holder.imageView.setOnClickListener(PopupListener);
        Integer rowPosition = position;
        holder.imageView.setTag(rowPosition);

        //setting the view to reflect the data we need to display
        holder.nameView.setText(MI.MealName);
        holder.infoView.setText(MI.MealInfo);

        //for getting the image
        int resId = mContext.getResources().getIdentifier(MI.NameOfImage,"drawable",mContext.getPackageName());
        holder.imageView.setImageResource(resId);

        //returnning the row view (because this is called getView after all)
        return row;
    }

    View.OnClickListener PopupListener = new View.OnClickListener(){
        @Override
        public  void onClick(View view){
            Integer viewPosition = (Integer) view.getTag();
            MenuItem MI = mData[viewPosition];
            Toast.makeText(getContext(),MI.MealName, Toast.LENGTH_SHORT).show();
        }
    };

    private static class MenuItemHolder{
        TextView nameView;
        TextView infoView;
        ImageView imageView;
    }
}
