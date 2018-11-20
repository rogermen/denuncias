
package Modelo;
import java.util.ArrayList;
public class ProcesoPenal {
    public ProcesoPenal(){}
    public ArrayList<Denuncia> proceso(int cantidad){
          ArrayList<Denuncia> cli = new ArrayList<>();
        int N_Clientes=1;
    	while (N_Clientes<=cantidad){
    		String nom="DENUNCIA CONTRA LA MUJER_"+N_Clientes;
    		Denuncia c=new Denuncia();
                c.setNombre(nom);
                cli.add(c );
                c=null;
                N_Clientes++;
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
         int aux = d.size();    
         for(int i= 0 ; i < d.size();i++){
             if(!d.get(i).isJuicioRechazado()){
             res =res+d.get(i).totalTiempoProceso();
             } else{
                 aux--;
             }             
         }
         return (int)res/aux;
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
