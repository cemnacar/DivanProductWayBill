package kocsistem.divanproductwaybill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import kocsistem.divanproductwaybill.model.OrderDTO;

public class ProductMovementBarcodeActivity extends Activity {

    OrderDTO order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_movement_barcode);
        order = (OrderDTO)getIntent().getSerializableExtra("Order");
    }

    public void onPmbBtnClick(View v){
        Intent intent = new Intent(ProductMovementBarcodeActivity.this, ProductMovementSummaryActivity.class);
        Bundle extras = new Bundle();
        extras.putSerializable("Order", order); //Your id
        extras.putString("Barcode", ((EditText) findViewById(R.id.pmbTxt)).getText().toString());
        intent.putExtras(extras);
        startActivity(intent);

    }
}
