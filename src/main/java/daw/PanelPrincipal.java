package daw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;
    private String operacionIntroducida = "";

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();

        List<String> listaOperacionesDisponibles = new ArrayList<>();
        listaOperacionesDisponibles.add("+");
        listaOperacionesDisponibles.add("-");
        listaOperacionesDisponibles.add("*");
        listaOperacionesDisponibles.add("/");
        listaOperacionesDisponibles.add("C");
        listaOperacionesDisponibles.add("=");

        String textoButon = ((JButton) o).getText();
        if (textoButon.equals("C")) {
            operacionIntroducida = "";
        } else if (textoButon.equals("=")) {
            // Muestro el resultado de la operacion introducida por el usuario
            areaTexto.setText(calcularResultadoOperacion(operacionIntroducida));
        } else if (listaOperacionesDisponibles.contains(textoButon)) {
            // Añado espacios antes y despues del tipo de operacion para poder
            // hacer despues correctamente el split
            operacionIntroducida += " " + textoButon + " ";
        } else {
            operacionIntroducida += textoButon;
        }
        
        // En caso de no ser el caracter "=" muestro la operacion que ha
        // introducido hasta el momento el usuario
        if (!textoButon.contains("=")) {
            areaTexto.setText(operacionIntroducida);
        }
    }

    public String calcularResultadoOperacion(String operacionIntroducida) {
        String[] operacionUsuario = operacionIntroducida.trim().split(" ");
        // System.out.println(Arrays.toString(operacionUsuario));
        double resultado = 0.0;
        // Si hay dos operandos hago el calculo correspondiente
        if (operacionUsuario.length == 3) {
            double numero1 = Double.parseDouble(operacionUsuario[0]);
            double numero2 = Double.parseDouble(operacionUsuario[2]);
            if (operacionIntroducida.contains("*")) {
                resultado = numero1 * numero2;
            } else if (operacionIntroducida.contains("+")) {
                resultado = numero1 + numero2;
            } else if (operacionIntroducida.contains("/")) {
                resultado = numero1 / numero2;
            } else if (operacionIntroducida.contains("-")) {
                resultado = numero1 - numero2;
            }
            System.out.println(resultado);
            // En caso contrario muestro un mensaje de error
        } else {
            JOptionPane.showMessageDialog(null, "No has introducido dos"
                    + " operandos, o has introducido más de 2 operandos y una"
                    + " operación");
        }
        return resultado + "";
    }
}
