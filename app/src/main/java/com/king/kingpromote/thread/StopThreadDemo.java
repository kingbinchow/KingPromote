package com.king.kingpromote.thread;

/**
 * Created by king.zhou on 2016/3/31.
 */
public class StopThreadDemo  extends Thread{

    private volatile boolean isStop = false;
    @Override
    public void run() {
        int i = 0;
        while(!isStop){
            i++;
        }
    }

    public void setStop(boolean stop){
        this.isStop = stop;
    }

// 2. use interrupt to stop thread
//    class MyThread extends Thread{
//        @Override
//        public void run() {
//            int i = 0;
//            while(!isInterrupted() && i<Integer.MAX_VALUE){
//                System.out.println(i+" while循环");
//                i++;
//            }
//        }
//    }
//    MyThread thread = test.new MyThread();
//    thread.start();
//    thread.interrupt();
}