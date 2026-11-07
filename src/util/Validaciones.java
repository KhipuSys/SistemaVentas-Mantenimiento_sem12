package util;

public class Validaciones {

    public static boolean validarDni(String dni) {
        if (dni == null) return false;
        if (dni.length() != 8) return false;
        return dni.matches("\\d{8}"); // solo dígitos
    }

    public static boolean validarPrecio(double precio) {
        return precio > 0;
    }

    public static boolean validarCantidad(int cantidad) {
        return cantidad > 0;
    }
}
