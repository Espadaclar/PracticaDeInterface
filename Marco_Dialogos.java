import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
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

    private String[] primero = {"Mensaje", "Confirmar", "Opcion", "Entrada"};    
    private String[] segundo = {"ERROR_MESSSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"};    
    private String[] tercero = {"Cadena", "Icono", "Componente", "Otros", "Object[]"};    
    private String[] cuarto = {"DEFALUT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"};    
    private String[] quinto = {"String", "Icono[]", "Object[]"};    
    private String[] sesto = {"Campo de texto", "Combo"};

    private JButton boton;

    public Marco_Dialogos() {

        setLayout(new BorderLayout());//---- tipo de disposicion para el marco.
        
        JPanel lamina_cuadrada = new JPanel();// --lamina para la zona central del marco.
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

        add(lamina_cuadrada, BorderLayout.CENTER);//anade la lamina al marco.
        add(boton, BorderLayout.SOUTH);// ------anade un boton al marco.

        setBounds(300, 100, 600, 550);
        setVisible(true);
        setTitle("Primer Práctica");

        Toolkit icon = Toolkit.getDefaultToolkit();
        Image image = icon.getImage("../icono2.gif");
        setIconImage(image);

    }

    // --- CLASE PARA PONER A LA ESCUCHA
        private class AccionMostrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //- para que nos muestre el boton seleccionado invocamos al mt 'dameSeleccion()' de la cl 'Lamina_Botones'
            //- sobre cada una de las laminas creadas, (sobre sus atributos que hemos creado en esta clase).
            //private Lamina_Botones lamina_tipo, lamina_tipoMensaje, laminaMensaje, lamina_confirmar, laminaOpcion, laminaEntrada;

            // ---EL NOMBRE DEL BOTON SELECCIOADO DE CADA LAMINA ES ALMACENADO EN UN VL.
            //  --Estas VL son las que condicionan el tipo de ventana y los datos que aparecen en ella.
            String tipoDeVentana = lamina_tipo.dameSeleccion();//-- almacena el tipo de 'JOptionPane' 
            String tipoDeMensaje = lamina_tipoMensaje.dameSeleccion();
            String mensajeEnVentana = laminaMensaje.dameSeleccion();
            String tipoDeConfirmacion = lamina_confirmar.dameSeleccion();
            String tipoOpcion = laminaOpcion.dameSeleccion();
            String tipoDeEntrada = laminaEntrada.dameSeleccion();
            //    PARAMETROS QUE PASAMOA A LA CL. 'JOptionPane' PARA CREAR LOS DIFERENTES TIPOS DE VENTANS EMER..
            //----****** el parámetro 1º es para indicarle quien es el ,componente que va ha desencadenar la acción. 
            //----****** el parámetro 2º, es para add un mensaje o componente que se fija en la ventana.
            //---- ***   el 3º es para poner titulo, componente, boton etc a la ventana emergente. 
            //----****** el 4º A PARTIR DE ESTE PARAMETRO LOS PARAMETROS SON DIFERENTES PARA CADA VENTANA.
            //JOptionPane(Object message, int messageType, int optionType, Icon icon, Object[] options, Object initialValue)
            if (tipoDeVentana.equals("Mensaje")) {
                JOptionPane.showMessageDialog(lamina_tipo, getObject(), "Mensaje", getIconLamina());
            } else if (tipoDeVentana.equals("Confirmar")) {
                JOptionPane.showConfirmDialog(lamina_tipo, getObject(), "Confirmar", getConfirmarLamina(), getIconLamina());
            } else if (tipoDeVentana.equals("Opcion")) {
                JOptionPane.showOptionDialog(lamina_tipo, getObject(), "Opciones", getConfirmarLamina(), getIconLamina(), null, getOptionLamina(), getEntrada());
            } else if (tipoDeVentana.equals("Entrada")) {
                if (laminaEntrada.dameSeleccion().equals("Campo de texto")) {
                    JOptionPane.showInputDialog(lamina_tipo, getObject(), "Entradas");
                } else {
                    JOptionPane.showInputDialog(lamina_tipo, getObject(), "Combo", getIconLamina(), null, new String[]{"Amarillo", "Roj", "Azul"}, "Azul");
                }
            }
        }
    }

    ////// ****** SERIE DE METODOS PARA CODIFICAR LOS DISTINTOS TIPOS DE VENTANAS EMERGENTES  ************************
    /**
     * devuelve un icono aleatoriamente, servira como parametro en la cl
     * 'JOptionPane' utilizada en la class interna; 'AccionMostrar implements
     * ActionListener'.
     */
    public Icon getIcon() {
        Random ale = new Random();
        String[] rutaIcono = {"../iconos/flag_blue.gif", "../iconos/application_flash.gif", "../iconos/icon_info.gif",
            "../iconos/interface_installer.gif", "../iconos/page_deny.gif", "../iconos/image.gif"};
        int val = ale.nextInt(rutaIcono.length);

        Icon iconoImage = new ImageIcon(rutaIcono[val]);
        return iconoImage;
    }

    /**
     * CODIGO PARA LA ELECCION DE UN ICONO EN LA VENTANA EMERGENTE. asigna un
     * icono a la lamina, dependiendo de la opcion "ERROR_MESSAGE",
     * "WARNING_MESSAGE", etc
     */
    public int getIconLamina() {
        int valor = 0;
        if (lamina_tipoMensaje.dameSeleccion().equals("ERROR_MESSAGE")) {
            valor = 0;
        } else if (lamina_tipoMensaje.dameSeleccion().equals("INFORMATION_MESSAGE")) {
            valor = 1;
        } else if (lamina_tipoMensaje.dameSeleccion().equals("WARNING_MESSAGE")) {
            valor = 2;
        } else if (lamina_tipoMensaje.dameSeleccion().equals("QUESTION_MESSAGE")) {
            valor = 3;
        } else if (lamina_tipoMensaje.dameSeleccion().equals("PLAIN_MESSAGE")) {
            valor = -1;
        }
        return valor;

    }

    /**
     * CODIGO PARA LA ELECCION DE VENTANA EMERGENTE DE TIPO 'CONFIRMAR'
     *
     * @return
     */
    public int getConfirmarLamina() {
        int valor = 0;
        if (lamina_confirmar.dameSeleccion().equals("DEFAULT_OPTION")) {
            valor = -1;
        } else if (lamina_confirmar.dameSeleccion().equals("YES_NO_OPTION")) {
            valor = 0;
        } else if (lamina_confirmar.dameSeleccion().equals("YES_NO_CANCEL_OPTION")) {
            valor = 1;
        } else if (lamina_confirmar.dameSeleccion().equals("OK_CANCEL_OPTION")) {
            valor = 2;
        }
        return valor;
    }

    /**
     * CODIGO PARA LA ELECCION DE VENTANA EMERGENTE DE TIPO 'CONFIRMAR'
     *
     * @return
     */
    public Object getEntrada() {
        Object valor = new Object();
        if (laminaEntrada.dameSeleccion().equals("Campo de texto")) {
            JTextField text = new JTextField(15);
            valor = text;
        } else if (laminaEntrada.dameSeleccion().equals("Combo")) {
            /* JComboBox combo = new JComboBox();
             combo.addItem("Azul ");
             combo.addItem("Amarillo");
             combo.addItem("Rojo");*/
            valor = new String[]{"Amarillo", "Roj", "Azul"};
        }

        return valor;
    }

    /**
     * CODIGO PARA LA ELECCION DE VENTANA EMERGENTE DE TIPO 'OPCION'
     *
     * @return
     */
    public Object[] getOptionLamina() {
        Object[] valor = new Object[3];
        Icon iconoImage = new ImageIcon("../iconos/image.gif");
        Icon iconoImage2 = new ImageIcon("../iconos/page_deny.gif");
        Icon iconoImage3 = new ImageIcon("../iconos/interface_installer.gif");
        Date fecha = new Date();
        if (laminaOpcion.dameSeleccion().equals("String")) {
            valor[0] = "Amarillo";
            valor[1] = "Azul";
            valor[2] = "Rojo";
            /*valor[0] = new JButton("Boton 1");
             valor[1] = new JButton("Boton 2");
             valor[2] = new JButton("Boton 3");*/
        } else if (laminaOpcion.dameSeleccion().equals("Icono[]")) {
            valor[0] = iconoImage;
            valor[1] = iconoImage2;
            valor[2] = iconoImage3;
            /*valor[0] = new JButton(iconoImage);
             valor[1] = new JButton(iconoImage2);
             valor[2] = new JButton(iconoImage3);*/
        } else if (laminaOpcion.dameSeleccion().equals("Object[]")) {
            valor[0] = new JButton(iconoImage);
            valor[1] = fecha;
            valor[2] = new JButton("Boton X");
        }
        return valor;

    }

    /**
     * CODIGO PARA LA ELECCION DE VENTANA EMERGENTE DE TIPO 'OPCION' devuelve un
     * objeto, servira como parametro en la cl 'JOptionPane' utilizada en la
     * class interna; 'AccionMostrar implements ActionListener'.
     */
    public Object getObject() {

        Object objeto2 = new Object();

        String cadena = "Mensaje";
        Icon icono = getIcon();
        JButton boton = new JButton(getIcon());
        boton.setBackground(Color.yellow);
        Date date = new Date();
        Object[] objeto = new Object[4];

        objeto[0] = cadena;
        objeto[1] = icono;
        objeto[2] = boton;
        objeto[3] = date;

        if (laminaMensaje.dameSeleccion().equals("Cadena")) {
            objeto2 = objeto[0];
        } else if (laminaMensaje.dameSeleccion().equals("Icono")) {
            objeto2 = objeto[1];
        } else if (laminaMensaje.dameSeleccion().equals("Componente")) {
            objeto2 = objeto[2];
        } else if (laminaMensaje.dameSeleccion().equals("Otros")) {
            objeto2 = objeto[3];
        } else if (laminaMensaje.dameSeleccion().equals("Object[]")) {
            objeto2 = objeto;
        }
        return objeto2;
    }
}
