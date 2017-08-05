import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
/**
 * crea laminas diferentes variando el nº de botones para cada una de ellas.
 * el nº de botones lo determina la longitud del Array que pasamos en el constructor.
 * @author Usuario
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
            add(bot);
            grupo.add(bot);

            // PARA QUE APARECCA UNA DE LOS 'JRadioButton' COMO SELECCIONADO.
            bot.setSelected(i==0);//pide un boolean. i==0 sera true y selecciona el 1ºJRadioButton
        }
    }

    /////////////////////////////    ********** VISTO VIDEO 124

}
