package com.lzqwn.config;

import cn.hutool.core.date.DateUtil;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 * 定时任务配置，配置线程池，使用不同线程执行任务，提升效率
 * </p>
 */
@Configuration
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages = {"com.lzqwn.job"})
@Slf4j
public class TaskConfig implements SchedulingConfigurer, AsyncConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());

        taskRegistrar.getScheduler().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "|SchedulingConfigurer cron task04");
            }
        }, new CronTrigger("0/3 * * * * ?"));

        taskRegistrar.addCronTask(new CronTask(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "|SchedulingConfigurer cron task05");
            }
        }, new CronTrigger("0/2 * * * * ?")));
    }

    /**
     * 这里等同于配置文件配置
     * {@code spring.task.scheduling.pool.size=20} - Maximum allowed number of threads.
     * {@code spring.task.scheduling.thread-name-prefix=Job-Thread- } - Prefix to use for the names of newly created threads.
     * {@link org.springframework.boot.autoconfigure.task.TaskSchedulingProperties}
     */
    //此处为全局设置?存疑(后续),结果为所有
    @Bean
    public Executor taskExecutor() {
        // 定时任务默认为串行,根据任务数量定制配置线程池大小,已达到并行效果
        int PoolSize = 10;
        // 线程名称前缀
        String ThreadNamePrefix = "Job-Executor-%d";
        return new ScheduledThreadPoolExecutor(PoolSize, new BasicThreadFactory.Builder().namingPattern(ThreadNamePrefix).build());
    }

    //此处为串行设置?存疑(后续),结果为串行
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);// 配置线程池大小，根据任务数量定制
        taskScheduler.setThreadNamePrefix("spring-task-scheduler-thread-");// 线程名称前缀
        taskScheduler.setAwaitTerminationSeconds(60);// 线程池关闭前最大等待时间，确保最后一定关闭
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);// 线程池关闭时等待所有任务完成
        return taskScheduler;
    }

    /**
     * 处理异步方法的异常
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SpringAsyncExceptionHandler();
    }

    class SpringAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable arg0, Method arg1, Object... arg2) {
            log.error("Exception occurs in async method", arg0);
        }
    }
}
