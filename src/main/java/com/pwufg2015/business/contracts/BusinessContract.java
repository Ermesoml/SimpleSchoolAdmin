package com.pwufg2015.business.contracts;

import java.util.List;

public interface BusinessContract<Entity> {

    List<Entity> listAll();

}
