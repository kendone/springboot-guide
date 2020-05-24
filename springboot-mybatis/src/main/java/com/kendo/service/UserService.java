package com.kendo.service;

import com.kendo.domain.User;

/**
 * @author kendone
 */
public interface UserService {

    User getUserWithoutTransaction(Integer id);

    User getUserWithTransaction(Integer id);

}
