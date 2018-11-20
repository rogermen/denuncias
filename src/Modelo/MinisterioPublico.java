
package Modelo;
import Control.VariableAleatoria;
public class MinisterioPublico {
    public MinisterioPublico() {}
    public void elegirDenuncia(Denuncia d){
        VariableAleatoria a = new VariableAleatoria();
        int res = a.metodoMontecarlo();
        switch(res){
    	case 0:          // denuncia rechazada por falta de evidencia
                        d.setTiempoRecoleccionPruebas(6);
                        d.setTiempoImputacion(0);
                        d.setTiempoJuicio(0);
                        d.setJuicioRechazado(true);
                        d.setTiempoInvestigacion(0);                   
	    	break;
    	case 1:	 // denuncia en sobreseimiento
                    TiempoInvestigacion(d);
                    tiempoImputacion(d);
	    	break;
    	case 2:      // denuncia llevado a juicio
                    TiempoInvestigacion(d);
                    tiempoImputacion(d);
	    	break;       		
    	}    
    }
    private void TiempoInvestigacion(Denuncia d){
        VariableAleatoria a = new VariableAleatoria();
        int res = a.metodoMontecarlo();
        switch(res){
    	case 0:	  d.setTiempoRecoleccionPruebas(5);
    		  d.setTiempoInvestigacion(4); 
	    	break;
    	case 1:	  d.setTiempoRecoleccionPruebas(8);
                  d.setTiempoInvestigacion(9);                    
	    	break;
    	case 2:   d.setTiempoRecoleccionPruebas(9);
                  d.setTiempoInvestigacion(10);            
	    	break;           
        }
    }   
    private void tiempoImputacion(Denuncia d){
        VariableAleatoria a = new VariableAleatoria();
        int res = a.metodoMontecarlo();
        switch(res){
    	case 0:	 d.setTiempoImputacion(4);
                 break;
    	case 1:	 d.setTiempoImputacion(9);                   
	    	 break;
    	case 2:	d.setTiempoImputacion(12);            
	    	break;     
        }
    }
    
}
