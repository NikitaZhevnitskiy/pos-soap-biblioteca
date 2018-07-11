package br.ifpb.simba.soap.service;

import br.ifpb.simba.soap.Autor;
import br.ifpb.simba.soap.persistence.Autors;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 29/09/2017, 02:55:04
 */
@WebService
public class AutorService {

    @EJB
    private Autors autores;
    
    @WebMethod(operationName = "saveAutor")
    public void saveAutor(@WebParam(name = "autor") Autor autor) {
        this.autores.saveAutor(autor);
    }
    
    @WebMethod(operationName = "deleteAutor")
    public void deleteAutor(@WebParam(name = "autorCpf") String autorCpf) {
        Autor autor = this.autores.findAutor(autorCpf);
        if (autor!=null){
            this.autores.deleteAutor(autor);
        }
    }
    
    @WebMethod(operationName = "updateAutor")
    public void updateAutor(@WebParam(name = "autor") Autor autor) {
        this.autores.updateAutor(autor);
    }
    
    @WebMethod(operationName = "listAutores")
    public Autor[] listAutores() {
        return this.autores.listAutores().toArray(new Autor[]{});
    }
}
