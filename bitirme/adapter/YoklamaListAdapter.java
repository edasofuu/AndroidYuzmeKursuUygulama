package com.android.bitirme.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.samet.anasayfa.R;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class YoklamaListAdapter extends BaseAdapter
{

    private Context context;
    private LayoutInflater inflater;
    String nameSurname[];
    String pidNo[];

    public YoklamaListAdapter(Context context, String nameSurname[] , String pidNo[]) {
        this.context = context;
        this.nameSurname = nameSurname;
        this.pidNo =pidNo;
    }


    @Override
    public int getCount() {
        return nameSurname.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView name, tckn;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View itemView = inflater.inflate(R.layout.yoklama_list_item, parent, false);
        name = itemView.findViewById(R.id.nameSurname);
        tckn = itemView.findViewById(R.id.pidNo);


            name.setText(nameSurname[position]);
            tckn.setText(pidNo[position]);



        return itemView;
    }


}

