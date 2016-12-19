
public class Path
{
    private char source;
    private char destination;
    private int weight;
    
    public Path(char source, char destination, int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    public char getSource()
    {
        return source;
    }
    
    public char getDestination()
    {
        return destination;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public void setSource(char source)
    {
        this.source = source;
    }
    
    public void setDestination(char destination)
    {
        this.destination = destination;
    }
    
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
}
