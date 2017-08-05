import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * crea laminas diferentes variando el nº de botones para cada una de ellas.
 * el nº de botones lo determina la longitud del Array que pasamos en el constructor.
 * Despues de haber creado la presentación de la interface, ponemos a los botones a la escucha.
 * 
 *1º tratamos de que el boton ‘Aceptar’ averigue cual es el boton seleccionado.  ¡¡¡ VER MT--> 'dameSeleccion()'
 *   ---------El mt getActionCommand() devuelve El String del boton correspondiente a una acción de comado, luego 
 *2º .Tenemos que hacer que nuestross botones desencadenen acciones de comando, como el propio mt , 
 *    getActionCommand(), indica aplicando a cada boton el mt ,setActionCommand( …..),
 *   Para ello nos vamos al lugar donde construiamos los botones, dentro del bucle for.
 *3º .Tenemos que hacer que al pulsar el boton de ‘Aceptar’ se ejecute el mt. Luego
 *     Nos vamos a donde creamos el boton y le aplicamos la interface ‘addActionListener( …… )’

 * @author FRANCISCO_JAVIER
 */
public class Marco_Dialogos extends JFrame {

    private Lamina_Botones lamina_tipo;
    private Lamina_Botones lamina_tipoMensaje;
    private Lamina_Botones laminaMensaje;
    private Lamina_Botones lamina_confirmar;
    private Lamina_Botones laminaOpcion;
    private Lamina_Botones laminaEntrada;
  
    private String[] primero = {"Mensje", "Confirmar", "Opcion", "Entrada"};    
    private String[] segundo = {"ERROR_MESSSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"};    
    private String[] tercero = {"Cadena", "Icono", "Componente", "Otros", "Object[]"};    
    private String[] cuarto = {"DEFALUT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"};    
    private String[] quinto = {"String", "Icono[]", "Object[]"};    
    private String[] sesto = {"Campo de texto", "Combo"};

    private JButton boton;
    
    public Marco_Dialogos() {

        setLayout(new BorderLayout());//---- tipo de disposicion para el marco.
        //anade una lamina al marco.
        JPanel lamina_cuadrada = new JPanel();
        lamina_cuadrada.setLayout(new GridLayout(2, 3));

        lamina_tipo = new Lamina_Botones("Tipo", primero);
        lamina_cuadrada.add(lamina_tipo);
        lamina_tipoMensaje = new Lamina_Botones("Tipo de Mensaje", segundo);
        lamina_cuadrada.add(lamina_tipoMensaje);
        
        laminaMensaje = new Lamina_Botones("Mensaje", tercero);
        lamina_cuadrada.add(laminaMensaje);
        lamina_confirmar = new Lamina_Botones("Confirmar", cuarto);
        lamina_cuadrada.add(lamina_confirmar);

        laminaOpcion = new Lamina_Botones("Opción", quinto);
        lamina_cuadrada.add(laminaOpcion);
        laminaEntrada = new Lamina_Botones("Entrada", sesto);
        lamina_cuadrada.add(laminaEntrada);
        
        boton = new JButton("Aceptar");
        boton.addActionListener(new AccionMostrar());//parametro -> clase donde esta codificada la accion que realiza.
        
        add(lamina_cuadrada, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);
        
        // ----- COORDENADAS PARA EL MARCO.
        setBounds(300, 100, 600, 550);
        setVisible(true);
        setTitle("Primer Práctica");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);

    }
    
    // --- CLASE PARA PONER A LA ESCUCHA
    private class AccionMostrar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {  
            //- para que nos muestre el boton seleccionado invocamos al mt de la cl 'Lamina_Botones'
            //- sobre cada una de las laminas creadas, sobre sus atributos que hemos creado en esta clase.
            //private Lamina_Botones lamina_tipo, lamina_tipoMensaje, laminaMensaje, lamina_confirmar, laminaOpcion, laminaEntrada;
            System.out.println(lamina_tipoMensaje.dameSeleccion());
            System.out.println(lamina_tipo.dameSeleccion());
            System.out.println("---------------");
        }
    
    }
}
