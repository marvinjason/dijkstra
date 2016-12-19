
public class Pair
{
    private int value;
    private char source;
    
    public Pair(int value, char source)
    {
        this.value = value;
        this.source = source;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public char getSource()
    {
        return source;
    }
    
    public void setValue(int value)
    {
        this.value = value;
    }
    
    public void setSource(char source)
    {
        this.source = source;
    }
}
