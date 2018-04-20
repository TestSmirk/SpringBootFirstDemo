package com.testsmirk.queue;

public class PrintTask implements ITask {
    private final int myId;

    public PrintTask(int myId) {
        this.myId = myId;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" my id is : " + myId);
    }
}
