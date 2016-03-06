package net.infobosccoma.clashofclansalvaro.views.impl.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.infobosccoma.clashofclansalvaro.R;
import net.infobosccoma.clashofclansalvaro.models.business.entities.Atac;

import java.util.List;

public class AtacListAdapter extends ArrayAdapter<Atac> {
    private Context context;
    private LayoutInflater inflater;

    public AtacListAdapter(Context context, List<Atac> comments) {
        super(context, 0, comments);

        this.context = context;
        this.inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AtacHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_list, parent, false);

            holder = new AtacHolder();
            addViewsToHolder(convertView, holder);
            convertView.setTag(holder);
        } else {
            holder = (AtacHolder) convertView.getTag();
        }
        Atac atac = getItem(position);
        setDataIntoHolder(holder, atac);

        return convertView;
    }

    private void addViewsToHolder(View convertView, AtacHolder holder) {
        holder.name = (TextView) convertView.findViewById(R.id.main_txtview_name);
//        holder.th = (TextView) convertView.findViewById(R.id.txtview_th);
//        holder.tropes = (TextView) convertView.findViewById(R.id.txtview_tropes);
//        holder.pocions = (TextView) convertView.findViewById(R.id.txtview_pocions);
//        holder.descripcio = (TextView) convertView.findViewById(R.id.txtview_descripcio);
    }

    private void setDataIntoHolder(AtacHolder holder, Atac atac) {
        //Picasso.with(context).load(image.getUrl()).fit().into(holder.image);
        holder.name.setText(atac.getNom());
//        holder.th.setText(atac.getTh());
//        holder.tropes.setText(atac.getTropes());
//        holder.pocions.setText(atac.getPocions());
//        holder.descripcio.setText(atac.getDescripcio());
    }

    class AtacHolder {
        TextView name;
//        TextView th;
//        TextView tropes;
//        TextView pocions;
//        TextView descripcio;
    }

}
