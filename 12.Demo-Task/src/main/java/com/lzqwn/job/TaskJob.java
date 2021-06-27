package com.lzqwn.job;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * 定时任务
 * </p>
 */
@Component
@Slf4j
public class TaskJob {

    /**
     * 按照标准时间来算，每隔 10s 执行一次
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void job1() {
        //log.info("【job1】开始执行：{}", DateUtil.formatDateTime(new Date()));
        System.out.println(Thread.currentThread().getName() + " | task01 " + new Date().toLocaleString());
        try {
            Thread.sleep( 3000 );
        } catch (Exception e){
            System.exit( 0 ); //退出程序
        }
        System.out.println( "task01成功了" );

    }

    /**
     * 从启动时间开始，间隔 2s 执行
     * 固定间隔时间
     */
    @Async
    @Scheduled(fixedRate = 2000)
    public void job2() {
        //log.info("【job2】开始执行：{}", DateUtil.formatDateTime(new Date()));
        System.out.println(Thread.currentThread().getName() + " | task02 " + new Date().toLocaleString());
        try {
            Thread.sleep( 3000 );
        } catch (Exception e){
            System.exit( 0 ); //退出程序
        }
        System.out.println( "task02成功了" );
    }

    /**
     * 从启动时间开始，延迟 5s 后间隔 4s 执行
     * 固定等待时间
     */
    @Async
    @Scheduled(fixedDelay = 4000, initialDelay = 5000)
    public void job3() {
        //log.info("【job3】开始执行：{}", DateUtil.formatDateTime(new Date()));
        System.out.println(Thread.currentThread().getName() + " | task03 " + new Date().toLocaleString());
        try {
            Thread.sleep( 3000 );
        } catch (Exception e){
            System.exit( 0 ); //退出程序
        }
        System.out.println( "task03成功了" );
    }
}
