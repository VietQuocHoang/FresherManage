package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Subject;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends GenericDAO<Subject> {

    public SubjectDAO(Class<Subject> subjectClass) {
        super(subjectClass);
    }

    public void update(Subject subject) {
        EntityManager entityManager = getEntityManager();
        Subject curr = entityManager.find(Subject.class, subject.getId());
        curr.setDescription(subject.getDescription());
        curr.setAvailable(subject.isAvailable());
        curr.setName(subject.getName());
        curr.setAcronym(subject.getAcronym());
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Subject> findByNotSubjectId(List<Integer> includedSubjectList) {
        EntityManager entityManager = getEntityManager();
        List<Subject> list = new ArrayList<Subject>();
        try {
            entityManager.getTransaction().begin();
            list = entityManager.createQuery("from Subject s where s.id NOT IN :ids")
                    .setParameter("ids", includedSubjectList)
                    .getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
        return list;
    }

    public Subject findByAcronym(String acronym) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("from Subject s where s.acronym=:acronym", Subject.class)
                    .setParameter("acronym", acronym)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
