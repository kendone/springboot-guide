package com.kendo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;


/**
 * @author kendone
 */
public class MongoUserDao implements UserDao {

    private static final Logger LOG = LoggerFactory.getLogger(MongoUserDao.class);

    @Override
    public List<String> getAllNames() {
        if (LOG.isInfoEnabled()) {
            LOG.info("从MongoDB中获取用户信息");
        }
        return Arrays.asList("Jordan", "Curry", "Harden");
    }
}
