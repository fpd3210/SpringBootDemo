package com.dpf.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
@Slf4j
class AsyncApplicationTests {

    @Autowired
    private AsyncTasks asyncTasks;

    @Autowired
    private AsyncTasksCallable asyncTasks2;

    @Test
    public void test() throws Exception {
        asyncTasks.doTaskOne();
        asyncTasks.doTaskTwo();
        asyncTasks.doTaskThree();
    }

    @Test
    public void testCallable() throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<String> task1 = asyncTasks2.doTaskOne();
        CompletableFuture<String> task2 = asyncTasks2.doTaskTwo();
        CompletableFuture<String> task3 = asyncTasks2.doTaskThree();

        CompletableFuture.allOf(task1, task2, task3).join();

        long end = System.currentTimeMillis();

        log.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}
