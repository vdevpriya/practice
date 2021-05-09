package datastructures;
import java.util.Comparator;

public class Vendor implements Comparator<Vendor>, Cloneable{
	public int st;
	public int et;
	public int p;
	Vendor()
	{
		
	}
	Vendor(int s,int e,int p)
	{
		this.st = s;
		this.et=e;
		this.p=p;
	}
	@Override
	public int compare(Vendor o1, Vendor o2) {
		// TODO Auto-generated method stub
		if(o1.st<o2.st)
			return -1;
		if(o1.st>o2.st)
			return 1;
		else 
		{
			if(o1.et<o2.et)
				return -1;
			if(o1.et>o2.et)
				return 1;
			else
				return 0;
		}
	}
	
	@Override
	protected
	Object clone()
	{
		try
		{
			Vendor v = new Vendor();
			v = (Vendor) super.clone();
			v.st=this.st;
			v.et=this.et;
			v.p=this.p;
			return v;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}


