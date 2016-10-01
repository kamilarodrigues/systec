/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

public class Formatacao {

    public static String SenhaString(char[] s) {
        String senha = "";
        for (int i = 0; i < s.length; i++) {
            senha += s[i];
        }
        return senha;
    }

}
