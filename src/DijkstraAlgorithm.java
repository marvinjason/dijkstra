
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraAlgorithm
{
    private final List<Path> graph;
    private List<Path> shortestPath;
    private Map distance;
    
    public DijkstraAlgorithm(List<Path> graph)
    {
        this.graph = graph;
    }
    
    public List<Path> compute(char start, char end)
    {
        List<Path> list = new ArrayList();
        list.addAll(graph);
        shortestPath = new ArrayList();
        distance = new HashMap();
        distance.put(start, new Pair(0, '\0'));
        compute(start, end, list);
        generateShortestPath(start, end);
        
        return shortestPath;
    }
    
    private void compute(char source, char destination, List<Path> graph)
    {
        Path bestPath = null;
        
        for (Path path : graph)
        {
            if (path.getSource() == source)
            {
                int pathVal = path.getWeight() + ((Pair) distance.get(source)).getValue();
                
                if (!distance.containsKey(path.getDestination()))
                {
                    distance.put(path.getDestination(), new Pair(pathVal, path.getSource()));
                }
                else
                {
                    if (((Pair) distance.get(path.getDestination())).getValue() > pathVal)
                    {
                        distance.remove(path.getDestination());
                        distance.put(path.getDestination(), new Pair(pathVal, path.getSource()));
                    }
                }
                
                if (bestPath == null)
                {
                    bestPath = path;
                }
                else
                {
                    if (((Pair) distance.get(bestPath.getDestination())).getValue() > ((Pair) distance.get(path.getDestination())).getValue())
                    {
                        bestPath = path;
                    }
                }
            }
        }
        
        List<Path> remove = new ArrayList();
        
        for (Path path : graph)
        {
            if (path.getSource() == source || path.getDestination() == source)
            {
                remove.add(path);
            }
        }
        
        graph.removeAll(remove);
        
        if (bestPath != null)
        {
            if (bestPath.getDestination() != destination)
            {
                boolean check = false;
                
                for (Path path : graph)
                {
                    if (path.getSource() == bestPath.getDestination())
                    {
                        check = true;
                    }
                }
                
                if (check)
                {
                    compute(bestPath.getDestination(), destination, graph);
                }
                else if (!graph.isEmpty())
                {
                    compute(graph.get(0).getSource(), destination, graph);
                }
            }
        }
    }
    
    private void generateShortestPath(char start, char end)
    {
        Pair pair = (Pair) distance.get(end);
        
        shortestPath.add(new Path(pair.getSource(), end, pair.getValue()));
        
        while (pair.getSource() != start)
        {
            char c = pair.getSource();
            pair = (Pair) distance.get(pair.getSource());
            shortestPath.add(new Path(pair.getSource(), c, pair.getValue()));
        }
        
        Collections.reverse(shortestPath);
    }
}
