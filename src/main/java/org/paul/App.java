package org.paul;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

// Hibernate mapping relation
public class App {
    public static void main(String[] args) {

        /*
        Laptop laptop = new Laptop();
        laptop.setLaptopId(103);
        laptop.setLaptopName("Hp");

        Student student = new Student();
        student.setRollNumber(36);
        student.setName("Sidhant");
        student.setMarks(90);
        student.getLaptop().add(laptop);

        laptop.getStudent().add(student); */

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        /*
         session.save(laptop);
         session.save(student); */

        Student student = session.get(Student.class, 102);
        System.out.println(student.getName());
        /*Collection<Laptop> laptops = student.getLaptop();
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }*/

        session.getTransaction().commit();

    }
}
