package kocsistem.divanproductwaybill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kocsistem.divanproductwaybill.common.Common;
import kocsistem.divanproductwaybill.common.OrderAdapter;
import kocsistem.divanproductwaybill.model.OrderDTO;

public class ProductMovementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_movement);
        Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    String result = Common.getJSON("https://barkod.divan.com.tr/api/Product/ListOrders", 6000);
                    try{
                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

                        OrderDTO[] rs = gson.fromJson(result, OrderDTO[].class);

                        OrderAdapter oa = new OrderAdapter(rs);

                        GridView gw = (GridView)findViewById(R.id.gridView);

                        gw.setAdapter(oa);
                        //ArrayAdapter<OrderDTO> adapter = new ArrayAdapter<OrderDTO>(this, R.layout.order_item, R.id, rs);
                        String ss = "";
                    }
                    catch (Exception e){
                        String ts = "ce";
                    }

                }
        });

        thread.start();
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
}
