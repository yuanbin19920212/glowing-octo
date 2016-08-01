package com.wj.yuanbin.checkableviewtest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanbin on 16/7/20.
 *
 * /
 */
public class MainActivity extends Activity {


    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        listView = (ListView)findViewById(R.id.list);
        List<Item> items = new ArrayList<Item>();
        for (int i = 0 ; i < 100 ; i++){
            Item item = new Item();
            item.txt = "sdfsd"+i;
            items.add(item);
        }
        CheckableAdapter checkableAdapter = new CheckableAdapter(this,-1,items);
        listView.setAdapter(checkableAdapter);
        listView.setItemChecked(5,true);
    }


    static class CheckableAdapter extends ArrayAdapter<Item>{

        public CheckableAdapter(Context context, int resource, List<Item> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout,null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder)convertView.getTag();
            }
            TextView textView = viewHolder.getView(R.id.txt);
            textView.setText(getItem(position).txt);
            Item item = getItem(position);
            CheckBox checkBox = viewHolder.getView(R.id.checkbox);
            item.isChecked = checkBox.isChecked();
            return convertView;
        }
    }

    /***
     * item
     */
    static class Item{
        String txt;
        boolean isChecked;
    }
}
