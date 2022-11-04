public class Thread1 {
    public static void main(String[] args) {
    	int a = 10;
    	int b = 10;
    	System.out.println(a++);
    	System.out.println(++b);
    	Plus plus = new Plus(1000);
        ThreadA threadA = new ThreadA(plus,100);			// ThreadA、Bを継承
        ThreadB threadB = new ThreadB(plus,100);
        threadA.start();
        //このjoinかClassPlusのsynchronizedのどちらかがあれば同期される
        try {
            threadA.join(); // 終了を待つ
          } catch (InterruptedException e) {}
        threadB.start();
    }
}

class ThreadA extends Thread {
	private Plus plus;
	int num;
	ThreadA(Plus p, int n){
		plus = p;
		num = n;
	}
	@Override
	public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("こんにちは！" + i);
        }
        plus.plusNum(num);
    }
}

class ThreadB extends Thread {
	private Plus plus;
	int num;
	ThreadB(Plus p, int n){
		plus = p;
		num = n;
	}
	@Override
    public void run() {
        for (int i = 0; i < 10; i++) {
        	if(i==5) {
        	try {
                Thread.sleep(100);
            } catch (InterruptedException e) { }
        	}
            System.out.println("HELLO！" + i);
        }
        System.out.println("----------------------------------------");
        plus.plusNum(num);
    }
}

class Plus {
	int origin;
	Plus(int n){
		origin = n;
	}
	//synchronizedかClass1のjoinのどちらかがあれば同期される
	public synchronized void plusNum(int num) {
		origin += num;
		try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
		System.out.println(origin);
	}
	
}