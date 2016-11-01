/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable; 
import javax.persistence.Basic; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery; 
import javax.persistence.Table;

/**
 *
 * @author Kamila
 */
@Entity
@Table(name = "movimentos_academicos")
@NamedQueries({
    @NamedQuery(name = "MovimentosAcademicos.findAll", query = "SELECT m FROM MovimentosAcademicos m")})
public class MovimentosAcademicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "disciplinas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Disciplinas disciplinasId; 
    @JoinColumn(name = "matriculas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Matriculas matriculasId;

    public MovimentosAcademicos() {
    }

    public MovimentosAcademicos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Disciplinas getDisciplinasId() {
        return disciplinasId;
    }

    public void setDisciplinasId(Disciplinas disciplinasId) {
        this.disciplinasId = disciplinasId;
    }
 

    public Matriculas getMatriculasId() {
        return matriculasId;
    }

    public void setMatriculasId(Matriculas matriculasId) {
        this.matriculasId = matriculasId;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentosAcademicos)) {
            return false;
        }
        MovimentosAcademicos other = (MovimentosAcademicos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MovimentosAcademicos[ id=" + id + " ]";
    }
    
}
