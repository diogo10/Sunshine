package app.diogo.com.br.sunshine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diogo on 30/08/2014.
 */
public class MyAdapter extends BaseAdapter {

    private ArrayList<Clima> lista;
    private Context ctx;
    private LayoutInflater inflater;

    public MyAdapter(Context ctx,ArrayList<Clima> lista){
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
        // TODO Auto-generated method stub
        ViewHolder holder = null;

        if (view == null) {
            holder = new ViewHolder();
            int layout = R.layout.lista_item;
            view = inflater.inflate(layout, null);
            view.setTag(holder);
            holder.tv_1 = (TextView) view.findViewById(R.id.tv_1);
            holder.tv_2 = (TextView) view.findViewById(R.id.tv_2);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_1.setText(lista.get(position).getDia());
        holder.tv_2.setText(lista.get(position).getTipo());


        return view;
    }


    static class ViewHolder {
        TextView tv_1,tv_2;
    }
}
