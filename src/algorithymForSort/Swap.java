package algorithymForSort;

public class Swap {

	public void swap (SquarePaint square1,SquarePaint square2)
	{
		int temp = 0;
		temp = square1.getValue();
		square1.setValue(square2.getValue());
		square2.setValue(temp);
	}
}
