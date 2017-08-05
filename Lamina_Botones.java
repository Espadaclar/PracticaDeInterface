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
class Lamina_Botones extends JPanel{
    private ButtonGroup grupo;
    private JRadioButton bot;

    /**
     * Constructor 
     * @param titulo nombre de la lamina.
     * @param opciones que muestra la lamina, y indica el nº de elementos de la lamina 'opciones.length'.
     */            
    public Lamina_Botones(String titulo, String[] opciones) {
        //ponemos un borde a la lamina con un titulo, utilizamos la cl BorderFactory.
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), titulo));
        // aplicamos la disposicion de la lamina, con la cl BoxLayout( componente donde se aplica, orientacion)
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // ponemos los componentes de la lamina, estarán agrupados.
        grupo = new ButtonGroup();

        for(int i = 0; i < opciones.length; i ++){
            bot = new JRadioButton(opciones[i]);
            // -- DOTAMOSS AL BOTON con 'setActionCommand("  ")' PARA QUE REALICE UNA ACCION.
            bot.setActionCommand(opciones[i]);//- en el parametro hacemos que coincida con el nombre del  boton
            add(bot);
            grupo.add(bot);

            // PARA QUE APARECCA UNA DE LOS 'JRadioButton' COMO SELECCIONADO.
            bot.setSelected(i==0);//pide un boolean. i==0 sera true y selecciona el 1ºJRadioButton
        }
    }

    /**
     * @return el nombre del boton que esta seleccionado
     */
    public String dameSeleccion(){
        //-- SELECCIONA EL BOTON SELECCIONADO DE TODOS LOS QUE TENEMOS.
       ButtonModel miboton = grupo.getSelection();
        String s = miboton.getActionCommand();// --Toma el nombre del botón y lo almacena.
        return s;
        // ---- ¡¡¡LO MISMO PERO EN UNA LINEA.
        //return grupo.getSelection().getActionCommand();
    }

}
