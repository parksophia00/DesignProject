package dasher;

public class HP {
	
	private int value;
	
	public HP(int temp)
	{
		value = temp;
	}
	
	public void Display()
	{
		
	}
	
    public void HPMinus(int damage)
    {
    	value = value-damage;
    }
    
    public void HPAdd(int heal)
    {
    	value = value-heal;
    }
    
    public int getHP()
    {
    	return value;
    }
    
    public String toString()
    {
    	return "HP: " + Integer.toString(value);
    }

}
