import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Set;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import java.util.Queue;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class ListClass {
    public static void main(String[] args) {
    	queuePractice();
    	setPractice();
    	mapPractice();
    	listPractice();
    }
    
    private static void queuePractice() {
    	Queue<String> queue = new ArrayDeque<>();
    	queue.add("あ");
    	queue.add("い");
    	queue.add("う");
    	queue.add("え");
    	queue.add("お");
    	queue.forEach(i -> System.out.print(i)); 
    	nl();
    	System.out.println(queue.poll()); 
    	queue.forEach(i -> System.out.print(i));
    	nl();
    	System.out.println(queue.peek());
    	bar();
    	
    	Stack<String> stack = new Stack<>();
    	stack.add("あ");
    	stack.add("い");
    	stack.add("う");
    	stack.add("え");
    	stack.add("お");
    	stack.forEach(i -> System.out.print(i)); 
    	nl();
    	System.out.println(stack.pop()); 
    	stack.forEach(i -> System.out.print(i));
    	nl();
    	System.out.println(stack.peek());
    	bar();
    	
    	Deque<String> deque = new ArrayDeque<>();
    	deque.add("あ");
    	deque.addFirst("い");
    	deque.add("う");
    	deque.offer("え");
    	deque.addFirst("お");
    	deque.forEach(i -> System.out.print(i)); 
    	nl();
    	System.out.println(deque.removeLast()); 
    	deque.forEach(i -> System.out.print(i));
    	nl();
    	System.out.println(deque.peekLast());
    	bar();
    	/*Dequeメソッド
    	 * addFirst()、addLast()　　　　追加できないとき例外を返す IllegalStateException
    	 * removeFirst、removeLast()　空のとき例外を返す NoSuchElementException
    	 * getFirst()、getLast()　　　空のとき例外を返す NoSuchElementException
    	 * offerFirst()、offerLast()　追加できないときfalseを返す
    	 * pollFirst()、pollLast()　空のときnullを返す
    	 * peekFirst()、peekLast()　空のときnullを返す
    	 */
    }
    

    private static void setPractice() {
    	Set<String> set1 = new HashSet<String>();
    	
        Set<String> set2 = new TreeSet<String>() {
            {
              add("Windows");
              add("4");             
              add("いいい");
              add("macOS");
              add("あああ");
              add("Linux");
              add("1");
              add("ううう");
              add("ううう");
              add("ううう");
            }
        };   
        Set<String> set3 = new LinkedHashSet<String>() {
            {
              add("Windows");
              add("4");             
              add("いいい");
              add("macOS");
              add("あああ");
              add("Linux");
              add("1");
              add("ううう");
              add("ううう");
              add("ううう");
            }
        };   
        set1.add("Windows");
        set1.add("4");             
        set1.add("いいい");
        set1.add("macOS");
        set1.add("あああ");
        set1.add("Linux");
        set1.add("1");
        set1.add("ううう");
        set1.add("ううう");
        set1.add("ううう");
    	set1.forEach(i -> System.out.println(i));
    	bar();
    	set2.forEach(i -> System.out.println(i)); 
    	bar();
    	set3.forEach(i -> System.out.println(i)); 
    	System.out.println(set1.size());
    	bar();
    	/*
    	HashSet:通常のSet、並び順は保証されないため単純に重複を除外する場合に使用
    	LinkedHashSet:挿入順を保証する
		TreeSet：順序はあるが自然順序、もしくはComparatorで独自の並び順を指定
    	*/
    	
    }
    
    private static void mapPractice() {
    	Map<String, Integer> map1 = new HashMap<String, Integer>();
    	Map<String, Integer> map3 = new LinkedHashMap<String, Integer>();
    	Map<String, Integer> map2 = new TreeMap<String, Integer>();
    	map1.put("A", 1500);
    	map1.put("D", 5400);
    	map1.put("C", 1200);
    	map1.put("B", 2800);
    	map1.put(null, 10000);
    	map2.put("A", 1500);
    	map2.put("D", 5400);
    	map2.put("C", 1200);
    	map2.put("B", 2800);
    	//map2.put(null, 10000);  null値はエラー発生 	
    	map3.put("A", 1500);
    	map3.put("D", 5400);
    	map3.put("C", 1200);
    	map3.put("B", 2800);
    	//map3.put(null, 10000);  null値はエラー発生


    	System.out.println(map1.get("B").toString());
    	map1.forEach((key, i) -> System.out.println(key + " " + i.toString()));
    	bar();
    	map2.forEach((key, i) -> System.out.println(key + " " + i.toString()));
    	bar();
    	map3.forEach((key, i) -> System.out.println(key + " " + i.toString()));
    	bar();
    	System.out.println(map1.keySet().toString());	
    	System.out.println(map2.values().toString());	
    	System.out.println(map3.entrySet().toString());	
    	System.out.println(map1.containsKey("A"));
    	System.out.println(map1.containsValue(2000));
    	bar();
    	/*
   	 	HashMap：順番は保証されない
   		TreeMap：キーの順序が保証される
    	*/
    }
    
    private static void listPractice() {
    	//配列の場合は int[] num = new int[];
    	List<Integer> list1 = new ArrayList<Integer>();
    	List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    	List<Integer> list3 = list2.subList(1,4);  //終了インデックスは含まない（1<= sub < 4)、シャローコピーなのでlist2が変わればlist3も変わる
    	Integer[] list4 = list3.toArray(new Integer[list3.size()]);
    	
    	list1.add(6);
        list1.add(2);
        list1.add(4);
        list1.add(5);
        list1.add(3);

        System.out.println(list1.size());
        System.out.print(list1.toString());
        nl();
        for(Integer i : list1) {
        	System.out.print(i.toString()); //拡張for文 　for(型 変数 : リスト){}
        }
        nl();
        list1.forEach(i -> System.out.print(i.toString())); //forEachメソッド  リスト.forEach(変数 -> 処理)
        nl();
        System.out.print(list1.get(0).toString());
        nl();
        Collections.sort(list1);
        list1.forEach(i -> System.out.print(i.toString()));        
        nl();
        list1.addAll(list2);
        list1.forEach(i -> System.out.print(i.toString()));
        nl();
        list3.forEach(i -> System.out.print(i.toString()));
        nl();
        Arrays.stream(list4).forEach(i -> System.out.print(i.toString()));
      /*isEmptyメソッドはコレクションが空か判定してbooleanで返す
  	　 containsメソッドは特定の値が含まれているか判定してbooleanで返す
  	　　indexOfメソッドは検索して最初にあるインデックス番号を返す
  	　　lastIndexOfメソッドは後ろから検索してインデックス番号を返す
  	　　setメソッドで既に格納されている値を別の値に置き換える
  	　　removeメソッドで要素を削除
  	　　distinctメソッドで重複を無くす
  	　　clearメソッドで要素を全て削除
  	  */
    }
 
    public static void bar() {
    	System.out.println("----------------------------------------------");
    }
    public static void nl() {
    	System.out.println("");
    }
    
    
}


