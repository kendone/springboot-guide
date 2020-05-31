package com.kendo;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kendone
 */
@RestController
@SpringBootApplication
public class SpringbootDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDruidApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public User getUser() {
        return jdbcTemplate.queryForObject(
                "SELECT id,name,email FROM user WHERE ID = ?",
                new Object[]{1},
                (rs, i) -> new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                )
        );
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>(2);
        initParams.put("loginUserName", "admin");
        initParams.put("loginPassword", "123456");
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        bean.setUrlPatterns(Arrays.asList("/*"));

        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);

        return bean;
    }
}
