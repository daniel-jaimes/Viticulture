package Viticulture.manager;


import Viticulture.dao.HibernateSession;
import org.hibernate.SessionFactory;

public class Controller {
    private SessionFactory sessionHibernate;
    public void init() {
        sessionHibernate = HibernateSession.getSessionFactory();
        readInstructions();
    }

    private void readInstructions() {
        /*
         B NombreBodega
         C
         B NombreBodega
         #
         */
    }
}
