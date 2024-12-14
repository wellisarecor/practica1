/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

/**
 *
 * @author Rene Jose
 */
//import Modelos.*;
import java.sql.SQLException;
import java.util.Scanner;
public class test {
    
    public static void main(String[] args) throws SQLException {
        int Rf=0;
        int i=0;
        int R1=0;
        System.out.println("desplaza muñeco: "+ R1);
        int R2=1;
        System.out.println("desplaza muñeco: "+ R2);
        
        while(i < 6){
            Rf=R1 +R2;
           System.out.println("desplaza muñeco: "+ Rf); 
           R1=R2; 
           R2=Rf;
            
           i++; 
        }
            
        };
    
        
        
        
        
        
        
        
//        int i=0;
////      System.out.println(Ayudas.generarCodigo("PROD000000", Ayudas.PREFIJO_PRODUCTO));
//        String codigo="PROD000000";
//        String aux="";
//        while(i<10){
//        codigo=Ayudas.generarCodigo(codigo, Ayudas.PREFIJO_PRODUCTO);
//        aux=codigo;
//        System.out.println(aux);
//        i++;
//        }
        
        
        
//       DaoProducto_Ini por=new DaoProducto_Ini();
//       por.establecer();
//    double numero=19;
//    double suma= 13 /numero;
//    System.out.print(redondearDecimales(suma, 2));
//        System.out.println("----------------");
//    System.out.print(Ayudas.redondearDecimales(suma, 2));
//    
//    }
//    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
//        double parteEntera, resultado;
//        resultado = valorInicial;
//        parteEntera = Math.floor(resultado);
//        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
//        resultado=Math.round(resultado);
//        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
//        return resultado;
//    }
    
    
}
