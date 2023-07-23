import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@FunctionalInterface
interface display{
	void show(String msg);
	default int doSum(int a, int b) {return a+b;}
}

@FunctionalInterface
interface Cab{
	void bookCab();
}

interface Display{
	void show();
}


class ListItems{
	private Integer key;
	
	private String value;
	
	public ListItems(Integer key, String value) {
		this.key=key;
		this.value=value;
	}
	
	public Integer getKey() {return key;}
	
	public String getvalue() {return value;}
	
	
}

public class DisplayTest implements display{

	@Override
	public void show(String msg) {
		System.out.println(msg);
		
	}
	
	public static void main(String[] args) {
	
	DisplayTest displayTest=new DisplayTest();
	displayTest.show("Hellow from message method");
	
	System.out.println(displayTest.doSum(5, 6));
	
	Cab cab=new Cab() {
		
		@Override
		public void bookCab() {
			System.out.println("Booking successfull !! Arriving soon");
			
		}
	};
	
	cab.bookCab();
	
	Display display= () -> System.out.println("Welcome");
	
	display.show();
	
	List<Integer> list=Arrays.asList(24,35,45,11,30);
	
	System.out.println("Before sorting");
	
	list.forEach(n -> System.out.println(n));
	
	Collections.sort(list);
	
	System.out.println("After sorting");
	
	list.forEach(n -> {System.out.println(n);});
	
	List<ListItems> listItems=new ArrayList<ListItems>();
	
	listItems.add(new ListItems(1, "I"));
	listItems.add(new ListItems(2, "Love"));
	listItems.add(new ListItems(3, "You"));
	
	
	Map<Integer, String> map=new HashMap<Integer, String>();
	
	listItems.forEach(n -> {
		map.put(n.getKey(), n.getvalue());
	});
	
	// 2463700
	System.out.println(map.hashCode());
	
	BiConsumer<Integer, Integer> biConsumer=(Integer x, Integer y) -> System.out.println(x+y);
	
	biConsumer.accept(5, 6);
	
	
	Predicate<String> predicate= (value) -> value !=null;
	
	System.out.println(predicate.test("Something"));
	
	BiPredicate<Integer, Integer> compare=(n,m) -> n>m;
	
	System.out.println(compare.test(5, 6));
	
	List<String> stringList=Arrays.asList("1","2","3","4");
	
	Function<String, Integer> convertToInteger=Integer::parseInt;
	
	List<Integer> integerList=stringList.stream().map(convertToInteger).collect(Collectors.toList());
	
	System.out.println("List of integers:" +integerList);
	
	Consumer<String> toUpperCase=str -> System.out.println(str.toUpperCase());
	Consumer<String> printLength=str -> System.out.println("Length:" +str.length());
	
	Consumer<String> pipeline=toUpperCase.andThen(printLength);
	
	pipeline.accept("kousik");
	
	
	Predicate<Integer> isEven=num -> num%2==0;
	
	Predicate<Integer> isPositive= num -> num >0;
	
	Predicate<Integer> isEvenPositive=isEven.and(isPositive);
	
	System.out.println(isEvenPositive.test(5));
	
	}

}
