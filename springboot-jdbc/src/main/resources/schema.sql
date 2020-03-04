CREATE TABLE `world`.`Untitled`
(
    `id`    int(11)                                                 NOT NULL AUTO_INCREMENT,
    `name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;