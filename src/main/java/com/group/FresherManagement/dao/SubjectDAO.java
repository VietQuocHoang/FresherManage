package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Subject;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends GenericDAO<Subject> {

    public SubjectDAO(Class<Subject> subjectClass) {
        super(subjectClass);
    }

    public void update(Subject subject) {
        Subject curr = findById(subject.getId());
        EntityManager entityManager = getEntityManager();
        subject.setId(curr.getId());
        entityManager.getTransaction().begin();
        entityManager.merge(subject);
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
        } catch (Exception e){
            return null;
        } finally {
            entityManager.close();
        }
        return list;
    }
}
