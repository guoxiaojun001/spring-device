package com.guoxi.springdevice.service;

import java.util.concurrent.*;

/**
 *
 * CountDownLatch 同步现成用法
 *
 * CountDownLatch是一次性的，计算器的值只能在构造方法中初始化一次，之后没有任何机制再次对其设置值，当CountDownLatch使用完毕后，它不能再次被使用。
 *
 * @author  guoxi@tg-hd.com
 * @since 2022/7/6 16:40
 *
 */
public class OrderServiceDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread: Success to place an order");

        int count = 3;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        Executor executor = Executors.newFixedThreadPool(count);
        executor.execute(new MessageTask("email", countDownLatch));
        executor.execute(new MessageTask("wechat", countDownLatch));
        executor.execute(new MessageTask("sms", countDownLatch));

        // 主线程阻塞，等待所有子线程发完消息
        countDownLatch.await();
        // 所有子线程已经发完消息，计数器为0，主线程恢复
        System.out.println("main thread: all message has been sent");
    }

    static class MessageTask implements Runnable {
        private String messageName;
        private CountDownLatch countDownLatch;

        public MessageTask(String messageName, CountDownLatch countDownLatch) {
            this.messageName = messageName;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                // 线程发送消息
                System.out.println("Send " + messageName);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                // 发完消息计数器减 1
                countDownLatch.countDown();
            }
        }
    }
}