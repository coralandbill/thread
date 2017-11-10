package com.imory.chapter1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/11/7
 */
public class ThreadC implements Callable<String>{
    public String call()
    {
        //模拟做事停留500l
        try
        {
            Thread.sleep(500L);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("这是线程C");
        return "线程C";
    }

    public static void main(String[] args)
    {
        ThreadC threadC = new ThreadC();
        FutureTask<String> futureTask = new FutureTask<String>(threadC);
        new Thread(futureTask).start();

        System.out.println("这是主线程：begin!");

        try
        {
            System.out.println("得到的返回结果是：" + futureTask.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        System.out.println("这是主线程：end！");
    }
}
