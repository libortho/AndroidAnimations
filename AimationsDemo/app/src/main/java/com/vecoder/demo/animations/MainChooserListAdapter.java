package com.vecoder.demo.animations;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v.gacina on 6/29/2016.
 */
public class MainChooserListAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mItems;

    public MainChooserListAdapter(Context context, List<String> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = inflater.inflate(android.R.layout.activity_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.mTitle = (TextView) convertView.findViewById(android.R.id.text1);
            viewHolder.mImage = (ImageView) convertView.findViewById(android.R.id.icon);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mImage.setImageResource(R.drawable.ic_chooser_generic);
        viewHolder.mTitle.setText(mItems.get(position));

        return convertView;
    }

    static class ViewHolder {
        ImageView mImage;
        TextView mTitle;

    }
}
