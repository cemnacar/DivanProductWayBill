package kocsistem.divanproductwaybill;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import kocsistem.divanproductwaybill.model.OrderDTO;
import kocsistem.divanproductwaybill.model.OrderDetailDTO;

public class ProductMovementDetailActivity extends Activity {

    OrderDTO order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_movement_detail);
        order = (OrderDTO)getIntent().getSerializableExtra("Order");

        TableLayout orderLayout = (TableLayout)findViewById(R.id.order_detail_list);

        final Context context = getApplicationContext();

        TableRow tr;
        TextView productCol;
        TextView quantityCol;
        TextView unitCol;

        for (final OrderDetailDTO item:order.Items) {
            tr = new TableRow(context);
            productCol = new TextView(context);
            productCol.setText(item.ProductName);
            productCol.setTextColor(Color.BLACK);
            productCol.setWidth(400);
            productCol.setLayoutParams(new TableRow.LayoutParams(0));
            //orderCol.setBackground(getDrawable(R.drawable.border));

            tr.addView(productCol);

            quantityCol = new TextView(context);
            quantityCol.setText("" + item.Quantity);
            quantityCol.setTextColor(Color.BLACK);
            quantityCol.setWidth(400);
            quantityCol.setLayoutParams(new TableRow.LayoutParams(1));
            //storageCol.setBackground(getDrawable(R.drawable.border));

            tr.addView(quantityCol);

            unitCol = new TextView(context);
            unitCol.setText(item.Unit);
            unitCol.setTextColor(Color.BLACK);
            unitCol.setWidth(280);
            unitCol.setLayoutParams(new TableRow.LayoutParams(2));
            //storageCol.setBackground(getDrawable(R.drawable.border));

            tr.addView(unitCol);

            orderLayout.addView(tr);

        }

        ((TextView)findViewById(R.id.txt)).setText(order.DocumentNo);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product_movement_detail, menu);
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

    public void onPmdBtnClick(View v){
        Intent intent = new Intent(ProductMovementDetailActivity.this, ProductMovementBarcodeActivity.class);
        intent.putExtra("Order", order); //Your id
        startActivity(intent);

    }
}
