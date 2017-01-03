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
    public boolean verificador13D(String codigo){
        boolean ok=false;
        System.out.println(codigo);
        float pares=0;
        float impares=0;
        float mulx3=0;
        String codigo2=codigo;
        for(int i=0;i<codigo2.length()-1;i=i+2){
            String caracter=String.valueOf(codigo.charAt(i));
            float num=Float.valueOf(caracter);
            impares=impares+num;
            //System.out.println(num);
        }
        for(int i=1;i<codigo2.length()-1;i=i+2){
           //System.out.println(codigo.charAt(i));
           String caracter=String.valueOf(codigo.charAt(i));
            float num=Float.valueOf(caracter);
            pares=pares+num;
        }
        //System.out.println(impares+" + "+pares);
       
        float sum=(pares*3)+impares;
        //System.out.println(sum);
        String ver=String.valueOf(sum);
        String apoyo=String.valueOf(ver.charAt(0));
        float paraVer=Float.valueOf(apoyo);
        paraVer=paraVer+1;
        float mult=paraVer*10;
        String numeroVerficador=String.valueOf(codigo.charAt(codigo.length()-1));
        float digitoVerificador=Float.valueOf(numeroVerficador);
       // System.out.println("numero verificado "+digitoVerificador);
        float verificadorOperaciones=0;
        if(mult==100){
            verificadorOperaciones=0;
            if(verificadorOperaciones==digitoVerificador){
                ok=true;
            }
        }else{
            float restarNumero=mult-sum;
            //System.out.println("resta "+restarNumero);
            if(digitoVerificador==restarNumero){
                ok=true;
            }
        }
       //System.out.println(paraVer+"  apoyo");
        return ok;
    }

    public boolean verificador(String codigo){
        boolean ok=false;
        System.out.println(codigo);
        float pares=0;
        float impares=0;
        float mulx3=0;
        String codigo2=codigo;
        for(int i=0;i<codigo2.length()-1;i=i+2){
            String caracter=String.valueOf(codigo.charAt(i));
            float num=Float.valueOf(caracter);
            impares=impares+num;
            //System.out.println(num);
        }
        for(int i=1;i<codigo2.length()-1;i=i+2){
           //System.out.println(codigo.charAt(i));
           String caracter=String.valueOf(codigo.charAt(i));
            float num=Float.valueOf(caracter);
            pares=pares+num;
        }
       // System.out.println(impares+" + "+pares);
       
        float sum=(impares*3)+pares;
        //System.out.println(sum);
        String ver=String.valueOf(sum);
        String apoyo=String.valueOf(ver.charAt(0));
        float paraVer=Float.valueOf(apoyo);
        paraVer=paraVer+1;
        float mult=paraVer*10;
        String numeroVerficador=String.valueOf(codigo.charAt(codigo.length()-1));
        float digitoVerificador=Float.valueOf(numeroVerficador);
       // System.out.println("numero verificado "+digitoVerificador);
        float verificadorOperaciones=0;
        if(mult==100){
            verificadorOperaciones=0;
            if(verificadorOperaciones==digitoVerificador){
                ok=true;
            }
        }else{
            float restarNumero=mult-sum;
            //System.out.println("resta "+restarNumero);
            if(digitoVerificador==restarNumero){
                ok=true;
            }
        }
       //System.out.println(paraVer+"  apoyo");
        return ok;
    }
    
}
