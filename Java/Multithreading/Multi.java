package Multithreading;

public class Multi{
    private long counter;

    public long getcounter(){
        return this.counter;
    }

    public Multi(){
        this.counter = 0;

        Thread t1 =  new Thread(new Test());
        Thread t2 =  new Thread(new Test());
        Thread t3 =  new Thread(new Test());
        Thread t4 =  new Thread(new Test());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    private class Test implements Runnable{
		
		public void run() {
            while(true){
                synchronized (this){
                    Multi.this.counter++;	
                }
            }
		}
	}
}