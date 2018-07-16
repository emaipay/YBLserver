package com.ybl.net.persist.database.mybatis;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }
}
