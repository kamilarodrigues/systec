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
@Table(name = "viewmatriculas")
public class ViewMovimentoAcademicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "matriculas_id")
    private int matriculas_id;
    @Column(name = "disciplinas_id")
    private int disciplinas_id;
    @Column(name = "situacao")
    private String situacao; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatriculas_id() {
        return matriculas_id;
    }

    public void setMatriculas_id(int matriculas_id) {
        this.matriculas_id = matriculas_id;
    }

    public int getDisciplinas_id() {
        return disciplinas_id;
    }

    public void setDisciplinas_id(int disciplinas_id) {
        this.disciplinas_id = disciplinas_id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
 
    
}
