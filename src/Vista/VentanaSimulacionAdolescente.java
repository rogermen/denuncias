package Vista;

import Modelo.Monitor;
import Modelo.MinisterioPublico;
import Modelo.Juzgado;
import Modelo.Denuncia;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Cursor;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.Date;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

public class VentanaSimulacionAdolescente extends JFrame implements ActionListener{
    JSlider slider;
    JLabel label;

    public Panel123 getPanel() {
        return panel;
    }
    
    private Panel123 panel;
    private JMenuBar menus;
    private JMenu Editar;
    private JMenu Ayuda;

    private JMenuItem Nuevo; 
    private JMenuItem Salir;
    private JMenuItem Reportes;
    private JMenuItem Tablas;
    
    private JMenuItem Somos;
    
    private int gastos;
    private int investigaciones;
    private int llamadas ;
    private int siniestros;
    private static int slindervalue;
    private boolean listo=false;
    private Thread hilo;
    private boolean run=false;
    private int contador;
    private JPanel panel1 = new JPanel(); 
    private JPanel p_infoAtencion = new JPanel();
    private JPanel p_controles = new JPanel();
    private JPanel p_reportes = new JPanel();
    private JPanel p_simulacion = new JPanel();
    private JPanel p_denuncia = new JPanel();
    
    //public static JTextField t_nina = new JTextField ();    
    public static JTextField t_adolescente = new JTextField ();            
   // public static JTextField t_joven = new JTextField ();               
   // public static JTextField t_adulta = new JTextField ();
    
    
    private static JLabel l_adolescente=new JLabel();
    private static JLabel l_nina=new JLabel();
    private static JLabel l_joven=new JLabel();
    private static JLabel l_adulta=new JLabel();
    
    private JPanel p_infoGeneral = new JPanel();
    private JPanel p_cronometro = new JPanel();
   //  private JTextField p_nino = new JTextField ();
    
    private DefaultTableModel modelo;

    public static JLabel label_sistema = new JLabel("total.Denun : 0");
    public static JLabel label_atendidas = new JLabel("casos Correctos : 0");
    
    private static JLabel tiempo=new JLabel(); 
    private JButton simular = new JButton("Iniciar Simular");
    private JButton pausa = new JButton("Detener Simulacion");
  private JButton reportes = new JButton("Estadisticos");
    private JButton tablas = new JButton("Reporte");
    private JButton salir = new JButton("Atras");
   
    
    
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
      
    private Date date = new Date();
      
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////
      
    private double datosParam[]={45,2,0.1,1,3};
    public static Monitor monitor = new Monitor();
    private Thread thread;
    
   
    public VentanaSimulacionAdolescente(int gastos,int investigaciones,int llamadas,int siniestros) {
        // public VentanaSimulacionAdolescente();{
	this.gastos=gastos;
	this.investigaciones=investigaciones;
	this.llamadas = llamadas;
	this.siniestros = siniestros;
        // Fondo fondo= new Fondo();
        //this.add(fondo,BorderLayout.CENTER);
        //  this.add(fondo,BorderLayout.CENTER);
        this.pack();
        this.setExtendedState(MAXIMIZED_BOTH);
        establecerPropiedades();
        establecerComponentes();
        anadirEventos();
        //anadirInterfazAnimacion();
    }


   // VentanaSimulacionAdolescente(int investigaciones) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
  
    public void establecerPropiedades(){

      setTitle(" SIMULACION DE PROCESO JUDICIAL");
      setLayout(null);
      setBounds(0, 0, 1300, 850);
     
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setVisible(true);
      
      crearMenu();
      
    }      
    public class MyChangeAction implements ChangeListener{
        public void stateChanged(ChangeEvent arg0) {
    		// TODO Auto-generated method stub
    		int value = slider.getValue()*2;
    		slindervalue=102-value;
    	      String str = Integer.toString(value);
    	      label.setText(str);
    	      monitor.velocidad(slindervalue);
    		  panel.actualizarvelocidad();
    	};}
      
    public void crearMenu(){
    	menus = new JMenuBar();
    	setJMenuBar(menus);
        Editar =new JMenu("Editar");
        Ayuda =new JMenu("Ayuda");
        Nuevo = new JMenuItem("Nuevo");

        Salir = new JMenuItem("Salir");
        Reportes =new JMenu("Reportes");
	Tablas=new JMenuItem("Tablas de la simulacion");
 
        Somos=new JMenuItem("Quienes Somos");

        Editar.add(Reportes);
        Editar.add(Tablas);
        //Ayuda.add(Somos);
        Editar.add(Nuevo);       
        menus.add(Editar);
        menus.add(Ayuda);
      	Nuevo.addActionListener(this);

	Salir.addActionListener(this);
	Reportes.addActionListener(this);
	Tablas.addActionListener(this);
	Somos.addActionListener(this);
    }
    
    public void establecerComponentes(){
        
      panel1.setLayout(null);
      
      p_infoAtencion.setLayout(null);
      p_controles.setLayout(null);
      p_reportes.setLayout(null);
      p_simulacion.setLayout(null);
      p_infoGeneral.setLayout(null);
      p_cronometro.setLayout(null);
      p_denuncia.setLayout(null);
      ////////////////////////////////////////////////////////////////////////////////
      slider = new JSlider(2,50,25);
      
      slider.setValue(25);
      slider.addChangeListener(new MyChangeAction());
      slider.setLayout(null);
      label = new JLabel("");
      JLabel labelvel = new JLabel("Velocidad");
      labelvel.setBounds(390,550,70,30);
      label.setLayout(null);
      panel1.setBounds(2, 2, 1300, 750); 
      //todo
      add(panel1);
      
     
    //}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
      
    
      JPanel pane = new JPanel();
      pane.add(slider);
      pane.add(label);
      pane.setVisible(true);
      pane.setBounds(300, 580, 210, 50);
      //add(pane);
      panel1.add(labelvel);
      panel1.add(pane);

       p_infoAtencion.setBounds(200, 540, 150, 180);
      p_infoGeneral.setBounds(550, 540, 150, 120);
      p_cronometro.setBounds(750, 540, 150, 65);
      p_controles.setBounds(900, 540, 150, 165);  //CONTROLES
      p_reportes.setBounds(1100, 540, 150, 120);
      p_simulacion.setBounds(0, 0, 1300, 540); //SIMULACION   1280,750);
      p_denuncia.setBounds (0, 540, 200, 165); //denuncia
        
      //p_infoAtencion.setBorder(new TitledBorder ("Informacion de Atencion"));
      p_controles.setBorder(new TitledBorder ("Controles"));
      p_simulacion.setBorder(new TitledBorder (""));   ///simulacion
      p_infoGeneral.setBorder(new TitledBorder("Informacion General"));
      p_cronometro.setBorder(new TitledBorder("Cronometro"));
      p_reportes.setBorder(new TitledBorder("Reportes"));
      p_denuncia.setBorder(new TitledBorder("denuncia"));
      
      panel1.add(p_infoAtencion);
      panel1.add(p_controles);
      panel1.add(p_reportes);
      panel1.add(p_simulacion);
      panel1.add(p_infoGeneral);
      panel1.add(p_cronometro);
      panel1.add(p_denuncia);
      
     l_nina.setText("NIÑO:");
       l_nina.setBounds(5, 20, 350, 40);
       p_denuncia.add(l_nina);
       
      l_adolescente.setText("ADOLECENTE:");
       l_adolescente.setBounds(5, 50, 350, 40);
       p_denuncia.add(l_adolescente);
       
       l_joven.setText("JOVEN:");
       l_joven.setBounds(5, 80, 350, 40);
       p_denuncia.add(l_joven);
       
     l_adulta.setText("ADULTA:");
       l_adulta.setBounds(5, 110, 350, 40);
       p_denuncia.add(l_adulta);
       
      /* 
       t_nina.setBounds(100,20,60,30);
       p_denuncia.add(t_nina);
       */
       t_adolescente.setBounds(100,50,60,30);
       p_denuncia.add(t_adolescente);
       /*
       t_joven.setBounds(100,80,60,30);
       p_denuncia.add(t_joven);
       
       t_adulta.setBounds(100,110,60,30);
       p_denuncia.add(t_adulta);
       */
            
      
      label_sistema.setBounds(10, 20, 230, 20);
      p_infoGeneral.add(label_sistema); 
      label_atendidas.setBounds(10, 40, 230, 20);
      p_infoGeneral.add(label_atendidas);
                
      tiempo.setText(" Tiempo Simulacion: ");
      tiempo.setBounds(5, 25, 230, 20);
      p_cronometro.add(tiempo);
    
      
      ///////////////BOTONES
      simular.setBounds(10, 25, 130, 35);
      simular.setCursor(cursor);
      p_controles.add(simular);
      
      pausa.setBounds(10, 70, 130, 35);
      pausa.setCursor(cursor);
      pausa.setEnabled(false);
      p_controles.add(pausa);
      
      salir.setBounds(10, 115, 130, 35);
      salir.setCursor(cursor);
      p_controles.add(salir);
      
   reportes.setBounds(10, 25, 130, 35);
     reportes.setCursor(cursor);
     reportes.setEnabled(false);
      p_reportes.add(reportes);
      
      tablas.setBounds(10, 70, 130, 35);
      tablas.setCursor(cursor);
      tablas.setEnabled(false);
      p_reportes.add(tablas);
      
      
     
      
      crearPanel();
  	  setVisible(true);
    }
      ////////////////////////*****************************///////////////////////////////     
    
	public void crearPanel(){
            panel = new Panel123(monitor,gastos,investigaciones,llamadas,siniestros);
            panel.setLayout(null);
            panel.setBounds(5,-40, 1280,580);  //imagen
            p_simulacion.add(panel);
        }
       
    public static void actualizarInformacion(){

            tiempo.setText(" Tiempo Simulado:" +monitor.tiempo/3600+":"+monitor.tiempo%60);
            label_sistema.setText      ("total.Denun        : "+monitor.personasSistema);
            label_atendidas.setText    ("Casos Correctos    : "+monitor.personasPagadas);
            
    }

    public int getMes(){
    	return panel.getMesSeleccionado();
    }
    
    public void anadirEventos(){
      eventoEstadisticos eveRep = new eventoEstadisticos();
    reportes.addActionListener(eveRep);
      
      eventoTablas eveTab = new eventoTablas();
      tablas.addActionListener(eveTab);
      
      eventoSalir eveSal = new eventoSalir();
      salir.addActionListener(eveSal);
      
      eventoSimular eveSim = new eventoSimular();
      simular.addActionListener(eveSim);
      
      eventoPausa evePau = new eventoPausa();
      pausa.addActionListener(evePau);
    }
    
    class eventoSimular implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	
        	if(e.getSource().equals(simular)&&simular.isEnabled()){
    			monitor.velocidad(100);
      		  	panel.actualizarvelocidad();
    			panel.empezarSimulacion();
    		}
        	
        	
             if(simular.getText() == "Iniciar Simular"){
            	
            	simular.setText("Terminar Simulacion");
            	pausa.setEnabled(true);
            	//run();
            	
       
           }else{
                //inter.stop();
                monitor.reiniciar();
                panel.suspenderClientes();
                tiempo.setText(" Tiempo Simulado:" +monitor.tiempo/3600+":"+monitor.tiempo%60);
                simular.setText("Iniciar Simular");
                pausa.setText("Detener Simulacion");
                pausa.setEnabled(false);
            }   
        }
    }
    
    public Denuncia procesoViolenciaContraMujer(Denuncia d ){
        MinisterioPublico ministerio = new MinisterioPublico();
        Juzgado jus = new Juzgado();
        ministerio.elegirDenuncia(d);
        jus.tiempoJuicio(d);
        return d;    
    }
    
    
    
    
    class eventoPausa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(pausa.getText() == "Detener Simulacion"){
            //           inter.suspend();
            pausa.setText("Continuar Simulacion");
            //  hilo.suspend();
            reportes.setEnabled(true);           //Estadistico
            tablas.setEnabled(true);
            panel.suspenderClientes();
            }else{
                pausa.setText("Detener Simulacion");
                reportes.setEnabled(false);
                tablas.setEnabled(false);                
                panel.resumeClientes();
                //           inter.resume(); 
                hilo.resume();
            }    
        }
    }
        
    class eventoTablas implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //String aux1 = t_nina.getText();
            String aux2 = t_adolescente.getText();
           // String aux3 = t_joven.getText();
           // String aux4 = t_adulta.getText();
            int nu1 = 0; //Integer.parseInt(aux1);
            int nu2 = Integer.parseInt(aux2);
            int nu3 = 0; // Integer.parseInt(aux3);
            int nu4 =0;  // Integer.parseInt(aux4);
            
            int denuncias =0;
            denuncias = nu1+nu2+nu3+nu4;
            int [] denuncias1 ={nu1,nu2,nu3,nu4};
            Tablas t = new Tablas(monitor,getMes(),denuncias1); 
             DefaultTableModel modelo1 ;
 
        }
        
    }
    
    class eventoEstadisticos implements ActionListener{
        public void actionPerformed(ActionEvent e){
        VentanaReporte rep= new VentanaReporte(monitor);
           rep.setVisible(true);
        }
    }
    
    class eventoSalir implements ActionListener{
        public void actionPerformed(ActionEvent e){
            simulacion simu=new simulacion();
        	setVisible(false);
        	 monitor.reiniciar();
                 simu.setVisible(true);//////////
                        
        }
    }
    
	public void actionPerformed(ActionEvent e) {
		String opcion = e.getActionCommand();
		if(e.getSource().equals(Salir)){
			int o=JOptionPane.showConfirmDialog(this, "Esta seguro que desea salir?");
			if(o==JOptionPane.OK_OPTION){
				System.exit(0);
			}
		}else if (opcion.equals("Acerca de este")) {
			JOptionPane.showMessageDialog(this,"Para mas informacin contactarse con: \n"+"El grupo -_- " +
						" \n","", JOptionPane.INFORMATION_MESSAGE);
	     }else if (opcion.equals("Nuevo")) {
	        new VentanaSimulacionAdolescente(gastos,investigaciones,llamadas,siniestros);
	        
	     }
			JFileChooser fc=new JFileChooser();
			int action=fc.showOpenDialog(this);
			if(action==JFileChooser.APPROVE_OPTION){
				repaint();
			}
	
			}

	     
	}
   
