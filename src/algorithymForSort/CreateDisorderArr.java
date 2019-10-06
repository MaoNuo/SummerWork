package algorithymForSort;
import java.util.ArrayList;
import java.util.Random;

public class CreateDisorderArr extends ArrayList<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateDisorderArr(int n)
	{
		super();
		Random rand = new Random();
		boolean[] bool = new boolean[n];
		int num = 0;
		
		for(int i = 0 ; i < n ; i++ )
		{
			do {
				num = rand.nextInt(n);
			} while(bool[num]);
			bool[num] = true;
			this.add(num + 1);
		}		
	}
	
	public void resetArr()
	{
		Random rand = new Random();
		boolean[] bool = new boolean[this.size()];
		int num = 0;
		
		for(int i = 0 ; i < this.size() ; i++ )
		{
			do {
				num = rand.nextInt(this.size());
			} while(bool[num]);
			bool[num] = true;
			this.set(i, num + 1);
		}		
	}
	
	public void printArr()
	{
		for( int i = 0 ; i < this.size() ; i ++ )
		{
			System.out.print(this.get(i) + " ");
		}
	}
}
