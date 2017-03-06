package com.spring4.learn.jdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 不推荐使用 JdbcDaoSupport, 而推荐直接使用 JdbcTempate 作为 Dao 类的成员变量
 */
public class DepartmentTestDao extends JdbcDaoSupport {

}
