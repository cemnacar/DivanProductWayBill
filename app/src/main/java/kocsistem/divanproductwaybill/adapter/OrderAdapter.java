package kocsistem.divanproductwaybill.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import kocsistem.divanproductwaybill.model.OrderDTO;

/**
 * Created by 02482957 on 30.10.2015.
 */
public class OrderAdapter extends BaseAdapter {

    Context ctx;
    OrderDTO[] arr;
    public OrderAdapter(Context _ctx ,OrderDTO[] _arr)
    {
        arr = _arr;
        ctx = _ctx;
    }
    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int position) {
        return arr[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(ctx);
        textView.setTextColor(Color.BLACK);
        textView.setText(arr[position].DocumentNo);
        return textView;
    }
}
