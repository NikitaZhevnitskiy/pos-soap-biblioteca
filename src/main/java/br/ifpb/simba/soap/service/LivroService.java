package br.ifpb.simba.soap.service;

import br.ifpb.simba.soap.Autor;
import br.ifpb.simba.soap.Livro;
import br.ifpb.simba.soap.persistence.Autors;
import br.ifpb.simba.soap.persistence.Livros;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 29/09/2017, 02:59:35
 */
@WebService
public class LivroService {

    @EJB
    private Livros livros;
    @EJB
    private Autors autores;

    @WebMethod(operationName = "saveLivro")
    public void saveLivro(@WebParam(name = "livro") Livro livro) {
        this.livros.saveLivro(livro);
    }

    @WebMethod(operationName = "linkarAutor")
    public void linkarAutor(
            @WebParam(name = "livroIsbn") String isbn,
            @WebParam(name = "autorCpf") String cpf) {
        
        Livro livro = livros.findLivro(isbn);
        Autor autor = autores.findAutor(cpf);
        livro.addAutor(autor);
        this.livros.updateLivro(livro);
    }

    @WebMethod(operationName = "unlinkarAutor")
    public void unlinkarAutor(
            @WebParam(name = "livroIsbn") String isbn,
            @WebParam(name = "autorCpf") String cpf) {
        Livro livro = livros.findLivro(isbn);
        livro.removeAutor(cpf);
        this.livros.updateLivro(livro);
    }

    @WebMethod(operationName = "deleteLivro")
    public void deleteLivro(@WebParam(name = "livroIsbn") String isbn) {
        Livro livro = this.livros.findLivro(isbn);
        this.livros.deleteLivro(livro);
    }

    @WebMethod(operationName = "updateLivro")
    public void update(@WebParam(name = "livroModificado") Livro livro) {
        this.livros.updateLivro(livro);
    }

    @WebMethod(operationName = "listLivros")
    public Livro[] listLivross() {
        return this.livros.listLivros().toArray(new Livro[]{});
    }
}
