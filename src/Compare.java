import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class Compare {

	public static void main(String[] args) {
		System.out.println(((Integer)1).compareTo((Integer)2));
		
		Integer[] number = new Integer[] {4,2,7,6,5,3,0,1};
		
		//拡張for文で書出し
		for (int e : number) {System.out.print(e);}
		System.out.println("");ListClass.bar();
		
		//昇順にしたいだけならこれでOK
		Arrays.sort(number);
		for (int e : number) {System.out.print(e);}
		System.out.println("");ListClass.bar();
		
		//降順はこれ
		Arrays.sort(number, Collections.reverseOrder());
		for (int e : number) {System.out.print(e);}
		System.out.println("");ListClass.bar();
		
		//3の倍数が優先＋昇順
		Comparator<Integer> comparator0 = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 % 3 == 0 && o2 % 3 != 0) {
					return -1;
				}
				else {
					return o1.compareTo(o2);
				}
		}
		};
		Arrays.sort(number);
		Arrays.sort(number,comparator0);
		for (int e : number) {System.out.print(e);}
		System.out.println("");ListClass.bar();

		
		//-------------------------------------多次元配列並べ替え---------------------------------------------
		String[][] data = new String[][] {
            { "apple", "3", "1,000" },
            { "cherry", "1", "1,000" },
            { "banana", "1", "300" },
            { "banana", "2", "2,000" },
            { "apple", "2", "300" },
		};
	    
		Map<String, Comparator<String>> orderMap = new HashMap<String, Comparator<String>>();
		
		//Comparatorのインスタンスを作ってすぐにオーバーライド
		orderMap.put("lex", new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		//Comparatorのインスタンスを作ってすぐにオーバーライド
		orderMap.put("num", new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
			}
		});
		
		/*2次元配列用のComparator作成
		*一次元はComparator<String>で複数のString（apple,banana,cherry）を比較して並べ替えインスタンスを作ったが
		*二次元はComparator<String[]>として並べ替えインスタンスを作成 [apple, 3, 1000],[cherry,1,1000]..[]..を比較できる*/
		Comparator<String[]> comparator = new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				int order = orderMap.get("lex").compare(o1[0], o2[0]);
				if(order != 0) {
					return order;
				}
				order = orderMap.get("num").compare(o1[1], o2[1]);
				if(order != 0) {
					return order;
				}
				return 0;
			}
		};

		for(int i=0; i<5; i++) {
			for(int j=0; j<3; j++) {
				System.out.printf("  %-8s", data[i][j]);
			}	
			System.out.println("");
		}
	    
	    ListClass.bar();
	   
	    Arrays.sort(data, comparator);
	    
		for(int i=0; i<5; i++) {
			for(int j=0; j<3; j++) {
				System.out.printf("  %-8s", data[i][j]);
			}	
			System.out.println("");
		}
	    
	      
	      
	}
}


