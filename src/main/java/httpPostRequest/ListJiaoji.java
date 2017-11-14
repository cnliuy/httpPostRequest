package httpPostRequest;

import java.util.ArrayList;
import java.util.List;
 

public class ListJiaoji {
	/**
	 * 取得两个List的交集，retainAll()方法 
	 * */
	public static void main(String[] args) {
		List<Long> list1 = new ArrayList<Long>();
		List<Long> list2 = new ArrayList<Long>();
		   list1.add(1L);
		   list1.add(3L);
		   list1.add(6L);
		   list1.add(4L);
		   list2.add(8L);
		   list2.add(2L);
		   list2.add(3L);
		   list2.add(1L);
		   list1.retainAll(list2);
		   System.out.print(list1);
		   


	}

}
