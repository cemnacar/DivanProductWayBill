package kocsistem.divanproductwaybill;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import kocsistem.divanproductwaybill.model.MessageDTO;
import kocsistem.divanproductwaybill.model.OrderDTO;
import kocsistem.divanproductwaybill.model.OrderDetailDTO;
import kocsistem.divanproductwaybill.utils.Common;

public class ProductMovementSummaryActivity extends Activity {

    OrderDTO order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_movement_summary);
        Bundle extras = getIntent().getExtras();
        order = (OrderDTO)extras.getSerializable("Order");
        String barcodes = extras.getString("Barcode");

        for (String barcode: barcodes.split(";")) {
            String isDecimal = barcode.substring(0,1);
            String productNo = barcode.substring(1,8);
            String partyNo = barcode.substring(8,18);
            String quantity = barcode.substring(18,23);
            String unit = barcode.substring(23,25);


            for (OrderDetailDTO detail:order.Items){
                if(detail.ProductNo.trim().equals(productNo)){
                    detail.BarcodeQuantity = isDecimal.equals("1")? Double.parseDouble(quantity)/1000  : Double.parseDouble(quantity);
                    break;
                }
            }
        }


        TableLayout orderLayout = (TableLayout)findViewById(R.id.order_summary_list);

        final Context context = getApplicationContext();

        TableRow tr;
        TextView productCol;
        TextView quantityCol;
        TextView unitCol;
        TextView barcodeQuantityCol;

        for (final OrderDetailDTO item:order.Items) {
            tr = new TableRow(context);
            productCol = new TextView(context);
            productCol.setText(item.ProductName);
            productCol.setTextColor(Color.BLACK);
            productCol.setWidth(300);
            productCol.setLayoutParams(new TableRow.LayoutParams(0));
            //orderCol.setBackground(getDrawable(R.drawable.border));

            tr.addView(productCol);

            quantityCol = new TextView(context);
            quantityCol.setText("" + item.Quantity);
            quantityCol.setTextColor(Color.BLACK);
            quantityCol.setWidth(300);
            quantityCol.setLayoutParams(new TableRow.LayoutParams(1));
            //storageCol.setBackground(getDrawable(R.drawable.border));

            tr.addView(quantityCol);

            unitCol = new TextView(context);
            unitCol.setText(item.Unit);
            unitCol.setTextColor(Color.BLACK);
            unitCol.setWidth(200);
            unitCol.setLayoutParams(new TableRow.LayoutParams(2));
            //storageCol.setBackground(getDrawable(R.drawable.border));

            tr.addView(unitCol);

            barcodeQuantityCol = new TextView(context);
            barcodeQuantityCol.setText((item.Quantity - item.BarcodeQuantity)+"");
            barcodeQuantityCol.setTextColor(Color.BLACK);
            barcodeQuantityCol.setWidth(250);
            barcodeQuantityCol.setLayoutParams(new TableRow.LayoutParams(3));
            //storageCol.setBackground(getDrawable(R.drawable.border));

            tr.addView(barcodeQuantityCol);

            orderLayout.addView(tr);

        }

        //((TextView)findViewById(R.id.txt)).setText(order.DocumentNo);

    }

    public class SendOrders extends AsyncTask<Void, Void, MessageDTO[]> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected MessageDTO[] doInBackground(Void... params) {
            String response = Common.postJSON("https://barkod.divan.com.tr/api/Product/SendOrders",  new Gson().toJson(order), 6000);

            return new Gson().fromJson(response, MessageDTO[].class);

            //adapter = new OrderAdapter(getApplicationContext(),rs);

            //return adapter;
        }

        @Override
        protected void onPostExecute(final MessageDTO[] res) {

            for (MessageDTO message:
                 res) {
                Toast toast = new Toast(getApplicationContext());
                toast.makeText(getApplicationContext(),message.Mesaj,Toast.LENGTH_LONG).show();
            }

        }
    }

    public void onPmsBtnClick(View v){
        SendOrders task = new SendOrders();
        task.execute();


    }
}
