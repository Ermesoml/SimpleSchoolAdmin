package br.ufg.inf.dao.contracts;


import java.util.List;

public interface GenericDaoContract<Entity> {

    void add(Entity entity);

    void update(Entity entity);

    Entity get(long id);

    void delete(Entity entity);

    List<Entity> listAll();

    List<Entity> distinctListAll();

}
