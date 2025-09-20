package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {

    private static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public void create(Produto p) {
        EntityManager em = getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {
        EntityManager em = getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Produto p) {
        EntityManager em = getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, p.getId());
            em.remove(produto);
            em.getTransaction().commit();
            System.out.println("Produto deletado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Produto findById(Produto p) {
        return getEntityManager().find(Produto.class, p.getId());
    }

    public List<Produto> findAll() {

        List<Produto> produtos = new ArrayList<Produto>();
        produtos = getEntityManager().createQuery("FROM " + Produto.class.getName()).getResultList();
        return produtos;
    }
}
