package br.ufg.inf.dao.contracts;


import java.util.List;

/**
 * The Interface GenericDaoContract.
 * 
 * Implementação genérica de objetos de acesso a banco
 *
 * @param <Entity> the generic type
 */
public interface GenericDaoContract<Entity> {

    /**
     * Adds the.
     *
     * @param entity the entity
     */
    void add(Entity entity);

    /**
     * Update.
     *
     * @param entity the entity
     */
    void update(Entity entity);

    /**
     * Gets the.
     *
     * @param id the id
     * @return the entity
     */
    Entity get(long id);

    /**
     * Delete.
     *
     * @param entity the entity
     */
    void delete(Entity entity);

    /**
     * List all.
     *
     * @return the list
     */
    List<Entity> listAll();

    /**
     * Distinct list all.
     *
     * @return the list
     */
    List<Entity> distinctListAll();

}
