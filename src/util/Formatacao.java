/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import javax.swing.JComboBox;

public class Formatacao {

    public static String SenhaString(char[] s) {
        String senha = "";
        for (int i = 0; i < s.length; i++) {
            senha += s[i];
        }
        return senha;
    }

    public static JComboBox preencherComobox(List lista, JComboBox combo, boolean nulo, String valorNulo){
        if (nulo){
            combo.addItem(valorNulo);
        }
        for (int i=0;i<lista.size();i++){
            combo.addItem(lista.get(i));
        }
        return combo;
    }
}
