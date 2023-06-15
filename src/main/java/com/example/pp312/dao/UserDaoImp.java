package com.example.pp312.dao;

import com.example.pp312.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public List<User> selectAllUsersFromDatabase() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void updateUser(User userUpdated) {
        entityManager.merge(userUpdated);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        User user = getById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}