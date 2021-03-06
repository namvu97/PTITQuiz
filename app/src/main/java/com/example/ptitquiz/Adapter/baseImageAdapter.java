package com.example.ptitquiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptitquiz.Model.baseImage;
import com.example.ptitquiz.R;

import java.util.List;

public class baseImageAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<baseImage> hinhanhList;

    public baseImageAdapter(Context context, int layout, List<baseImage> hinhanhList) {
        this.context = context;
        this.layout = layout;
        this.hinhanhList = hinhanhList;
    }

    @Override
    public int getCount() {
        return hinhanhList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.imgHinh = (ImageView) convertView.findViewById(R.id.imageHolder);
            holder.txtTen = (TextView) convertView.findViewById(R.id.namePlacer);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        baseImage image = hinhanhList.get(position);
        holder.imgHinh.setImageResource(image.getHinh());
        holder.txtTen.setText(image.getTen());
        return convertView;
    }
}
