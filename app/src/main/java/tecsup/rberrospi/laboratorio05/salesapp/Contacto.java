package tecsup.rberrospi.laboratorio05.salesapp;

public class Contacto {

    private String nombre;
    private String correo;
    private String oficina;
    private int telefono;

    @Override
    public String toString() {
        return "Nombre : " + nombre + "\n" +
                "Correo : " + correo + "\n" +
                "Oficina : "+ oficina + "\n" +
                "Teléfono : " + telefono;
    }

    public String getNombres() {
        return nombre;
    }

    public void setNombres(String nombres) {
        this.nombre = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Contacto(String nombres, String correo, String oficina, int telefono) {
        this.nombre = nombres;
        this.correo = correo;
        this.oficina = oficina;
        this.telefono = telefono;
    }

    public Contacto (){

    }


}
