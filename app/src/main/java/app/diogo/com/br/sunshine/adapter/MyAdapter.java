package app.diogo.com.br.sunshine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import app.diogo.com.br.sunshine.R;
import app.diogo.com.br.sunshine.model.Clima;

/**
 * Created by Diogo on 30/08/2014.
 */
public class MyAdapter extends BaseAdapter {

    private ArrayList<Clima> lista;
    private Context ctx;
    private LayoutInflater inflater;

    public MyAdapter(Context ctx, ArrayList<Clima> lista){
        this.lista = lista;
        this.ctx = ctx;
        this.inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;

        if (view == null) {
            holder = new ViewHolder();

            view = inflater.inflate(R.layout.lista_item, parent, false);

            holder.tv_temp = (TextView) view.findViewById(R.id.tv_temp);
            holder.tv_type = (TextView) view.findViewById(R.id.tv_type);
            holder.tv_date = (TextView) view.findViewById(R.id.tv_date);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Clima clima = lista.get(position);

        holder.tv_date.setText(clima.getDia());
        holder.tv_type.setText(clima.getTipo());
        holder.tv_temp.setText( String.format("%sº/%sº", clima.getMin(), clima.getMax()));

        return view;
    }

    static class ViewHolder {

        TextView tv_temp;
        TextView tv_type;
        TextView tv_date;

    }
}
