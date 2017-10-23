package br.ifpb.simba.soap.persistence;

import br.ifpb.simba.soap.Autor;
import br.ifpb.simba.soap.Livro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 29/09/2017, 02:04:10
 */
@Stateless
public class Livros {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void saveLivro(Livro livro){
        entityManager.persist(livro);
    }
    
    public void updateLivro(Livro livro){
        entityManager.merge(livro);
    }
    
    public Livro findLivro(String isnb){
        return entityManager.find(Livro.class, isnb);
    }
    
    public void deleteLivro(Livro livro){
        entityManager.remove(livro);
    }
    
    public List<Livro> listLivros(){
        List<Livro> resultList = entityManager
                .createQuery("SELECT c FROM Livro c", Livro.class).getResultList();
        return resultList;
    }
}
