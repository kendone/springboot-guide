# Spring Boot、Mybatis 集成学习笔记

- Mybatis Mapper的配置方式
    - 基于 Mapper 和 Xml 文件的配置方式：在application.properties中设置mybatis.mapper-locations属性值
    为xml文件所在包路径，如`mybatis.mapper-locations=classpath*:com/kendo/mapper/*xml`。
    - 基于纯注解 Mapper 的配置方式：在SpringBoot主程序上使用@MapperScan注解，设置值为Mapper所在的包路径，如
    `@MapperScan("com.kendo.mapper")`。