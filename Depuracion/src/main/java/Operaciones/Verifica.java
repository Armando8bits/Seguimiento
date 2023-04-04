package Operaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ROQUEARMANDORAMIREZP
 */
public class Verifica {

    public boolean EsCorreo(String Texto) {
        boolean Rpta = true;
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" //comfigura el patrón para validar email
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(Texto);
        if (Texto.length() < 1 || Texto.length() > 245 || mather.find() == false) {
            Rpta = false;   //si la cadenaa es menor a 1 O no cuadra con el formato de email, nada ok
        }
        return Rpta;
    }

    public Boolean EsNombre(String StrTexto) {
        boolean Rpta = true;
        if (StrTexto.length() < 2) {
            Rpta = false;
        }
        for (int x = 0; x < StrTexto.length(); x++) {
            char c = StrTexto.charAt(x);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' '
                    || (c >= 'á' && c <= 'ú') || c == 'é' || c == 'Á' || c == 'É' || c == 'Í'
                    || c == 'ñ' || c == 'Ñ' || c == 'Ó' || c == 'Ú')) {
                Rpta = false; // Si no está entre a y z, ni entre A y Z, ni es un espacio
                //System.out.println("\t\t No Ingrese Caracteres Invalidos, error en caracter #" + (x + 1));
                break;// al primer fallo, acaba y no pierde tiempo analizando la cadena
            }
        }
        return Rpta;
    }

    public Boolean EsNumeroTelef(String StrTexto) {
        Boolean Rpta = true;
        if (StrTexto.length() < 7 || StrTexto.length() > 15) {
            //System.out.println("\t\tDame un Numero Creible de Minimo 10 Digitos");
            return Rpta = false;
        }
        for (int x = 0; x < StrTexto.length(); x++) {
            char c = StrTexto.charAt(x);
            if (!((c >= '0' && c <= '9') || c == '+')) {
                //System.out.println("\t\tNo Ingrese Caracteres Invalidos al Numero, Error en Digito #" + (x + 1));
                return Rpta = false; // Si no está entre 0 y 9, o "+"
                // al primer fallo, acaba y no pierde tiempo analizando la cadena
            }
        }
        return Rpta;
    }

    public Boolean EsFecha(String Cadena) {
        Boolean Rpta = true;
        int IntDia, IntMes, IntAno, dia_maximo = 0;

        if (Cadena.length() != 10) {
            //System.out.println("\t\tDame una Fecha Creible, del Formato: (AAAA-MM-DD)");
            return Rpta = false;
        }
        for (int x = 0; x < Cadena.length(); x++) {
            char c = Cadena.charAt(x);
            if (!((c >= '0' && c <= '9') || c == '-' || c == ',' || c == '/' || c == '.')) {
                //System.out.println("\t\tNo Ingrese Caracteres Invalidos a la Fecha");
                return Rpta = false; // Si no está entre 0 y 9, o "-"
                // al primer fallo, acaba y no pierde tiempo analizando la cadena
            }
        }
        IntAno = Integer.valueOf(Cadena.substring(0, 4)); //devuelve los primeros 4 caracteres
        IntMes = Integer.valueOf(Cadena.substring(5, 7));
        IntDia = Integer.valueOf(Cadena.substring(8, 10));
        //System.out.println("\t\tla Fecha Proporcionada Es: " + IntAno + "-" + IntMes + "-" + IntDia);

        if (IntMes >= 1 && IntMes <= 12 && IntAno > 1900) {
            if (IntMes == 4 || IntMes == 6 || IntMes == 9 || IntMes == 11) {
                dia_maximo = 30;
            } else if (IntMes == 2) {
                if (IntAno % 4 == 0 && IntAno % 100 != 0 || IntAno % 400 == 0) {
                    dia_maximo = 29;
                } else {
                    dia_maximo = 28;
                }
            } else if (IntMes != 2 || IntMes != 4 || IntMes != 6 || IntMes != 9 || IntMes != 11) {
                dia_maximo = 31;
            }
            if (IntDia >= 1 && IntDia <= dia_maximo) {
                Rpta = true;
            } else {
                //System.out.println("\t\tFecha Incorrecta");
                return Rpta = false;
            }
        } else {
            //System.out.println("\t\tFecha Incorrecta");
            return Rpta = false;
        }
        return Rpta;
    }
}
