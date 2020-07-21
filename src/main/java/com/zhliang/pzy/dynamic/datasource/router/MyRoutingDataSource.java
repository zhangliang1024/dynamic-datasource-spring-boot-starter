package com.zhliang.pzy.dynamic.datasource.router;

import com.zhliang.pzy.dynamic.datasource.context.DBContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据库路由
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.getContextHolder();
    }
}
