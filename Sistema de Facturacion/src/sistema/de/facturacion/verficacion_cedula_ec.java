/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.facturacion;

/**
 *
 * @author Benjita
 */
public class verficacion_cedula_ec {
    public static boolean verificaCedula(String ced) {
        int c = ced.length(), i, sumaTotal;
        //String temp="   "; tercer metodo char a entero
        //temp [1]= '\0';
        if (c != 10) {
            return false;
        }
        for (i = 0; i < c; i = i + 1) {     // todos digitos control
            if (ced.charAt(i) < 48 || ced.charAt(i) > 57) {
                return false;
            }
        }
        // logitud correcta
        int sp = 0;
        for (i = 1; i < c - 1; i = i + 2) {// posiciones pares
            sp += Character.getNumericValue(ced.charAt(i));
            //sp+=(ced.charAt(i))-48;  otra forma del la linea anterior
            // temp = Character.toString(ced.charAt(i));
            //sp+= Integer.valueOf(temp);
        }
        //System.out.println(sp); conprobacion

        int si = 0, si2 = 0;
        for (i = 0; i < c - 1; i = i + 2) {// posiciones pares
            si2 += (Character.getNumericValue(ced.charAt(i))) * 2;
            if (si2 > 9) {
                si2 = si2 - 9;
            }
            si += si2;
            si2 = 0;
        }
        sumaTotal = si + sp;
        // comprobacion del ultimo diguito
        int z;
        z = (ced.charAt(9) - 48);
        {
            if (sumaTotal % 10 == 0) {
                if (z == 0) {

                    return true;
                } else {
                    return false;
                }
            } else {
                int a = (((sumaTotal / 10) + 1) * 10) - sumaTotal;
                if (z == a) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(verificaCedula("1805364427"));
    }
}
