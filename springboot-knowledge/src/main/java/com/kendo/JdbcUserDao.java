package com.kendo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author kedone
 */
public class JdbcUserDao implements UserDao {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcUserDao.class);

    @Override
    public List<String> getAllNames() {
        if (LOG.isInfoEnabled()) {
            LOG.info("从数据库中获取信息");
        }
        return Arrays.asList("Jordan", "Curry", "Harden");
    }
}
