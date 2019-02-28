import org.junit.Test;

/**
 * @Description
 * @Copyright (C), 2018~2019
 * @Encoding UTF-8
 * @Author: Homee Hoo
 * @Version: 1.0
 * @Date: 2019-02-28 14:56
 */
public class Mybase {
    private long count = 0;

    private void add10K() {
        int idx = 0;
        while(idx++ < 10000000) {
            count += 1;
        }
        System.out.println("---"+count);
    }


    @Test
    public void calc() {
        final Mybase test = new Mybase();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(()->{
            test.add10K();
        });
        Thread th2 = new Thread(()->{
            test.add10K();
        });
//         启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("final2 ----------"+test.count);
    }

}
