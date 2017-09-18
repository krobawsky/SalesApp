package tecsup.rberrospi.laboratorio05.salesapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    private TextView content;
    private String contenido;
    private String numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        content = (TextView) findViewById(R.id.Content);

        if (this.getIntent() != null && this.getIntent().getExtras() != null) {

            contenido = this.getIntent().getExtras().getString("contenido");
            int t = contenido.length();
            numero =  contenido.substring(t - 9, t);
            content.setText(contenido);
        }
    }


    public void realizarMensaje(View view) {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setType("vnd.android-dir/mms-sms");
        sendIntent.putExtra("address", numero);
        sendIntent.putExtra("sms_body", "");
        startActivity(sendIntent);
    }

    public void realizarLlamada(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    Integer.parseInt("123"));
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+ numero)));
        }
    }

    public void Opciones(View view) {
        String url="tel:"+numero;
        if (url.startsWith("tel:"))
        {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
            startActivity(intent);
        }
    }
}
