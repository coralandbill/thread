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
public class ThreadLocalTest {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue()
        {
            return 0;
        }
    };

    public ThreadLocal<Integer> getThreadLocal()
    {
        return seqNum;
    }

    /**
     * 获取下一个序列值
     * @return
     */
    public int getNextSeqNum()
    {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) throws Exception
    {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();

        TestClient testClient1 = new TestClient(threadLocalTest);
        TestClient testClient2 = new TestClient(threadLocalTest);
        TestClient testClient3 = new TestClient(threadLocalTest);

        testClient1.start();
        Thread.sleep(100);
        testClient2.start();
        Thread.sleep(100);
        testClient3.start();
    }

    private static class TestClient extends Thread{
        private ThreadLocalTest threadLocalTest;

        public TestClient(ThreadLocalTest test)
        {
            this.threadLocalTest = test;
        }

        @Override
        public void run()
        {
            for (int i = 0; i < 3; i ++)
            {
                //每个线程打印3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn[" + threadLocalTest.getNextSeqNum() + "]");
            }
            threadLocalTest.getThreadLocal().remove();//每个线程用完删除
        }
    }

}
