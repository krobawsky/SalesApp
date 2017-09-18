package tecsup.rberrospi.laboratorio05.salesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity {

    private EditText nombreInput;
    private EditText correoInput;
    private EditText oficinaInput;
    private EditText telefonoInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        nombreInput = (EditText) findViewById(R.id.Nombre);
        correoInput = (EditText) findViewById(R.id.Correo);
        oficinaInput = (EditText) findViewById(R.id.Oficina);
        telefonoInput = (EditText) findViewById(R.id.Telefono);

    }

    public void register(View view){
        String nombre = nombreInput.getText().toString();
        String correo = correoInput.getText().toString();
        String oficina = oficinaInput.getText().toString();
        String telefono = telefonoInput.getText().toString();

        if(nombre.isEmpty() || correo.isEmpty() || oficina.isEmpty() || telefono.isEmpty()){
            Toast.makeText(this, "Tienes que completar los campos.", Toast.LENGTH_SHORT).show();
            return;
        }if (telefono.length()<9){
            Toast.makeText(this, "Ingresa el número telefónico.", Toast.LENGTH_SHORT).show();
        }else {

            Contacto contacto = new Contacto(nombre, correo, oficina, Integer.parseInt(telefono));

            ContactoRepository contactoRepository = ContactoRepository.getInstance();
            contactoRepository.agregarContacto(contacto);

            finish();
        }

    }
}
