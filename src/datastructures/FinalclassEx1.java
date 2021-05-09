package datastructures;

public final class FinalclassEx1 {

	public final String name;
	final int age;
	
	public FinalclassEx1(String n,int age)
	{
		this.name = n;
		this.age = age;
	}  
	public static void main(String arg[])
	{
		FinalclassEx1 a1 = new FinalclassEx1("a", 1);
		FinalclassEx1 a2 = new FinalclassEx1("a", 1);
	}
}
