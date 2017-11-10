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
public class ThreadB extends Thread{

    @Override
    public void run()
    {
        for (int i = 0; i < 5; i ++)
        {
            System.out.println("线程B 第" + i + "次执行！");
            try
            {
                Thread.sleep(7);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
