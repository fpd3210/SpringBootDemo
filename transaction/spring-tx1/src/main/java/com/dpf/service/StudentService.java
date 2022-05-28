package com.dpf.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author Pikachues
 * Created 2022/5/27
 */
public class StudentService {
    private JdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;
    private PlatformTransactionManager platformTransactionManager;

    public StudentService(JdbcTemplate jdbcTemplate, TransactionTemplate transactionTemplate, PlatformTransactionManager platformTransactionManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionTemplate = transactionTemplate;
        this.platformTransactionManager = platformTransactionManager;
    }

    public void add(){
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_NESTED);
        // 设置隔离级别
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);

        TransactionStatus status = platformTransactionManager.getTransaction(definition);
        String sql = "insert into t_student(id,user_name) values(?,?)";
        try {
            jdbcTemplate.update(sql,1,"jerry");
            //提交事务
            platformTransactionManager.commit(status);
        } catch (Exception e) {
            // 事务回滚
           platformTransactionManager.rollback(status);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void add2(){
        String sql = "insert into t_student(id,user_name) values(?,?)";
        jdbcTemplate.update(sql,100,"lisi1");
        int i = 10/0;
    }
}
