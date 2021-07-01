package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Team teamA = new Team("TeamA");
            em.persist(teamA);

//            Member memberA = new Member("memberA", teamA.getId());
//            em.persist(memberA);

            Member memberA = new Member("memberA");
            memberA.setTeam(teamA);

            em.persist(memberA);

            tx.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(em.isOpen()){
                em.close();
            }
            if(emf.isOpen()){
                emf.close();
            }
        }
    }
}
