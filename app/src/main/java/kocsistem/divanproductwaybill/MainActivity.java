package kocsistem.divanproductwaybill;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;



public class MainActivity extends AppCompatActivity {

    Button girisButon;
    TextView kullaniciAdiText,sifreText;
    String username="onurhan";
    String password="123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar actionbar= getSupportActionBar();
        actionbar.hide();

        girisButon=(Button)findViewById(R.id.girisBt);
        kullaniciAdiText=(TextView)findViewById(R.id.kullaniciAdiTxt);
        sifreText=(TextView)findViewById(R.id.sifreTxt);

        girisButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kullaniciAdiValue=kullaniciAdiText.getText().toString();
                String sifreValue=sifreText.getText().toString();

                Intent intent = new Intent(MainActivity.this, processList.class);
                intent.putExtra("kullaniciAdi",kullaniciAdiValue);
                intent.putExtra("sifre", sifreValue);

                if (kullaniciAdiValue==null || kullaniciAdiValue=="")
                {

                }
                else if (sifreValue==null || sifreValue=="")
                {

                }
                else if(kullaniciAdiValue==username.toString() && sifreValue==password.toString())
                {


                }
                else {

                }
                startActivity(intent);
            }});




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
