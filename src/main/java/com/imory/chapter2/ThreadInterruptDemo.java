package com.imory.chapter2;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/11/7
 */
public class ThreadInterruptDemo implements Runnable{
    public void run()
    {
        boolean stop = false;
        /*while (!stop)
        {
            System.out.println("My Thread is running....");
            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time < 1000))
            {
                //让该循环持续一段时间，使用上面的话打印次数少点
            }
            //demo2
            if(Thread.currentThread().isInterrupted())
            {
                //需要线程本身去处理一下它的终止状态
                System.out.println("isInterrupted:" + Thread.currentThread().isInterrupted());
                break;
            }
            System.out.println("My Thread exiting under request....");
        }*/
        while (!stop)
        {
            System.out.println("My Thread is running....");
            try
            {
                Thread.sleep(3L);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
                break;
            }
        }
        System.out.println("My Thread exiting under request....");
    }

    public static void main(String [] args) throws InterruptedException
    {
        Thread thread = new Thread
        (new ThreadInterruptDemo(),"InterruptDemo Thread");
        System.out.println("Starting thread.....");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Interrupting thread...");
        thread.interrupt();
        System.out.println("线程是否终端：" + thread.isInterrupted());
        Thread.sleep(3000);
        System.out.println("Stopping  application....");
    }
}
