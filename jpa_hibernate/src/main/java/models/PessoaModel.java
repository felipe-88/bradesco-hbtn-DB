package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {
    private static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public void create(Pessoa p) {
        EntityManager em = getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa cadastrada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao cadastrar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {
        EntityManager em = getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Pessoa atualizada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Pessoa p) {
        EntityManager em = getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Pessoa pessoa = em.find(Pessoa.class, p.getId());
            em.remove(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa deletada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Pessoa findById(Pessoa p) {
        return getEntityManager().find(Pessoa.class, p.getId());
    }

    public List<Pessoa> findAll() {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas = getEntityManager().createQuery("FROM " + Pessoa.class.getName()).getResultList();
        return pessoas;
    }
}
