package com.csufg2016.business.contracts;

import java.util.List;

public interface BusinessContract<Entity> {

    List<Entity> listAll();

}
