package com.devdream.cookall.core.dto;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public abstract class OrikaMapper {

    private static MapperFactory mapperFactory = null;

    public static MapperFactory getMapperFactory() {
        if (mapperFactory == null) {
            mapperFactory = new DefaultMapperFactory
                    .Builder()
                    .build();
        }
        return mapperFactory;
    }

}
