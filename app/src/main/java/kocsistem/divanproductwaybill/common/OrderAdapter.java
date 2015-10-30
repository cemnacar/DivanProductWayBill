package kocsistem.divanproductwaybill.common;

import android.content.Context;
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
    public OrderAdapter(OrderDTO[] _arr)
    {
        arr = _arr;
    }
    @Override
    public int getCount() {
        return arr.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(ctx);
        textView.setText(arr[position].DocumentNo);
        return textView;
    }
}
