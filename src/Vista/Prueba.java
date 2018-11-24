/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.ProcesoPenal;
import java.util.ArrayList;

/**
 *
 * @author roger
 */
public class Prueba {
  
    
    public static void main(String args[]) {
        ProcesoPenal p = new ProcesoPenal();
        int [] denuncias1 ={4,2,4,3};
        p.proceso(denuncias1);
    }
    
    
    
    
    /*
    public static void main(String args[]) {
        try{
            
            
          ArrayList<Denuncia> cli = new ArrayList<>();
        int N_Clientes=0;
    	while (N_Clientes<100){
    		String nom="DEMANDA_"+N_Clientes;
    		Denuncia c=new Denuncia();
                c.setNombre(nom);
                cli.add(c );
                c=null;
                N_Clientes++;
    	}
        
        for ( int a =0; a<=cli.size();a++){
            Denuncia d = cli.get(a);
            
            MinisterioPublico ministerio = new MinisterioPublico();
            Juzgado jus = new Juzgado();
            ministerio.elegirDenuncia(d);
            if(!d.isJuicioRechazado()){
            jus.tiempoJuicio(d);
            }
            System.out.println(d.getNombre());
            System.out.println("tiempo de recoleccion de Pruebas es:                "+(int)d.getTiempoRecoleccionPruebas()+ "  Meses\n");
            System.out.println("tiempo de tiempo de imputacion  es:                 "+(int)d.getTiempoImputacion() + "  Meses\n");
            System.out.println("tiempo de tiempo de investigacion Preliminar  es:   "+(int)d.getTiempoInvestigacion()+ "  Meses\n");
            System.out.println("tiempo de tiempo de juicio es:                      "+(int)d.getTiempoJuicio()+ "  Meses\n");
            System.out.println("TOTAL TIEMPO PROCESO ES:                            "+d.totalTiempoProceso()+ "  Meses\n");
            System.out.println("Fin Demanda :                                       "+d.getSentenciaJuicio()+"\n");
            System.out.println("-----------\n");
            d = null;
        }
        }catch(ArrayIndexOutOfBoundsException excepcion)
		         {
			         System.out.println(" Error de índice en un array");
		         }
            
        }*/
    }
    
    
    

