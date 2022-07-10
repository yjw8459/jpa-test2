package book.shop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        //persistence.xml의 persistence-unit name
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        //EntityManager를 만들면 DB연결이 됨.
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        try {
            tx.commit();
        }
        catch (Exception e){
            tx.rollback();
        }
        finally {
            entityManager.close();
        }
        emf.close();
    }
}
