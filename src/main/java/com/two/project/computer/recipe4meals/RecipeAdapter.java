package com.two.project.computer.recipe4meals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecipeAdapter {
    Context mContext;
    int mLayoutResourceId;
    Recipe mData[] = null;

    public RecipeAdapter(Context context, int resource, Recipe[] data){
        super(context, resource, data);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;
    }

    @Override
    public Recipe getItem(int position){
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;
        RecipeAdapter.RecipeHolder holder = null;

        if(row == null){
            //Create a new view
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId,parent,false);

            holder = new RecipeAdapter.RecipeHolder();

            holder.nameView = (TextView) row.findViewById(R.id.nameTextView);
            holder.infoView = (TextView) row.findViewById(R.id.infoTextView);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);

            row.setTag(holder);
        }else{
            //Otherwise use an existing one
            holder = (RecipeAdapter.RecipeHolder) row.getTag();
        }

        //Getting the data form the data array
        Recipe Re = mData[position];

        //Setup and reuse the same listener for each row
        holder.imageView.setOnClickListener(PopupListener);
        Integer rowPosition = position;
        holder.imageView.setTag(rowPosition);

        //setting the view to reflect the data we need to display
        holder.nameView.setText(Re.get_recipe_name());
        holder.infoView.setText(Re.getRecipe_id());

        //for getting the image
        int resId = mContext.getResources().getIdentifier(Re.NameOfImage,"drawable",mContext.getPackageName());
        holder.imageView.setImageResource(resId);

        //returnning the row view (because this is called getView after all)
        return row;
    }

    View.OnClickListener PopupListener = new View.OnClickListener(){
        @Override
        public  void onClick(View view){
            Integer viewPosition = (Integer) view.getTag();
            Recipe R = mData[viewPosition];
            Toast.makeText(getContext(),R.getRecipe_name(), Toast.LENGTH_SHORT).show();
        }
    };

    private static class RecipeHolder{
        TextView nameView;
        TextView infoView;
        ImageView imageView;
    }
}
