package com.example.lv_with_custom_adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class CustomAdapter extends BaseAdapter {

    public CustomAdapter(Activity context, String[] district, Integer[] imageid, String[] area, String[] population) {
        this.context = context;
        this.district = district;
        this.imageid = imageid;
        this.area = area;
        this.population = population;
    }

    private final Activity context;
    private final String[] district;
    private final Integer[] imageid;
    private final String[] area;
    private final String[] population;

    @Override
    public int getCount() {
        return district.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // LayoutInflater inflater = context.getLayoutInflater();
        // View rowView = inflater.inflate(R.layout.custom_1, null, true);
        // TextView textView=(TextView) rowView.findViewById(R.id.txt);
        //ImageView imageView=(ImageView) rowView.findViewById(R.id.img);
        //  TextView population2=(TextView) rowView.findViewById(R.id.textView);
        //  TextView area2=(TextView) rowView.findViewById(R.id.textView2);

        //population2.setText(population[position]);
        //area2.setText(area[position]);
        //textView.setText(district[position]);
        //imageView.setImageResource(imageid[position]);
        //return rowView;
        ViewHolder vh;
        if(convertView==null)
        {
            convertView=LayoutInflater.from(context).inflate(R.layout.custom_1,parent, false);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);

        }
        else
        {
            vh=(ViewHolder) convertView.getTag();
        }

        vh.textView.setText(district[position]);
        vh.textView1.setText(area[position]);
        vh.textView2.setText(population[position]);
        vh.imageView.setImageResource(imageid[position]);
//        if (convertView == null) {
//            //inflate the layout for each item of listview
//            LayoutInflater inflater = context.getLayoutInflater();
//            convertView = inflater.inflate(R.layout.custom_1, null, true);
//        }
//
//        TextView textView = (TextView) convertView.findViewById(R.id.txt);
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.img);
//        textView.setText(district[position]);
//        imageView.setImageResource(imageid[position]);
        return convertView;
    }
    private  class ViewHolder
    {
        TextView textView;
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        public ViewHolder(View view)
        {
            textView=(TextView) view.findViewById(R.id.txt);
            imageView=(android.widget.ImageView) view.findViewById(R.id.img);
            textView1=(TextView) view.findViewById(R.id.textView);
            textView2=(TextView) view.findViewById(R.id.textView2);
        }
    }

}

