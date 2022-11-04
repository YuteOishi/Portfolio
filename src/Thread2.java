public class Thread2 { 
	
	public static final Object obj = new Object();
	
    public static void main(String[] args) {
        ThreadC threadC = new ThreadC();
        ThreadD threadD = new ThreadD();
        Thread C = new Thread(threadC);
        Thread D = new Thread(threadD);
        C.start();
        D.start();
    }
}

class ThreadC implements Runnable {
	@Override
	public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("こんにちは！" + i);
            if(i==20) {
            	try {
            		synchronized (Thread2.obj) {
            			Thread2.obj.wait();
            		}
            	} catch (InterruptedException e) {}
            }
            if(i==80) {
        		synchronized (Thread2.obj) {
        			Thread2.obj.notify();
                	try {
                		synchronized (Thread2.obj) {
                			Thread2.obj.wait();
                		}
                	} catch (InterruptedException e) {}
        		}
            }
        }
    }
}

class ThreadD implements Runnable {
	@Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("HELLO！" + i);
            
            if(i==49) {
        		try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
    	}
            if(i==50) {
            		synchronized (Thread2.obj) {
            			Thread2.obj.notify();
                    	try {
                    		synchronized (Thread2.obj) {
                    			Thread2.obj.wait();
                    		}
                    	} catch (InterruptedException e) {}
            		}
        	}
            
            if(i==100) {
        		synchronized (Thread2.obj) {
        			Thread2.obj.notify();
        		}
            }
        }
	}
}