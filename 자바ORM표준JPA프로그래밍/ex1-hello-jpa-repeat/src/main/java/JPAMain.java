import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Member memberA = new Member("memberA");
            em.persist(memberA);
            System.out.println("==================================");
            tx.commit();
        } catch (Exception e) {
            System.out.println("에러발생!!!!!!!!!!");
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
