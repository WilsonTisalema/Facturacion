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
public class calculoCodBarras {

    public boolean verificador13D(String codigo) {
        boolean ok = false;
        System.out.println(codigo);
        float pares = 0;
        float impares = 0;
        float mulx3 = 0;
        String codigo2 = codigo;
        for (int i = 0; i < codigo2.length() - 1; i = i + 2) {
            String caracter = String.valueOf(codigo.charAt(i));
            float num = Float.valueOf(caracter);
            impares = impares + num;
            //System.out.println(num);
        }
        for (int i = 1; i < codigo2.length() - 1; i = i + 2) {
            //System.out.println(codigo.charAt(i));
            String caracter = String.valueOf(codigo.charAt(i));
            float num = Float.valueOf(caracter);
            pares = pares + num;
        }
        //System.out.println(impares+" + "+pares);

        float sum = (pares * 3) + impares;
        //System.out.println(sum);
        
        String ver = String.valueOf(sum);
        String apoyo;
        if (sum <= 100) {
            apoyo = String.valueOf(ver.charAt(0));
            //System.out.println("apoyo menor a 100");
        } else {
            apoyo = String.valueOf(ver.subSequence(0, 2));
           // System.out.println("apoyo mayor a 100");
        }
        float paraVer = Float.valueOf(apoyo);
        paraVer = paraVer + 1;
        float mult = paraVer * 10;
        String numeroVerficador = String.valueOf(codigo.charAt(codigo.length() - 1));
        float digitoVerificador = Float.valueOf(numeroVerficador);
        // System.out.println("numero verificado "+digitoVerificador);
        float verificadorOperaciones = 0;
       
            float restarNumero = mult - sum;
            //System.out.println("resta "+restarNumero);
            if (digitoVerificador == restarNumero) {
                System.out.println("ok numero verificador 13 digit"+restarNumero+" + "+digitoVerificador);
                ok = true;
            }
        
        //System.out.println(paraVer+"  apoyo");
        return ok;
    }

    public boolean verificador(String codigo) {
        boolean ok = false;
        System.out.println(codigo + " bar code");
        float pares = 0;
        float impares = 0;
        float mulx3 = 0;
        String codigo2 = codigo;
        for (int i = 0; i < codigo2.length() - 1; i = i + 2) {
            String caracter = String.valueOf(codigo.charAt(i));
            float num = Float.valueOf(caracter);
            impares = impares + num;
            //System.out.println(num);
        }
        for (int i = 1; i < codigo2.length() - 1; i = i + 2) {
            //System.out.println(codigo.charAt(i));
            String caracter = String.valueOf(codigo.charAt(i));
            float num = Float.valueOf(caracter);
            pares = pares + num;
        }
        //System.out.println(impares + " + " + pares);

        float sum = (impares * 3) + pares;
        //System.out.println(sum+" suma multiplicando por 3");
        String ver = String.valueOf(sum);
        String apoyo;
        if (sum <= 100) {
            apoyo = String.valueOf(ver.charAt(0));
            //System.out.println("apoyo menor a 100");
        } else {
            apoyo = String.valueOf(ver.subSequence(0, 2));
           // System.out.println("apoyo mayor a 100");
        }
        //System.out.println(apoyo + " apoyo dato");
        float paraVer = Float.valueOf(apoyo);
        paraVer = paraVer + 1;
        float mult = paraVer * 10;
        String numeroVerficador = String.valueOf(codigo.charAt(codigo.length() - 1));
        float digitoVerificador = Float.valueOf(numeroVerficador);
        System.out.println(digitoVerificador);
        // System.out.println("numero verificado "+digitoVerificador);
        float verificadorOperaciones = 0;
        
            float restarNumero = mult - sum;
            //System.out.println("resta "+restarNumero);
            if (digitoVerificador == restarNumero) {
                ok = true;
                System.out.println("esta bien "+restarNumero + " + "+ digitoVerificador);
            }
        
        //System.out.println(paraVer+"  apoyo");
        return ok;
    }

}
