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

/**
 *
 * BU SINIF YARDIMCI SINIFTIR İNTERNETETN ALINMIŞTIR
 */

public class kullaniciBilgiListesiAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, String>> models;
    private LayoutInflater inflater;

    public kullaniciBilgiListesiAdapter(Context context, List<Map<String, String>> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
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
        TextView header, info;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View itemView = inflater.inflate(R.layout.person_info_list_item, parent, false);
        header = itemView.findViewById(R.id.header);
        info = itemView.findViewById(R.id.info);

        Iterator it = models.get(position).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            header.setText(pairs.getKey().toString());
            info.setText(pairs.getValue().toString());
        }


        return itemView;
    }


}

