package com.imory.chapter1;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/11/7
 */
public class ThreadB implements Runnable {
    public void run()
    {
        try
        {
            Thread.sleep(10000L);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        Thread curThread = Thread.currentThread();
        String curThreadName = curThread.getName();
        System.out.println("这是线程的名称:" + curThreadName);
        System.out.println("返回当前线程" + curThreadName + "的线程组中活动线程的数目：" + Thread.activeCount());
        System.out.println("返回该线程" + curThreadName + "的标识符：" + curThread.getId());
        System.out.println("返回线程" + curThreadName + "的优先级：" + curThread.getPriority());
        System.out.println("返回该线程" + curThreadName + "所属的线程组：" + curThread.getThreadGroup());
        System.out.println("测试线程" + curThreadName + "是否处于活动状态：" + curThread.isAlive());
        System.out.println("测试线程" + curThreadName + "是否测试该线程是否为守护线程：" + curThread.isDaemon());

        System.out.println("这是线程B");
    }

    public static void main(String[] args)
    {
        ThreadB threadB = new ThreadB();
        /*new Thread(threadB).start();*/
        for (int i = 0; i < 5; i++)
        {
            new Thread(threadB, "线程名称：(" + i + ")").start();
        }

        Thread threadMain = Thread.currentThread();
        System.out.println("这是主线程");
        System.out.println("这是线程的名称:" + threadMain.getName());
        System.out.println("返回当前线程" + threadMain.getName() + "的线程组中活动线程的数目：" + Thread.activeCount());
        System.out.println("返回该线程" + threadMain.getName() + "的标识符：" + threadMain.getId());
        System.out.println("返回线程" + threadMain.getName() + "的优先级：" + threadMain.getPriority());
        System.out.println("返回该线程" + threadMain.getName() + "所属的线程组：" + threadMain.getThreadGroup());
        System.out.println("测试线程" + threadMain.getName() + "是否处于活动状态：" + threadMain.isAlive());
        System.out.println("测试线程" + threadMain.getName() + "是否测试该线程是否为守护线程：" + threadMain.isDaemon());

        try
        {
            Thread.sleep(10000L);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
