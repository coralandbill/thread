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
public class ThreadA extends Thread{

    @Override
    public void run()
    {
        super.run();

        try
        {
            Thread.sleep(500L);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("这是线程A");
    }

    public static void main(String[] args)
    {
        ThreadA threadA = new ThreadA();
        threadA.start();
        System.out.println("这是主线程:");
    }
}
