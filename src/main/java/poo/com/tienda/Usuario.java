package poo.com.tienda;


import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class Usuario {
    private String nombreUsuario;
    private String cedulaUsuario;
    private String direccionUsuario;
    private String Usuario;
    private String Contraseña;

    public Usuario(String nombreUsuario, String cedulaUsuario, String direccionUsuario, String Usuario, String Contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.cedulaUsuario = cedulaUsuario;
        this.direccionUsuario = direccionUsuario;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
    }

    public Usuario() {
        nombreUsuario = "";
        cedulaUsuario = "";
        direccionUsuario = "";
        Usuario = "";
        Contraseña = "";
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        if(validarCedula(cedulaUsuario)){
            this.cedulaUsuario = cedulaUsuario;
        }else{
            JOptionPane.showMessageDialog(null, "La cedula no es valida", "Error en los datos", 0);
        }
        
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    /**
     * Este metodo retorna los atributos que contiene la clase Usuario en forma de String.
     * @return 
     */
    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", cedulaUsuario=" + cedulaUsuario + ", direccionUsuario=" + direccionUsuario + ", Usuario=" + Usuario + ", Contrase\u00f1a=" + Contraseña + '}';
    }
    
    /**
     * Este metodo valida que la cedula del usuario sea ecuatoriana.
     * @param cedula
     * @return 
     */
    public boolean validarCedula(String cedula) {

        if (cedula.length() != 10) {
            return false;
        }

        int provincia = Integer.parseInt(cedula.substring(0, 2));
        int tercerDigito = Character.getNumericValue(cedula.charAt(2));

        if (provincia < 1 || provincia > 24 || tercerDigito >= 6) {
            return false;
        }

        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cedula.charAt(i));
            int resultado = digito;

            if (i % 2 == 0) { 
                resultado *= 2;
                if (resultado > 9) {
                    resultado -= 9;
                }
            }

            suma += resultado;
        }

        int residuo = suma % 10;
        int digitoVerificador = residuo == 0 ? 0 : 10 - residuo;

        int ultimoDigito = Character.getNumericValue(cedula.charAt(9));
        return digitoVerificador == ultimoDigito;
    }
}

