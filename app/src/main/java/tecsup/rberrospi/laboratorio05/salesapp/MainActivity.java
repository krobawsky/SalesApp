package tecsup.rberrospi.laboratorio05.salesapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REGISTER_FORM_REQUEST = 100;

    private ListView list, Correo, Oficina, Telefono;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
    }

    public void addContacto(View view){
        startActivityForResult(new Intent(this, AgregarActivity.class), REGISTER_FORM_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) list.getAdapter();
        adapter.clear();

        final ContactoRepository contactoRepository = ContactoRepository.getInstance();
        final List<Contacto> contactos = contactoRepository.getContactos();
        final Intent intent = new Intent(this, DetalleActivity.class);

        for (final Contacto contacto : contactos) {
            adapter.add(contacto.getNombres());
            alertDialog = new AlertDialog.Builder(this).create();

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
                    Contacto contacto = contactos.get(posicion);

                    intent.putExtra("contenido", String.valueOf(contacto));

                    startActivity(intent);

                }
            });

        }
    }
}
