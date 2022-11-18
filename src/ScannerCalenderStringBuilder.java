import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Calendar;


public class ScannerCalenderStringBuilder {

	public static void main(String[] args) {
		
		//-----------------------StringBuilder-----------------------------
		
		//-----------------------Scanner-----------------------------
		File file = new File("C:\\Users\\kchfe\\Downloads\\うん.txt");
		try (Scanner sc = new Scanner(file, "SJIS")){
			System.out.println("ファイルを読み込みました。");
		      while (sc.hasNext()){
		        String str = sc.nextLine();
		        System.out.println(str);
		      }
		    }catch(FileNotFoundException e){
		      System.out.println(e);
		    }
		
		
		//-----------------------Calendar-----------------------------
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.MINUTE));
		cal.set(Calendar.YEAR,2001);
		System.out.println(cal.get(Calendar.YEAR)+" "+(cal.get(Calendar.MONTH)+1)+" "+cal.get(Calendar.DATE));
		cal.set(2005,5,11);
		System.out.println(cal.get(Calendar.YEAR)+" "+(cal.get(Calendar.MONTH)+1)+" "+cal.get(Calendar.DATE));
		cal.add(Calendar.DAY_OF_WEEK, -14);
		System.out.println(cal.get(Calendar.YEAR)+" "+(cal.get(Calendar.MONTH)+1)+" "+cal.get(Calendar.DATE));
	}

}
