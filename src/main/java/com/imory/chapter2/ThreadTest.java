package com.imory.chapter2;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/11/8
 */
public class ThreadTest {

    public static void main(String[] args)
    {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.setDaemon(true);

        threadB.start();
        threadA.start();

        Thread threadMain = Thread.currentThread();
        System.out.println("线程A是不是守护线程：" + threadA.isDaemon());
        System.out.println("线程B是不是守护线程：" + threadB.isDaemon());

        System.out.println("线程main 是不是守护线程" + threadMain.isDaemon());
    }
}
