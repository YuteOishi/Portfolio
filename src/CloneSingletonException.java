import java.util.Scanner;
import java.util.InputMismatchException;

public class CloneSingletonException {	
	public static void main(String[] args){
		
		 //-------------------------------------↓クローンの例-----------------------------------------
	     CloneSample sample = new CloneSample();
	     sample.field1 ="B";
	     CloneSample cloneSample = sample.clone();
	     System.out.println(sample.getClass().getSimpleName());
	     System.out.println(cloneSample.field1);
	     
	     //-------------------------------------↓シングルトンの例------------------------------------------
	     //SingletonSample singletonsample1 = new SingletonSample();　は実行不可（エラー）
	     
	     //sample2にシングルトンを入れ、値を変更してsample3にシングルトンを入れると、変更された値のインスタンスが入る
	     SingletonSample singletonSample2 = SingletonSample.getInstance();
	     System.out.println(singletonSample2.field1);
	     singletonSample2.field1 = "B";
	     SingletonSample singletonSample3 = SingletonSample.getInstance();
	     
	     //staticなインスタンスなので、field1="B"になったインスタンスが呼び出される
	     System.out.println(singletonSample3.field1);
	     
	     //----------------------------------------↓例外処理の例---------------------------------------
	     int a,b;
	     int[] num;
	     num = new int[10];
	     try {
	    	 System.out.println("どの配列に代入するか(0~9を入力)");
	    	 a = getNum();
	    	 System.out.println("何の値を代入するか(0以上)");
	    	 b = getNum();
	    	 if(b < 0){
	    		 throw new IllegalArgumentException();
		    	}
	    	 num[a] = b;
	     }
	     catch(ArrayIndexOutOfBoundsException e) { 
	    	 System.out.println("配列外を参照しているエラーが発生");
	     }catch(InputMismatchException e) {
	    	 System.out.println("型が違うエラー発生");
	     }catch(IllegalArgumentException e) {
	    	 System.out.println("値が負の値なのでエラー発生");
	     }
	}
	//2つのエラー発生時の対応について、呼出し側に一任する
	private static int getNum() throws ArrayIndexOutOfBoundsException, InputMismatchException {
		try (Scanner scanner = new Scanner(System.in)) {
			return scanner.nextInt();
		}
	}
	
}

class CloneSample implements Cloneable {
 String field1 = "A";
 String field2;
 
  @Override
 public CloneSample clone(){ 
     CloneSample cloneSample = new CloneSample();
     cloneSample.field1 = this.field1;
     cloneSample.field2 = this.field2;
     return cloneSample;
     }
  }

class SingletonSample {
	String field1 = "A";
	String field2;
	//staticメソッド（getInstance)で使用できるように、staticなインスタンスにする
	private static SingletonSample singletonSample = new SingletonSample();
	
	//Class1内でインスタンス無しで呼び出せるようにstaticメソッドにする
    public static SingletonSample getInstance() {
        return singletonSample;
        }
    }

