package Vista;

 
import Modelo.Monitor;
import Modelo.ProcesoPenal;
import Modelo.Denuncia;
import Modelo.pdf;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.util.ArrayList;

public class Tablas extends JFrame{
    ArrayList<Denuncia> cliente1 = new ArrayList<>();	
	private Cursor cursor;
	private JPanel panel;
        private JPanel panel1;
        private JPanel panel2;
	private JScrollPane scroll;
        private JScrollPane scroll1;
                
	private JLabel tex1;
	private JLabel tex2;
	private JLabel tex3;
	private JTable tabla;
        private JTable tabla1;
	private DefaultTableModel modelo;
        private DefaultTableModel modelo1;
	private JButton boton;
        private JButton bnina;
        private JButton badolescente;
        private JButton bjoven;
        private JButton badulta;
        private JButton btodos;
        
	private Monitor monitor;
	
	int diasMes=26;
	int atendidos=(monitor.personasSistema);
	
	int Qfiscal=(monitor.Qfiscal);
	int Dfiscal=(monitor.Dfiscal);
	int Dpolicia=(monitor.Dpolicial);
	int flagrante=(monitor.flagrante);
	int rechaso=(monitor.rechaso);
        int salida=(monitor.salida);
	int imputacion=(monitor.imputacion);
	
	int total=Qfiscal+Dfiscal+Dpolicia+flagrante;
	int rechazados=total-rechaso-salida;
	int aceptados=total;
	
	int mesSimulacion;
	String mesSelec;
        int [] cantidadDenuncias ;
        String [][] dtabla ; //= new String[WIDTH][WIDTH];
	String [][] dtabla1; // = new String[WIDTH][WIDTH];
    public Tablas(Monitor m, int mes , int[] denuncias) {
    	monitor = m;
	mesSimulacion=mes;
	mesSelec="";
        cantidadDenuncias = denuncias;
	establecerPropiedades();
    	establecerComponentes();
    	anadirTabla();        
    }
    
    public void establecerPropiedades(){    	
    	setTitle("Tablas de Reportes Sobres la Simulacion");
    	setLayout(null);
    	setBounds(10, 10, 1350, 700);
    	setResizable(false);
    	setVisible(true);
    }
    public void establecerComponentes(){    	
    	panel = new JPanel();
    	panel.setBounds(5, 10, 580, 500);
    	panel.setBorder(new TitledBorder("  Reportes Generales de la Simulacion del Mes Seleccionado  "));
    	panel.setLayout(null);
    	add(panel);        
        
        panel1 = new JPanel();
    	panel1.setBounds(620, 10, 700, 500);
    	panel1.setBorder(new TitledBorder("  Reportes Generales por denuncia "));
    	panel1.setLayout(null);
    	add(panel1);
        
        panel2 = new JPanel();
    	panel2.setBounds(200, 510, 800, 150);
    	panel2.setBorder(new TitledBorder("  Reportes por Tipo de Denuncia "));
    	panel2.setLayout(null);
    	add(panel2);
    	
    	cursor = new Cursor(Cursor.HAND_CURSOR);
    	//boton Atras
    	boton = new JButton("Atras"); 
    	boton.setBounds(200, 450, 90, 30);
    	boton.setCursor(cursor);
    	panel.add(boton);    	
    	eventoSalir sal = new eventoSalir();
    	boton.addActionListener(sal);
        
    	//boton nina
        bnina = new JButton("NIÑA"); 
    	bnina.setBounds(20, 30, 90, 30);
    	bnina.setCursor(cursor);
    	panel2.add(bnina);    	
    	eventoNina evnina = new eventoNina();
    	bnina.addActionListener(evnina);
        
        //boton adolescente
        badolescente = new JButton("ADOLESCENTE"); 
    	badolescente.setBounds(130, 30, 150, 30);
    	badolescente.setCursor(cursor);
    	panel2.add(badolescente);    	
    	eventoAdolescente eveadoles = new eventoAdolescente();
    	badolescente.addActionListener(eveadoles);
        
        //boton joven
        bjoven = new JButton("JOVEN"); 
    	bjoven.setBounds(300, 30, 90, 30);
    	bjoven.setCursor(cursor);
    	panel2.add(bjoven);    	
    	eventoJoven evjoven = new eventoJoven();
    	bjoven.addActionListener(evjoven);
        
        //boton adulta
        badulta = new JButton("ADULTA"); 
    	badulta.setBounds(410, 30, 90, 30);
    	badulta.setCursor(cursor);
    	panel2.add(badulta);   	
    	eventoAdulta evadulta = new eventoAdulta();
    	badulta.addActionListener(evadulta);
        
        //boton todos
        btodos = new JButton("TODOS"); 
    	btodos.setBounds(520, 30, 90, 30);
    	btodos.setCursor(cursor);
    	panel2.add(btodos);    	
    	eventoTodos evtodos = new eventoTodos();
    	btodos.addActionListener(evtodos);
 
    }
    public void anadirTabla(){
        ArrayList<Denuncia> cli = new ArrayList<>();
        ArrayList<Integer> efi = new ArrayList<>();
       ProcesoPenal pro = new ProcesoPenal();
       cli=pro.proceso(cantidadDenuncias);
       cliente1 =cli;
    	efi=pro.eficienciaProceso(cli);
         if(mesSimulacion==0){mesSelec="Enero";}
          if(mesSimulacion==1){mesSelec="Febrero";}
         if(mesSimulacion==2){mesSelec="Marzo";}
    	else if(mesSimulacion==3){mesSelec="Abril";}
    	else if(mesSimulacion==4){mesSelec="Mayo";}
    	else if(mesSimulacion==5){mesSelec="Junio";}
    	else if(mesSimulacion==6){mesSelec="Julio";}
    	else if(mesSimulacion==7){mesSelec="Agosto";}
    	else if(mesSimulacion==8){mesSelec="Septiembre";}
    	else if(mesSimulacion==9){mesSelec="Octubre";}
    	else if(mesSimulacion==10){mesSelec="Noviembre";}
    	else if(mesSimulacion==11){mesSelec="Diciembre";}
    	
    	String[]   cabe ={" Descripcion ", " Resultado "};
        String[]   cabe1 ={" Descripcion ", " Resultado "};
        
        String[][] datos = {
            {"Denuncia Ante SLIM  ","  "+Integer.toString(Qfiscal)+"   Denuncias"},
            {"Denuncias Ante el Fiscal ","  "+Integer.toString(Dfiscal)+"   Denuncias"},
            {"Denuncia Ante la Policia ","  "+Integer.toString(Dpolicia)+"   Denuncias"},
            {"Denuncia Ante la Defensoria ","  "+Integer.toString(flagrante)+"   Denuncias"},
            {"Casos que Fueron Rechazados","  "+Integer.toString(rechaso)+"   Denuncias"},
            {"Casos Sobreseimiento"," "+Integer.toString(salida)+"   Denuncias"},
            {" "," "},
            {"Total CASOS DENUNCIADOS","  "+cli.size()+"   Denuncias"},
            {"Niñas","  "+cantidadDenuncias[0]+"   Denuncias"},
            {"Adolecente","  "+cantidadDenuncias[1]+"   Denuncias"},
            {"Joven","  "+cantidadDenuncias[2]+"   Denuncias"},
            {"Adulta","  "+cantidadDenuncias[3]+"   Denuncias"},
            {" "," "},
            {"     EFICIENCIA","     INDICADORES DE  OPURTUNIDAD   "},
            {" TIEMPO PROMEDIO REAL DEL PROCESO"," "+efi.get(0) + "  Meses"},
            {" INDICADOR DE OPORTUNIDAD PROCESAL"," "+efi.get(0) + "  Meses promedio/ 10 Meses LEGAL"},
            {" OPORTUNIDAD DE ADMISION PROCESAL"," "+efi.get(1) + "  Meses"},
            {" "," "},
            {"     EFICIENCIA","     INDICADORES DE  COBERTURA   "},
            {" I. DE PRODUCCION DE SENTENCIAS"," "+efi.get(2) + "  Denuncias / "+cli.size()+"  Denuncias"},
            {" INDICADOR DE CONCILIACIONES"," "+(cli.size()-efi.get(2)) + "  Denuncias"},
            {" PROCESOS POR INSTANCIA JUDICIAL "," "+(efi.get(2)+0) + "  Denuncias"},
            {" "," "},
            {"     EFICIENCIA","     INDICADORES DE  CALIDAD   "},
            {"CONFI. DE INSTANCIAS SUPERIORES"," "+(efi.get(2)-4) + "  Denuncias"},
            {" INDICADOR DE  IMPULSO  PROCESAL"," "+(cli.size()-efi.get(2)-1) + "  Denuncias"},
            {" INDICADOR DE SENTENCIAS ELABORADAS"," "+(efi.get(2)-3) + "  Denuncias"},
        };                                          
        String[][] datos1 = datosGenerados(cli);  
        dtabla=datos;
        dtabla1=datos1;
        modelo = new DefaultTableModel(datos,cabe);
	modelo1 = new DefaultTableModel(datos1,cabe1);
        
	tabla = new JTable(modelo){
            public boolean isCellEditable(int f, int c) {
                boolean res = false;
                return res;
            }
	};
        tabla1 = new JTable(modelo1){
            public boolean isCellEditable(int f, int c) {
		boolean res = false;
		return res;
            }
	};
		
	tabla.getTableHeader().setReorderingAllowed(false);
	tabla1.getTableHeader().setReorderingAllowed(false);
                
	scroll = new JScrollPane(tabla);
	scroll.setBounds(10, 20, 560, 430);
	panel.add(scroll);
                
        scroll1 = new JScrollPane(tabla1);
	scroll1.setBounds(10, 20, 680, 470);
	panel1.add(scroll1);
    }
    
    private String [][] datosGenerados(ArrayList<Denuncia> cli ){
        String [][] res= new String[cli.size()*9][2];
        int col=1;
        for (int i =0 ; i< cli.size();i++){
            int j =0;
            res[col-1][j]= "Nombre Denuncia ";                          res[col-1][j+1]="  "+cli.get(i).getNombre();
            res[col++][j]= "Tiempo de Recoleccion de Pruebas es";       res[col-1][j+1]="  "+(int)cli.get(i).getTiempoRecoleccionPruebas()+"  Meses";
            res[col++][j]= "Tiempo de imputacion  es ";                 res[col-1][j+1]="  "+(int)cli.get(i).getTiempoImputacion()+"  Meses";
            res[col++][j]= "Tiempo de  Investigacion Preliminar  es ";  res[col-1][j+1]="  "+(int)cli.get(i).getTiempoInvestigacion()+"  Meses";
            res[col++][j]= "Tiempo Totales de Juicios es";              res[col-1][j+1]="  "+(int)cli.get(i).getTiempoJuicio() + "  Meses";
            res[col++][j]= "TOTAL TIEMPO PROCESO ES ";                  res[col-1][j+1]="  "+cli.get(i).totalTiempoProceso()+ "  Meses";
            res[col++][j]= "FIN PROCESO";                               res[col-1][j+1]="  "+cli.get(i).getSentenciaJuicio();
            res[col++][j]= " ";                                         res[col-1][j+1]=" ";
            res[col++][j]= " ";                                         res[col-1][j+1]=" ";
        }        
        return res;
    }
    
    class eventoSalir implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		setVisible(false);	
    	}
    }
    
    class eventoNina implements ActionListener{
    	public void actionPerformed(ActionEvent e){
            //evento niña
            ArrayList<Denuncia> den= cliente1;
            ArrayList<Denuncia> den1= new ArrayList<>();
            for(int a=0 ; a< den.size();a++){
                if(den.get(a).getTipoDenuncia()==1){
                    den1.add(den.get(a));
                }
            }
            String [][] da=datosGenerados(den1);
            String auxi="                                 REPORTE  PARCIAL DE  DENUNCIA  DE NIÑAS   \n\n";
            for(int y=0;y<da.length ;y++){
                if(da[y][0] != null){
                    auxi = auxi + da[y][0] +" :   " + da[y][1]  + "\n";  
                }
            }
            pdf pdf1=new pdf();
            //  pdf.crear_PDF(TITULO           , autor                         , asunto, clave, contenido);
            pdf1.crear_PDF("Proyecto Simulacion", "Grupo Taller de Simulacion"  ,"Proceso Penal" , "Mujer",auxi);       
    	}
    }
    
    class eventoAdolescente implements ActionListener{
    	public void actionPerformed(ActionEvent e){
            // evento adolescente                
            ArrayList<Denuncia> den= cliente1;
            ArrayList<Denuncia> den1= new ArrayList<>();
            for(int a=0 ; a< den.size();a++){
                if(den.get(a).getTipoDenuncia()==2){
                    den1.add(den.get(a));
                }
            }
            String [][] da=datosGenerados(den1);
            String auxi="                                 REPORTE  PARCIAL DE  DENUNCIA  DE ADOLESCENTE   \n\n";
            for(int y=0;y<da.length ;y++){
                 if(da[y][0] != null){
                    auxi = auxi + da[y][0] +" :   " + da[y][1]  + "\n";  
                }
            }
            pdf pdf1=new pdf();
            //  pdf.crear_PDF(TITULO           , autor                         , asunto, clave, contenido);
            pdf1.crear_PDF("Proyecto Simulacion", "Grupo Taller de Simulacion"  ,"Proceso Penal" , "Mujer",auxi);      
    	}
    }
    class eventoJoven implements ActionListener{
    	public void actionPerformed(ActionEvent e){	
            //evento joven
            ArrayList<Denuncia> den= cliente1;
            ArrayList<Denuncia> den1= new ArrayList<>();
            for(int a=0 ; a< den.size();a++){
                if(den.get(a).getTipoDenuncia()==3){
                    den1.add(den.get(a));
                }
            }
            String [][] da=datosGenerados(den1);
            String auxi="                                 REPORTE  PARCIAL DE  DENUNCIA  DE JOVEN   \n\n";
            for(int y=0;y<da.length ;y++){
                if(da[y][0] != null){
                    auxi = auxi + da[y][0] +" :   " + da[y][1]  + "\n";  
                }
            }
            pdf pdf1=new pdf();
            //  pdf.crear_PDF(TITULO           , autor                         , asunto, clave, contenido);
            pdf1.crear_PDF("Proyecto Simulacion", "Grupo Taller de Simulacion"  ,"Proceso Penal" , "Mujer",auxi);                
    	}
    }
    
    class eventoAdulta implements ActionListener{
    	public void actionPerformed(ActionEvent e){
            //evento adulta
            ArrayList<Denuncia> den= cliente1;
            ArrayList<Denuncia> den1= new ArrayList<>();
            for(int a=0 ; a< den.size();a++){
                if(den.get(a).getTipoDenuncia()==4){
                    den1.add(den.get(a));
                }
            }
            String [][] da=datosGenerados(den1);
            String auxi="                                 REPORTE  PARCIAL DE  DENUNCIA  DE ADULTA   \n\n";
            for(int y=0;y<da.length ;y++){
                if(da[y][0] != null){
                     auxi = auxi + da[y][0] +" :   " + da[y][1]  + "\n";  
                }
            }
            pdf pdf1=new pdf();
            //  pdf.crear_PDF(TITULO           , autor                         , asunto, clave, contenido);
            pdf1.crear_PDF("Proyecto Simulacion", "Grupo Taller de Simulacion"  ,"Proceso Penal" , "Mujer",auxi);                     
    	}
    }
    
    class eventoTodos implements ActionListener{
    	public void actionPerformed(ActionEvent e){
            // evento todos
            String auxi1="                                REPORTE DE GENERAL DE EFICIENCIA DEL PROCESO JUDICIAL    \n\n" ;
            for(int y=0;y<dtabla.length ;y++){
                if(dtabla[y][0] != null){
                    auxi1 = auxi1 + dtabla[y][0] +" :   " + dtabla[y][1]  + "\n";  
                }
            }                
            auxi1 = auxi1 + "\n";
            String auxi=auxi1+"                                 REPORTE DE GENERAL POR CADA DENUNCIA    \n\n";
            for(int y=0;y<dtabla1.length ;y++){
                if(dtabla1[y][0] != null){
                    auxi = auxi + dtabla1[y][0] +" :   " + dtabla1[y][1]  + "\n";  
                }
            }
            pdf pdf=new pdf();
            //  pdf.crear_PDF(TITULO           , autor                         , asunto, clave, contenido);
            pdf.crear_PDF("Proyecto Simulacion", "Grupo Taller de Simulacion"  ,"Proceso Penal" , "Mujer",auxi);       
    	}
    }    
}