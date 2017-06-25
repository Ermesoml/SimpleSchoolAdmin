package br.ufg.inf.business.contracts;

import java.util.List;

public interface BusinessContract<Entity> {

    List<Entity> listAll();

    void delete(Entity entity);

    void edit(Entity entity);

}
