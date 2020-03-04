package com.kendo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

/**
 * @author kendone
 */
@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(rollbackFor = NullPointerException.class)
    public User insert(final User user) {
        String sql = "INSERT INTO users(NAME,EMAIL) VALUES(?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                return ps;
            }
        }, keyHolder);
        int userId = Objects.requireNonNull(keyHolder.getKey()).intValue();
        user.setId(userId);
        return user;
    }

    @Transactional(readOnly = true)
    public User get(Integer id) {
        return jdbcTemplate.queryForObject(
                "SELECT id,name,email FROM users WHERE ID = ?",
                new Object[]{id},
                (rs, i) -> new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                )
        );
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return jdbcTemplate.query(
                "SELECT id,name,email FROM USERS",
                (rs, i) -> new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                )
        );
    }
}
