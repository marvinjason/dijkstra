
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Path> list = new ArrayList();
        
        list.add(new Path('A', 'C', 4));
        list.add(new Path('A', 'B', 6));
        list.add(new Path('B', 'C', 2));
        list.add(new Path('B', 'D', 2));
        list.add(new Path('C', 'D', 1));
        list.add(new Path('C', 'E', 2));
        list.add(new Path('E', 'D', 1));
        list.add(new Path('E', 'F', 3));
        list.add(new Path('D', 'F', 7));
        
        DijkstraAlgorithm object = new DijkstraAlgorithm(list);
        list = object.compute('A', 'F');
        
        for (Path path : list)
        {
            System.out.println(path.getSource() + " -> " + path.getDestination() + " (" + path.getWeight() + ")");
        }
    }
}
