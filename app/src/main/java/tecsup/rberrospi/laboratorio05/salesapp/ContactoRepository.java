package tecsup.rberrospi.laboratorio05.salesapp;

import java.util.ArrayList;
import java.util.List;

public class ContactoRepository {

    private static ContactoRepository _INSTANCE = null;

    private ContactoRepository(){}

    public static ContactoRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new ContactoRepository();
        return _INSTANCE;
    }

    private List<Contacto> contactos = new ArrayList<>();

    public List<Contacto> getContactos() {
        return this.contactos;
    }

    public void agregarContacto(Contacto contacto){
        this.contactos.add(contacto);
    }

}
