

interface MyInterface{
	void myFunction();
}



public class GFG {
	
	int n=100;
	
	public static void main(String[] args) {
		
		GFG gfg=new GFG();
		
		MyInterface intFace=() ->
		{
			System.out.println(gfg.n);
			gfg.n +=500;
			
			System.out.println(gfg.n);
		};
		
		intFace.myFunction();
	}

}
