/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.view;

import java.io.Serializable; 
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table; 

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "viewturmas")
public class ViewTurmas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "cursos_id")
    private int cursos_id;
    @Column(name = "situacao")
    private String situacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCursos_id() {
        return cursos_id;
    }

    public void setCursos_id(int cursos_id) {
        this.cursos_id = cursos_id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
}
