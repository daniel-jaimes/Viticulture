package manager;

import dao.HibernateSession;
import model.Cellar;
import model.Entry;
import model.Field;
import model.Vid;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private Session sessionHibernate;
    private Transaction transaction;
    private Cellar lastCellarObtained;
    private Field lastFieldObtained;

    public void init() {

        initSession();
        readInstructions();
        printAllFields();
        endSession();
    }

    private void printAllFields() {
        List<Field> fields = getAllData(Field.class);
        fields.forEach(System.out::println);
    }

    private void readInstructions() {
        List<Entry> instructions;
        instructions = getAllData(Entry.class);
        instructions
                .stream().map(Entry::getInstructions) //Obtenemos las instrucciones
                .forEach(this::instructionSelector);
    }

    private void instructionSelector(String instruction) {
        System.out.println(instruction);
        try{
            transaction = sessionHibernate.beginTransaction();
            String[] command = instruction.split(" ");
            String option = command[0];
            List<String> action = command.length > 1
                    ? Arrays.asList(Arrays.copyOfRange(command, 1, command.length))
                    : Arrays.asList(command);
            switch (option){
                case "B":
                    createCellar(action.get(0));
                    break;
                case "C":
                    asignIdCellarToField();
                    break;
                case "V":
                    createVidAsignField(action);
                    break;
                case "#":
                    moveVidsFromFieldToCellar();
                    break;
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback(); // Roll back if any exception occurs.
            e.printStackTrace();
        }
    }

    private void moveVidsFromFieldToCellar() {
        System.out.println(lastFieldObtained);
        lastCellarObtained.setVids(lastFieldObtained.getVids());
        sessionHibernate.save(lastCellarObtained);
        System.out.println("Move Vids From Field to Cellar Successfullly");
    }

    private void createVidAsignField(List<String> action) {
        int idVid = (Integer) sessionHibernate.save(new Vid(action.get(0),
                Integer.parseInt(action.get(1)),
                lastFieldObtained));
        Vid vid = sessionHibernate.get(Vid.class, idVid);
        lastFieldObtained.getVids().add(vid);
        sessionHibernate.save(lastFieldObtained);
        System.out.println("Vid Saved Successfully");
    }

    private void asignIdCellarToField() {
        int idLastFieldSaved = (Integer) sessionHibernate
                .save(new Field(lastCellarObtained.getId()));
        lastFieldObtained = sessionHibernate
                .get(Field.class, idLastFieldSaved);
        System.out.println("Field Saved Successfully");
    }

    private void createCellar(String nameCellar) {
        int idLastCellarSaved = (Integer) sessionHibernate
                .save(new Cellar(nameCellar));
        lastCellarObtained = sessionHibernate
                .get(Cellar.class, idLastCellarSaved);
        System.out.println("Cellar Saved Successfully");
    }

    private <T> List<T> getAllData(Class<T> type) {
        CriteriaBuilder builder = sessionHibernate
                .getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        return sessionHibernate.createQuery(criteria).getResultList();
    }

    private void initSession() {
        HibernateSession.buildSessionFactory();
        sessionHibernate = HibernateSession.getSessionFactory().openSession();
    }

    private void endSession() {
        sessionHibernate.close();
    }


}
