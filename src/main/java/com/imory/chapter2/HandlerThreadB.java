package com.imory.chapter2;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/11/10
 */
public class HandlerThreadB implements Runnable {
    public void run()
    {
        int number0 = Integer.parseInt("TTT");
    }

    public static void main(String[] args)
    {
        HandlerThreadB handlerThreadB = new HandlerThreadB();
        Thread thread = new Thread(handlerThreadB);
        thread.setUncaughtExceptionHandler(new ExceptionHandlerThreadB());
        thread.start();
    }
}
