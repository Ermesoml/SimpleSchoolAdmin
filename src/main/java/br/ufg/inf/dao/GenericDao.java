package br.ufg.inf.dao;

import br.ufg.inf.dao.contracts.GenericDaoContract;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * The Class GenericDao.
 * 
 * Implementação abstrata de Dao
 *
 * @param <Entity> the generic type
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public abstract class GenericDao<Entity extends Serializable> implements GenericDaoContract<Entity> {

    /** The type entity. */
    private final Class<Entity> typeEntity;

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Instantiates a new generic dao.
     *
     * @param typeEntity the type entity
     */
    protected GenericDao(Class<Entity> typeEntity) {
        this.typeEntity = typeEntity;
    }

    /**
     * Db session.
     *
     * @return the session
     */
    public Session dbSession(){
        return getSessionFactory().getCurrentSession();
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.GenericDaoContract#add(java.lang.Object)
     */
    @Override
    public void add(Entity entity) {
        dbSession().save(entity);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.GenericDaoContract#update(java.lang.Object)
     */
    @Override
    @Transactional(readOnly = false)
    public void update(Entity entity) {
        dbSession().update(entity);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.GenericDaoContract#get(long)
     */
    @Override
    @Transactional(readOnly = true)
    public Entity get(long id) {
        return dbSession().get(typeEntity, id);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.GenericDaoContract#delete(java.lang.Object)
     */
    @Override
    public void delete(Entity entity) {
        dbSession().delete(entity);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.GenericDaoContract#listAll()
     */
    @Override
    public List<Entity> listAll() {

        Criteria criteria = dbSession().createCriteria(typeEntity);
        return (List<Entity>)criteria.list();
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.GenericDaoContract#distinctListAll()
     */
    @Override
    public List<Entity> distinctListAll() {

        Criteria criteria = dbSession().createCriteria(typeEntity);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        return (List<Entity>)criteria.list();

    }

    /**
     * Gets the session factory.
     *
     * @return the session factory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Sets the session factory.
     *
     * @param sessionFactory the new session factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
