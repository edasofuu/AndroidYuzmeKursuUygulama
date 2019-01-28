package com.android.bitirme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.samet.anasayfa.R;


/**
 *
 * BU SINIF YARDIMCI SINIFTIR İNTERNETETN ALINMIŞTIR
 */

public class KullaniciListesiAdapter extends BaseAdapter {
    Context context = null;
    String nameSurname[];
    String pidNo[];
    LayoutInflater inflater;

    public KullaniciListesiAdapter() {

    }

    public KullaniciListesiAdapter(Context context, String nameSurname[], String pidNo[]) {
        this.context = context;
        this.nameSurname = nameSurname;
        this.pidNo = pidNo;
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
        TextView nameFull, pID;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        nameFull = (TextView) itemView.findViewById(R.id.nameSurname);
        pID = (TextView) itemView.findViewById(R.id.pidNo);


        nameFull.setText(nameSurname[position]);
        pID.setText(pidNo[position]);


        return itemView;
    }


}

