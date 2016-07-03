package com.csufg2016.dao;

import com.csufg2016.dao.contracts.GenericDaoContract;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public abstract class GenericDao<Entity extends Serializable> implements GenericDaoContract<Entity> {

    private final Class<Entity> typeEntity;

    @Autowired
    private SessionFactory sessionFactory;

    protected GenericDao(Class<Entity> typeEntity) {
        this.typeEntity = typeEntity;
    }

    public Session dbSession(){
        return getSessionFactory().getCurrentSession();
    }

    @Override
    public void add(Entity entity) {
        dbSession().save(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Entity entity) {
        dbSession().update(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Entity get(long id) {
        return dbSession().get(typeEntity, id);
    }

    @Override
    public void delete(Entity entity) {
        dbSession().delete(entity);
    }

    @Override
    public List<Entity> listAll() {

        Criteria criteria = dbSession().createCriteria(typeEntity);
        return (List<Entity>)criteria.list();
    }

    @Override
    public List<Entity> distinctListAll() {

        Criteria criteria = dbSession().createCriteria(typeEntity);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        return (List<Entity>)criteria.list();

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
