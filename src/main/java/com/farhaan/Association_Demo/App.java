package com.farhaan.Association_Demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.farhaan.Association_Demo.entity.Address;
import com.farhaan.Association_Demo.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("stud_pu");
        EntityManager em = emf.createEntityManager();
        Student s1 = new Student(202,"Mirdula Mam");
        
        Address a1 = new Address(101,"XXX","City1");
        Address a2 = new Address(102,"YYY","City2");
        Address a3 = new Address(103,"QQQ","City3");
        Address a4 = new Address(104,"WWW","City4");
        s1.addAddress(a3);
        s1.addAddress(a4);
        s1.addAddress(a1);
        s1.addAddress(a2);
        em.getTransaction().begin();
        em.persist(s1);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
