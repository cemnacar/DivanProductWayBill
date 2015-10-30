package kocsistem.divanproductwaybill;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import kocsistem.divanproductwaybill.utils.*;
import kocsistem.divanproductwaybill.model.*;


public class MainActivity extends Activity {

    Button girisButon;
    TextView kullaniciAdiText,sifreText;
    String username="onurhan";
    String password="123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onclick(View a){
        Intent myIntent = new Intent(MainActivity.this, ProductMovementActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
}
