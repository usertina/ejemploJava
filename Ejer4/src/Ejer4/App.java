/*
 * Preguntar al usuario final que ha comido y bebido. 


 * ¿Qué ha tomado de comer? (palmera, donut o pitufo):
 * ¿Con qué se ha tomado el pitufo? (aceite o tortilla):
 *  
 * ¿Qué ha tomado de beber? (zumo o cafe)

Palmera: 2,50€
Donut: 1€
Pitufo A:1,20€
Pitufo T:3€
Zumo:1,5€
Café: 1,6€
realizado con ventana de dialogo
 */

package Ejer4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Inicializar la suma total y el historial de pedidos
        double sumaTotal = 0;
        List<JPanel> historial = new ArrayList<>();

        Joptions joptions = new Joptions(); // Crear instancia de Joptions

        // Bucle principal del programa
        while (true) {
            String seleccion = joptions.pedir();

            if (seleccion == null) {
                JOptionPane.showMessageDialog(null,
                        "<html>Saliendo del programa. <span style='color: green;'>Gracias!!!</span></html>", "Salida",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            // Variables para almacenar el nombre del producto, su precio y el icono
            String nombreProducto;

            double precioProducto;

            ImageIcon icono;

            // Determina la opción que elige el usuario
            switch (seleccion) {
                case "1. PALMERA (2.50€)":
                    nombreProducto = "Palmera";
                    precioProducto = 2.50;
                    icono = new ImageIcon("src/Ejer4/iconos/palmera.png");
                    break;

                case "2. DONUT (1€)":
                    nombreProducto = "Donut";
                    precioProducto = 1.00;
                    icono = new ImageIcon("src/Ejer4/iconos/donut.png");
                    break;

                case "3. PITUFO (1.20€ o 3€)":
                    String[] opcionesPitufo = { "Pitufo con aceite (1.20€)", "Pitufo con tortilla (3€)" };
                    String seleccionPitufo = (String) JOptionPane.showInputDialog(null,
                            "¿Cómo quieres tu pitufo?",
                            "Pitufo",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcionesPitufo,
                            opcionesPitufo[0]);

                    if ("Pitufo con aceite (1.20€)".equalsIgnoreCase(seleccionPitufo)) {
                        nombreProducto = "Pitufo con aceite (1.20€)";
                        precioProducto = 1.20;
                        icono = new ImageIcon("src/Ejer4/iconos/pitufoAceite.png");
                    } else if ("Pitufo con tortilla (3€)".equalsIgnoreCase(seleccionPitufo)) {
                        nombreProducto = "Pitufo con tortilla (3€)";
                        precioProducto = 3.00;
                        icono = new ImageIcon("src/Ejer4/iconos/pitufoTortilla.png");
                    } else {
                        JOptionPane.showMessageDialog(null, "Opción no válida para el pitufo.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                    break;

                case "4. ZUMO (1.50€)":
                    nombreProducto = "Zumo";
                    precioProducto = 1.50;
                    icono = new ImageIcon("src/Ejer4/iconos/zumo.png");
                    break;

                case "5. CAFÉ (1.60€)":
                    nombreProducto = "Café";
                    precioProducto = 1.60;
                    icono = new ImageIcon("src/Ejer4/iconos/cafe.png");
                    break;

                case "6. VER CUENTA":
                    // Crear un panel para mostrar el historial
                    JPanel historialPanel = new JPanel();
                    historialPanel.setLayout(new BoxLayout(historialPanel, BoxLayout.Y_AXIS));
                    for (JPanel item : historial) {
                        historialPanel.add(item);
                    }
                    ImageIcon iconoFactura = new ImageIcon("src/Ejer4/iconos/factura.png");

                    // Mostrar el mensaje de la suma total con el ícono de la factura
                    JOptionPane.showMessageDialog(null,
                            historialPanel,
                            String.format("Cuenta (Total: %.2f EUR)", sumaTotal),
                            JOptionPane.INFORMATION_MESSAGE, iconoFactura);
                    continue;

                case "7. SALIR":
                    ImageIcon iconoSalir = new ImageIcon("src/Ejer4/iconos/contento.png");
                    JOptionPane.showMessageDialog(null, String.format(
                            "<html>La suma total es: <span style='color: green;'>%.2f EUR</span></html>\n Gracias por su compra!!!",
                            sumaTotal), "Salida", JOptionPane.INFORMATION_MESSAGE, iconoSalir);
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
            }

            // Sumar el precio del producto a la suma total y agregar al historial
            sumaTotal += precioProducto;

            // Crear un panel para el historial de pedidos
            JPanel pedidoPanel = new JPanel();
            pedidoPanel.setLayout(new FlowLayout());
            pedidoPanel.add(new JLabel(icono));
            pedidoPanel.add(new JLabel(String.format("<html>%s - <span style='color:green;'>%.2f EUR</span></html>",
                    nombreProducto, precioProducto)));
            historial.add(pedidoPanel);

            // Mostrar el producto seleccionado y su precio con el icono correspondiente
            JOptionPane.showMessageDialog(null, String.format(
                    "<html>Has seleccionado:<br><strong><span style='color:green;'>%s</span></strong><br>con un precio de:<br><strong><span style='color:green;'>%.2f EUR</span></strong></html>",
                    nombreProducto, precioProducto), "Producto Seleccionado", JOptionPane.INFORMATION_MESSAGE, icono);

            // Mostrar la suma total acumulada
            JOptionPane.showMessageDialog(null,
                    String.format("<html>Suma total acumulada: <span style='color: green;'>%.2f EUR</span></html>",
                            sumaTotal),
                    "Total Acumulado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
