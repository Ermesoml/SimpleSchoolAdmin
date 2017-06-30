package br.ufg.inf.business.contracts;

import java.util.List;

/**
 * Interface que define um contrato de Negócio genérico
 *
 * @param <Entity> the generic type
 */
public interface BusinessContract<Entity> {

    /**
     * List all.
     *
     * @return the list
     */
    List<Entity> listAll();

    /**
     * Delete.
     *
     * @param entity the entity
     */
    void delete(Entity entity);

    /**
     * Edits the.
     *
     * @param entity the entity
     */
    void edit(Entity entity);

}
