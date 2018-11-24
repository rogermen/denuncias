
package Modelo;
import java.util.ArrayList;
public class ProcesoPenal {
    public ProcesoPenal(){}
    public ArrayList<Denuncia> proceso(int[] cantidad){
          ArrayList<Denuncia> cli = new ArrayList<>();
        int DeNinas=1;
        // DENUNCIAS DE NIÑAS
    	while (DeNinas<=cantidad[0]){
    		String nom="DENUNCIA DE NIÑA_"+DeNinas;
    		Denuncia c=new Denuncia();
                c.setNombre(nom);
                cli.add(c );
                c=null;
                DeNinas++;
    	}
        //DENUNCIAS DE ADOLESCENTES
        int DeAdolescente=1;
        while (DeAdolescente<=cantidad[1]){
    		String nom="DENUNCIA DE ADOLESCENTE_"+DeAdolescente;
    		Denuncia c=new Denuncia();
                c.setNombre(nom);
                cli.add(c );
                c=null;
                DeAdolescente++;
    	}
         //DENUNCIAS DE JOVENES
         int DeJoven=1;
        while (DeJoven<=cantidad[2]){
    		String nom="DENUNCIA DE JOVEN_"+DeJoven;
    		Denuncia c=new Denuncia();
                c.setNombre(nom);
                cli.add(c );
                c=null;
                DeJoven++;
    	}
         //DENUNCIAS DE ADULTAS
         int DeAdulta=1;
        while (DeAdulta<=cantidad[3]){
    		String nom="DENUNCIA DE ADULTA_"+DeAdulta;
    		Denuncia c=new Denuncia();
                c.setNombre(nom);
                cli.add(c );
                c=null;
                DeAdulta++;
    	}
        
        
        for ( int a =0; a<cli.size();a++){
                Denuncia d = cli.get(a);
                MinisterioPublico ministerio = new MinisterioPublico();
                Juzgado jus = new Juzgado();
                ministerio.elegirDenuncia(d);
                if(!d.isJuicioRechazado()){
                jus.tiempoJuicio(d);
                }
                d = null;
         }
        return cli;  
    }
    public ArrayList<Integer> eficienciaProceso(ArrayList<Denuncia> d){
         ArrayList<Integer> res = new ArrayList<>();         
         res.add(tiempoPromedioProceso(d));
         res.add(oportunidadAdmisionProcesal(d));
         res.add(numeroSentencias(d));        
         return res;                 
     }  
     private int numeroSentencias(ArrayList<Denuncia> d){
         int res = 0;    
         for(int i= 0 ; i < d.size();i++){
             if(!d.get(i).isJuicioRechazado()){
             res ++;
             }
         }
         return (int)res;
     }     
     private int tiempoPromedioProceso(ArrayList<Denuncia> d){
         int res = 0;
         int res1 = 0;
         int aux = d.size(); 
         if(aux > 0){
             
         for(int i= 0 ; i < d.size();i++){
             if(!d.get(i).isJuicioRechazado()){
             res =res+d.get(i).totalTiempoProceso();
             } else{
                 aux--;
             }             
         }
         res1 = (int)res/aux ;
         }
         return res1;
     }
     private int oportunidadAdmisionProcesal(ArrayList<Denuncia> d){
         int res = 0;
         int aux = d.size();     
         for(int i= 0 ; i < d.size();i++){
             if(!d.get(i).isJuicioRechazado()){
             res =res+(int)d.get(i).getTiempoInvestigacion();
             }else{
                 aux--;
             }              
         }
         return (int)res/aux;
     }
    
}
