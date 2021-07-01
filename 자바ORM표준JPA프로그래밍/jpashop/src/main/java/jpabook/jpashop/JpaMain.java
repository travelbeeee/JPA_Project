package jpabook.jpashop;

import jpabook.jpashop.domain.jpashop.Album;
import jpabook.jpashop.domain.jpashop.Member;
import jpabook.jpashop.domain.jpashop.Movie;
import jpabook.jpashop.domain.jpashop.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Modifier;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            Album album = new Album();
            album.setName("name");
            album.setPrice(10000);
            album.setAuthor("Author");

            em.persist(album);

            Movie movie = new Movie();
            movie.setName("name2");
            movie.setPrice(20000);
            movie.setActor("actor");
            movie.setDirector("director");

            em.persist(movie);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em.isOpen()) {
                em.close();
            }
            if (emf.isOpen()) {
                emf.close();
            }
        }
    }
}
