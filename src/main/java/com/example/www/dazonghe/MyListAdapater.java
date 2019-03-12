package com.example.www.dazonghe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.www.dazonghe.bean.One;

import java.util.ArrayList;

public class MyListAdapater extends BaseAdapter {
    private Context context;
    private ArrayList<One> list;

    public MyListAdapater(Context context, ArrayList<One> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.item1, null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.imageview);
            holder.textView = convertView.findViewById(R.id.textview);
            holder.textView1 = convertView.findViewById(R.id.textview1);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getMasterPic()).into(holder.imageView);
        holder.textView.setText(list.get(position).getCommodityName());
        holder.textView1.setText(list.get(position).getCommodityId()+"");
        return convertView;
    }
    class ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private TextView textView1;
    }
}
