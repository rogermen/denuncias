package Vista;
import Modelo.Denuncia;
import java.util.*;

public class Cola{
    LinkedList<Denuncia> cola;
    public Cola(){
        cola=new LinkedList<>();
    }
    //
    public synchronized void encolar(Denuncia c){
        cola.add(c);
    }
    //
    public synchronized Denuncia decolar(){
        return cola.removeFirst();
    }
    //
    public synchronized Denuncia primero(){
        return cola.getFirst();
    }
    //
    public boolean vacia(){
        return cola.isEmpty();
    }
    //
    public int tamano(){
        return cola.size();
    }
    //
    public synchronized LinkedList<Denuncia> list(){
        return cola;
    }
    //
    public synchronized int posicion(Denuncia c){
        return cola.indexOf(c);
    }
    //
    public synchronized  Denuncia get(int pos){
        return cola.get(pos);
    }
    //
    private synchronized void dormir(){
        try{Thread.sleep(10);}catch(Exception e){};
    }
    //
    public synchronized Denuncia getUltimo(){
        return this.get(tamano()-1);
    }
        
}
