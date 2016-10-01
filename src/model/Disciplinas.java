/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Kamila
 */
@Entity
@Table(name = "disciplinas")
@NamedQueries({
    @NamedQuery(name = "Disciplinas.findAll", query = "SELECT d FROM Disciplinas d")})
public class Disciplinas implements Serializable {
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "cursos_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cursos cursos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplinasId")
    private List<MovimentosAcademicos> movimentosAcademicosList;

    public Disciplinas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    } 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public List<MovimentosAcademicos> getMovimentosAcademicosList() {
        return movimentosAcademicosList;
    }

    public void setMovimentosAcademicosList(List<MovimentosAcademicos> movimentosAcademicosList) {
        this.movimentosAcademicosList = movimentosAcademicosList;
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
        if (!(object instanceof Disciplinas)) {
            return false;
        }
        Disciplinas other = (Disciplinas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Disciplinas[ id=" + id + " ]";
    }
    
}
