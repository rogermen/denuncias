package Vista;

import Modelo.Monitor;
import Modelo.Denuncia;
import Control.VariableAleatoria;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
public class Panel123 extends JPanel {
    private JComboBox cb_meses;
    private JComboBox dias;
    private JComboBox cb_d_denuncias;
    private JComboBox cb_d_fiscales;
    private JComboBox cb_d_decicionFiscal;
    private JComboBox cb_d_jueces;
    private JComboBox cb_d_alternativas;
    ///
    private JLabel fondo;
    private ArrayList<JLabel> recepcionistas;
    private ArrayList<JLabel> fiscales;
    private ArrayList<JLabel> jueces;
    private int gastos;
    private int investigaciones;
    private int llamadas;
    private int siniestros;
    private int numhil=20;
    private int denunciasLimite;
    double porciontiempo=0;
    Timer timer = new Timer();
    Monitor mono;
    private VariableAleatoria va;
    JSlider jSlider1;

    private int tiempoEntreLlegadas;
    private int cantidadC;
    public ArrayList<Denuncia> clientes=new ArrayList<>();   
    private final ArrayList<JLabel> lisLabel =new ArrayList<>();
    ThreadGroup grupoHilo;
      
    public Panel123(Monitor mon,int gastos,int investigaciones,int llamadas,int siniestros ){    	
    	setLayout(null);
    	this.gastos = gastos;
    	this.investigaciones = investigaciones;
    	this.llamadas = llamadas;
    	this.siniestros = siniestros;
    	this.mono = mon;
        denunciasLimite = 10;
		va = new VariableAleatoria();
	    tiempoEntreLlegadas=10;
	    cantidadC=0;
		
		recepcionistas=new ArrayList<JLabel>();
		fiscales=new ArrayList<JLabel>();
		jueces = new ArrayList<JLabel>();		
	    /////////////////////////////////////////////////////labelss
	    for (int i = 0; i < 60; i++) {
	    	
	    	JLabel lab=new JLabel();
	    	//lab.setIcon(new ImageIcon("Imagenes/CaminaD.gif"));
                lab.setIcon(new ImageIcon(getClass().getResource("/images/CaminaD.gif")));
                //lab.setIcon(imagen);
		    lab.setBounds(-50, 315, lab.getIcon().getIconWidth(),lab.getIcon().getIconHeight());
		    this.add(lab);
		    lisLabel.add(lab );
		}
        
		crearBotones();
		llamadas();
		siniestros();
		gastos();
		fijos();
		crearFondo();
		
		setVisible(true);
    }//Fin Constructor;
    
    public void crearFondo(){
		//fondo.setIcon(new ImageIcon(escala));
                 Dimension tamanio= getSize();
     ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/images/FONDO2.jpg"));

    	fondo=new JLabel();
    	fondo.setLayout(null);
    	fondo.setIcon(imagenFondo);
    	fondo.setBounds(2,2,1280,600);     //aqui de la imagen
    	fondo.setVisible(true);
        add(fondo);
        
    }
	
    public void crearBotones(){
    	
    	jSlider1 =new JSlider(SwingConstants.HORIZONTAL,0,200,10);
		cb_meses = new JComboBox();
		cb_meses.addItem("Enero");
		cb_meses.addItem("Febrero");
		cb_meses.addItem("Marzo");
		cb_meses.addItem("Abril");
		cb_meses.addItem("Mayo");
		cb_meses.addItem("Junio");
		cb_meses.addItem("Julio");
		cb_meses.addItem("Agosto");
		cb_meses.addItem("Septiembre");
		cb_meses.addItem("Octubre");
		cb_meses.addItem("Noviembre");
		cb_meses.addItem("Diciembre");
		cb_meses.setBounds(20, 20, 80, 20);
		add(cb_meses);
		
		dias = new JComboBox();
		dias.addItem("Lunes");
		dias.addItem("Martes");
		dias.addItem("Miercoles");
		dias.addItem("Jueves");
		dias.addItem("Viernes");
		dias.setBounds(110, 20, 80, 20);
		add(dias);
		
		cb_d_denuncias = new JComboBox();
		cb_d_denuncias.addItem("Exponencial");
		cb_d_denuncias.addItem("Uniforme");
		cb_d_denuncias.addItem("Normal");
		cb_d_denuncias.addItem("Trans. Inversa");
		cb_d_denuncias.setBounds(200, 60, 80, 20);
		//add(cb_d_denuncias);

		cb_d_fiscales = new JComboBox();
		cb_d_fiscales.addItem("Trans. Inversa");
		cb_d_fiscales.addItem("Normal");
		cb_d_fiscales.addItem("Exponencial");
		cb_d_fiscales.addItem("Uniforme");
		cb_d_fiscales.setBounds(470, 28, 80, 20);
		//add(cb_d_fiscales);

		cb_d_alternativas = new JComboBox();
		cb_d_alternativas.addItem("Trans. Inversa");
		cb_d_alternativas.addItem("Normal");
		cb_d_alternativas.addItem("Exponencial");
		cb_d_alternativas.addItem("Uniforme");
		cb_d_alternativas.setBounds(780, 45, 80, 20);
		//add(cb_d_negociacion);

		cb_d_jueces = new JComboBox();
		cb_d_jueces.addItem("Normal");
		cb_d_jueces.addItem("Exponencial");
		cb_d_jueces.addItem("Uniforme");
		cb_d_jueces.addItem("Trans. Inversa");
		cb_d_jueces.setBounds(30, 540, 80, 20);
		//add(cb_d_investigacion);
		
		cb_d_decicionFiscal = new JComboBox();
		cb_d_decicionFiscal.addItem("Uniforme");
		cb_d_decicionFiscal.addItem("Normal");
		cb_d_decicionFiscal.addItem("Exponencial");
		cb_d_decicionFiscal.addItem("Uniforme");
		cb_d_decicionFiscal.addItem("Trans. Inversa");
		cb_d_decicionFiscal.setBounds(247, 630, 80, 20);
		//add(cb_d_estimacion);
		
    
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void llamadas(){
    	int x=120;
    	int y=50;
    	for(int i=0;i<llamadas;i++){	
    		if(i==1){
    			y=200;
    			x=45;
    		}else if(i==2){
                y=350;}
                else y=500;
    	}	
	}
    
    public void siniestros(){
    	int x=450;
	    int y=300;
	    for(int i=0;i<siniestros;i++){	

	         x=x+50+10;  
	    	 if(i%5==0 && i!=0){
	    		 y=y+130;
	    		 x=325;
	    	 }
	    }	
	}
    
    public void gastos(){
    	int x=768;
	      int y=65;
	    for(int i=1;i<=gastos;i++){	

                 if(i==1){
    			y=320;
    			//x=45;
    		}else if(i==2){
                y=475;}
                else y=525;
	    }	
    }
    
    public void fijos(){
	
    }

    
    public void setIndiceCBD(int n){
    	cb_meses.setSelectedIndex(n);
    	
    }
    
    public void pararClientes(){
    	
        for(int i=0; i<mono.personasSistema; i++)
        {
            //if(Clientes[i].isAlive())
              //  Clientes[i].stop();
        }
    }
    //
    public void suspenderClientes(){
    	for(int i=0; i<clientes.size(); i++){
            if(clientes.get(i).isAlive()){
                clientes.get(i).suspend();
                clientes.get(i).parar();
            }
    	}
    	timer.cancel();
    }
    public void actualizarvelocidad(){
    	for(int i=0; i<clientes.size(); i++){//c es de tipo arrayList de clientes
        	if(clientes.get(i).isAlive()){//isAlive metodo que pregunta si el hilo esta vivo
                    clientes.get(i).actualizarvelo();
        	}
    	}
    }
    public void resumeClientes(){
    	for(int i=0; i<clientes.size(); i++){
        	if(clientes.get(i).isAlive()){
                    clientes.get(i).resume();
                    clientes.get(i).continuar();
        	}
    	}
    	timerTask.run();
    }
    
    //VentanaSimulacion simu= new VentanaSimulacion();
    public int getMesSeleccionado(){
    	return cb_meses.getSelectedIndex();
    }
    
    public void empezarSimulacion(){
    	int messelecionado = cb_meses.getSelectedIndex();
    	
    	Monitor.atencionLlamadas(cb_d_denuncias.getSelectedIndex());//exponencial,uniforme...
    	Monitor.atencionSiniestros(cb_d_fiscales.getSelectedIndex());
    	Monitor.atencionInvestigacion(cb_d_jueces.getSelectedIndex());
    	Monitor.atencionEstimacion(cb_d_decicionFiscal.getSelectedIndex());
    	Monitor.atencionNegociacion(cb_d_alternativas.getSelectedIndex());
    	

    	cb_d_denuncias.setEnabled(false);
    	cb_d_fiscales.setEnabled(false);
    	cb_d_jueces.setEnabled(false);
    	cb_d_alternativas.setEnabled(false);
    	cb_d_decicionFiscal.setEnabled(false);
    	
    	cb_meses.setEnabled(false);
    	dias.setEnabled(false);
    	
    	grupoHilo=new ThreadGroup("hilopadre");

    	int N_Clientes=0;
    	while (N_Clientes<denunciasLimite){
    		String nom="clien"+N_Clientes;
    		Denuncia cli=new Denuncia(grupoHilo,nom, mono,lisLabel.get(N_Clientes),llamadas,siniestros, investigaciones,gastos);
                clientes.add(cli );
                N_Clientes++;
    	}

    	
    	switch(messelecionado)
    	{
    	case 0:		
    		cantidadC = va.uniforme(4, 7);
    		tiempoEntreLlegadas= va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
    	case 1:	
    		cantidadC = va.uniforme(10, 12);
    		tiempoEntreLlegadas = va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
    	case 2:	
    		cantidadC = va.uniforme(10, 12);
    		tiempoEntreLlegadas = va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
    	case 3:		
    		cantidadC = va.uniforme(10, 12);
    		tiempoEntreLlegadas = va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
    	case 4:		
    		cantidadC = va.uniforme(10, 12);
    		tiempoEntreLlegadas = va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
    	case 5:		
    		cantidadC = va.uniforme(10, 12);
    		tiempoEntreLlegadas = va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
    		
    	case 6:		
    		cantidadC = va.uniforme(10, 12);
    		tiempoEntreLlegadas = va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
    		
    	case 7:			
    		cantidadC = va.uniforme(10, 12);
    		tiempoEntreLlegadas = va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
    	case 8:		
    		cantidadC = va.uniforme(10, 12);
    		tiempoEntreLlegadas = va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
    	case 9:		
    		cantidadC = va.uniforme(10, 12);
    		tiempoEntreLlegadas = va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
    	case 10:	
    		cantidadC = va.uniforme(10, 12);
    		tiempoEntreLlegadas = va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
    	case 11:	
    		cantidadC = va.uniforme(10, 12);
    		tiempoEntreLlegadas = va.uniforme(1000, 1030);
	    	timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
	    	break;
	    	
        		
    	}
    	
    		
    }
    private TimerTask timerTask = new TimerTask(){
		int u=0;
        public void run() {
       	 	//codigo a correr
        	if(cantidadC>u){
        	//System.out.println(""+u);
           	clientes.get(u).start();
           	//System.out.println("hilossss");
           	int r= grupoHilo.activeCount();//devuelve nº de hilos activos
           	//System.out.println("hilossss"+r);
           	u=u%149+1;
           	mono.setHora((int)(tiempoEntreLlegadas*porciontiempo));
           	porciontiempo=porciontiempo+1;
           	}else{
           		cancel();	
           	}
        }
    };
    public double  getTiempo() {
    	return tiempoEntreLlegadas*porciontiempo;	
    }
    public ArrayList<Denuncia> getClientes() {
        return clientes;
    }
	
}