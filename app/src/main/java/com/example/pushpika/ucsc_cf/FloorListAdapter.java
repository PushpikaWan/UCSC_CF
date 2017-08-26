package com.example.pushpika.ucsc_cf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by pushpika on 8/26/17.
 */

public class FloorListAdapter extends BaseAdapter {

    String[] floors;
    String[] floorsDesc;
    Context context;
    LayoutInflater inflter;

    public FloorListAdapter (Context applicationContext, String[] floors, String[] floorsDesc) {
        this.context = applicationContext;
        this.floors = floors;
        this.floorsDesc = floorsDesc;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return floors.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.floor_list_item, null);
        TextView floor_name = (TextView) view.findViewById(R.id.floor_name);
        TextView floor_desc = (TextView) view.findViewById(R.id.floor_desc);
        floor_name.setText(floors[i]);
        floor_desc.setText(floorsDesc[i]);
        return view;
    }
}
