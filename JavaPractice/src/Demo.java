import java.util.ArrayList;
import java.util.Collections;

public class Demo {
	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		al.add(205);
        al.add(102);
        al.add(98);
        al.add(275);
        al.add(203);
        
        System.out.println("Element before sorting "+al);
        
        Collections.sort(al,(o1, o2) -> (o1 >o2) ? -1: (o1<o2)? 1:0);
        
        System.out.println("Afer sort:" +al);
        
        new Thread(() -> {
        	System.out.println("New thread created");
        }).start();
	}

}
