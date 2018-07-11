package br.ifpb.simba.soap.persistence;

import br.ifpb.simba.soap.Autor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 29/09/2017, 02:04:04
 */
@Stateless
public class Autors {

    @PersistenceContext
    private EntityManager entityManager;
    
    public void saveAutor(Autor autor){
        entityManager.persist(autor);
    }
    
    public void updateAutor(Autor autor){
        entityManager.merge(autor);
    }
    
    public Autor findAutor(String cpf){
        return entityManager.find(Autor.class, cpf);
    }
    
    public List<Autor> listAutores(){
        List<Autor> resultList = entityManager
                .createQuery("SELECT c FROM Autor c", Autor.class).getResultList();
        return resultList;
    }

    public void deleteAutor(Autor autor) {
        if (!entityManager.contains(autor)) {
            autor = entityManager.merge(autor);
        }
        entityManager.remove(autor);
    }
}
