import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {

interface FuncInterface{
	void add(int x,int y);
}

interface FuncInterfaceWithZeroParamter{
	void add();
}

interface FuncInter1{
	int operation(int a, int b);
}

interface FuncInter2{
	void sayMessage(String message);
}

	private int operate(int a,int b,FuncInter1 func) {
		return func.operation(a, b);
	}
	
	public static void main(String[] args) {
		
		FuncInterface addInterface=(int x, int y)-> System.out.println(x+y);
		
		addInterface.add(5, 6);
		
		FuncInterfaceWithZeroParamter zeroParamter=()->System.out.println("Kousik"); 
		
		zeroParamter.add();
		
		ArrayList<Integer> arrl=new ArrayList<Integer>();
		
		arrl.add(1);
		arrl.add(2);
		arrl.add(3);
		arrl.add(4);
		
		arrl.forEach(n->{
			if(n%2==0) {
				System.out.println(n +" is an even number");
			}
		});
		
		FuncInter1 add=(int a, int b) -> a+b;
		
		FuncInter1 mul=(int a, int b) -> a * b;
		
		Test test=new Test();
		
		System.out.println("Addition is :" +test.operate(5, 5, add));
		
		
		Consumer<Integer> numbers= num -> System.out.println(num);
		
		arrl.forEach(numbers);
		
		ArrayList<String> fruits=new ArrayList<String>();
		
		fruits.add("Banana");
		fruits.add("Guava");
		fruits.add("Pineapple");
		fruits.add("Apple");
		
		System.out.println("Element is arraylist are:" +fruits);
		
		HashMap<String,Integer> ress=new HashMap<String, Integer>();
		
		
		fruits.forEach(str -> ress.put(str,str.length()));
		
		
		System.out.println(ress);
		
		HashMap<String, Integer> res=fruits.stream().collect(Collectors.toMap(Function.identity(),String::length,(e1,e2) -> e1, HashMap::new));
		
		System.out.println("Elements is hashmap are:" +res);
		
	}

}
