package br.ifpb.simba.soap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 29/09/2017, 01:50:35
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Livro implements Serializable {

    @Id
    private String isbn;
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = {
        @JoinColumn(name = "livro_isbn")
    }, inverseJoinColumns = {
        @JoinColumn(name = "autor_cpf")
    })
    private List<Autor> autores;

    public Livro() {
        autores = new ArrayList<>();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    
    public boolean addAutor(Autor autor) {
        return this.autores.add(autor);
    }
    
    public boolean removeAutor(String cpf) {
        for (Autor a : autores) {
            if (cpf.equals(a.getCpf())) {
                autores.remove(a);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Livro{" + "isbn=" + isbn + ", nome=" + nome + ", autores=" + autores + '}';
    }

}
