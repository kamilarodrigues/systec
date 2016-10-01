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
@Table(name = "matriculas")
@NamedQueries({
    @NamedQuery(name = "Matriculas.findAll", query = "SELECT m FROM Matriculas m")})
public class Matriculas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "matricula")
    private String matricula;
    @JoinColumn(name = "alunos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Alunos alunosId;
    @JoinColumn(name = "turmas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Turmas turmasId;

    public Matriculas() {
    }

    public Matriculas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Alunos getAlunosId() {
        return alunosId;
    }

    public void setAlunosId(Alunos alunosId) {
        this.alunosId = alunosId;
    }

    public Turmas getTurmasId() {
        return turmasId;
    }

    public void setTurmasId(Turmas turmasId) {
        this.turmasId = turmasId;
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
        if (!(object instanceof Matriculas)) {
            return false;
        }
        Matriculas other = (Matriculas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Matriculas[ id=" + id + " ]";
    }
    
}
