import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 *
 * @author Usuario
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
}
