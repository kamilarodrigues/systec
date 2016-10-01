/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.usuario;
 
import model.Usuario;

/**
 *
 * @author Wolverine
 */
public class UsuarioLogadoBean {
    
    private Usuario usuario; 

    public UsuarioLogadoBean() {
        this.usuario = new Usuario(); 
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 
    
}
