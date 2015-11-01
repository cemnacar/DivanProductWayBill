package kocsistem.divanproductwaybill;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;

import kocsistem.divanproductwaybill.adapter.OrderAdapter;
import kocsistem.divanproductwaybill.model.OrderDTO;
import kocsistem.divanproductwaybill.model.OrderDetailDTO;
import kocsistem.divanproductwaybill.utils.Common;

public class ProductMovementActivity extends Activity {

    OrderAdapter adapter;
    EditText dateTxt;
    OrderDTO[] rs;

    public class GetOrders extends AsyncTask<Void, Void, OrderDTO[]> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected OrderDTO[] doInBackground(Void... params) {
            String result = Common.getJSON("https://barkod.divan.com.tr/api/Product/ListOrders", 6000);

            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

            rs = gson.fromJson(result, OrderDTO[].class);

            return rs;

            //adapter = new OrderAdapter(getApplicationContext(),rs);

            //return adapter;
        }

        @Override
        protected void onPostExecute(final OrderDTO[] res) {

            TableLayout orderLayout = (TableLayout)findViewById(R.id.order_list);

            final Context context = getApplicationContext();

            TableRow tr;
            TextView orderCol;
            TextView storageCol;
            Button btn;

            for (final OrderDTO order:rs) {
                tr = new TableRow(context);
                orderCol = new TextView(context);
                orderCol.setText(order.DocumentNo);
                orderCol.setTextColor(Color.BLACK);
                orderCol.setWidth(400);
                orderCol.setLayoutParams(new TableRow.LayoutParams(0));
                //orderCol.setBackground(getDrawable(R.drawable.border));

                tr.addView(orderCol);

                storageCol = new TextView(context);
                storageCol.setText(order.Storage);
                storageCol.setTextColor(Color.BLACK);
                storageCol.setWidth(400);
                storageCol.setLayoutParams(new TableRow.LayoutParams(1));
                //storageCol.setBackground(getDrawable(R.drawable.border));

                tr.addView(storageCol);

                btn = new Button(context);
                btn.setText("Sec");
                btn.setWidth(280);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ProductMovementActivity.this, ProductMovementDetailActivity.class);
                        intent.putExtra("Order", order); //Your id
                        startActivity(intent);
                    }
                });
                btn.setLayoutParams(new TableRow.LayoutParams(2));
                //btn.setBackground(getDrawable(R.drawable.border));

                tr.addView(btn);

                orderLayout.addView(tr);

            }

            }
            /*GridView gw = (GridView)findViewById(R.id.gridView);

            gw.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ProductMovementActivity.this, ProductMovementDetailActivity.class);
                    intent.putExtra("Order", (OrderDTO) adapter.getItem(position)); //Your id
                    startActivity(intent);
                }
            });
            gw.setAdapter(res);*/

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_movement);
        dateTxt = ((EditText)findViewById(R.id.dateTxt));
        Calendar c = Calendar.getInstance();
        dateTxt.setText(c.get(Calendar.DAY_OF_MONTH)+"-"+(c.get(Calendar.MONTH)+(int)1) +"-"+c.get(Calendar.YEAR));
        GetOrders task = new GetOrders();
        task.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product_movement, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onDateClick(View v){

        String selectedDate = dateTxt.getText().toString();
        int mYear =  Integer.parseInt(selectedDate.split("-")[2]);
        int mMonth = Integer.parseInt(selectedDate.split("-")[1])-1;
        int mDay = Integer.parseInt(selectedDate.split("-")[0]);

        // Launch Date Picker Dialog
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dateTxt.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
        dpd.show();
    }
}
