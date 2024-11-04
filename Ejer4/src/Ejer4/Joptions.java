
package Ejer4;

import javax.swing.JOptionPane;

public class Joptions {

  public String pedir() {

    String[] options = { "1. PALMERA (2.50€)", "2. DONUT (1€)", "3. PITUFO (1.20€ o 3€)", "4. ZUMO (1.50€)",
        "5. CAFÉ (1.60€)", "6. VER CUENTA", "7. SALIR" };

    String res = (String) JOptionPane.showInputDialog(null, "Elige una:", "Menu", JOptionPane.QUESTION_MESSAGE, null,
        options, options[0]);
    return res;
  }
}
