
package Modelo;
import Control.VariableAleatoria;
public class Juzgado {
    static int numeroJuzgado = 4;
    public Juzgado() {}    
    public void tiempoJuicio(Denuncia d){
        VariableAleatoria a = new VariableAleatoria();
        int res = a.metodoMontecarlo();
        switch(res){
    	case 0:     d.setTiempoJuicio(8);
        
                    sentenciaJuicio(d); 
                    break;
    	case 1:     d.setTiempoJuicio(13);
                    sentenciaJuicio(d);
                    break;
    	case 2:     d.setTiempoJuicio(15);
                    sentenciaJuicio(d);
                    break;  
        }
    }
    private void sentenciaJuicio(Denuncia d){
         VariableAleatoria a = new VariableAleatoria();
        int res = a.metodoMontecarloOtro();
        switch(res){
    	case 0:     d.setSentenciaJuicio("SENTENCIA ABSOLUTORIA");
                    break;
    	case 1:     d.setSentenciaJuicio("SENTENCIA CONDENATORIA ");   
                    break;
    	case 2:     d.setSentenciaJuicio("PROCESO  ABREVIADO");   
                    break;  
        case 3:     d.setSentenciaJuicio("CONCILIACION");   
                    break; 
        case 4:     d.setSentenciaJuicio("SOBRESEIMIENTO");   
                    break;
        case 5 :     d.setSentenciaJuicio("ABANDONO");   
                    break;
        }  
    } 
}
