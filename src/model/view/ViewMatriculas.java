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
public class ViewMatriculas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "alunos_id")
    private int alunos_id;
    @Column(name = "turmas_id")
    private int turmas_id;
    @Column(name = "matricula")
    private String matricula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlunos_id() {
        return alunos_id;
    }

    public void setAlunos_id(int alunos_id) {
        this.alunos_id = alunos_id;
    }

    public int getTurmas_id() {
        return turmas_id;
    }

    public void setTurmas_id(int turmas_id) {
        this.turmas_id = turmas_id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
}
