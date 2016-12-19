#Usage

Create a list of `Path`
```java
List<Path> list = new ArrayList();
```

Add a new `Path` for every directed edge
```java
// Path(src, dest, weight)

list.add(new Path('A', 'C', 4));
list.add(new Path('A', 'B', 6));
list.add(new Path('B', 'C', 2));
list.add(new Path('B', 'D', 2));
list.add(new Path('C', 'D', 1));
list.add(new Path('C', 'E', 2));
list.add(new Path('E', 'D', 1));
list.add(new Path('E', 'F', 3));
list.add(new Path('D', 'F', 7));
```

Instantiate a `DijkstraAlgorithm` object using the `list`
```java
DijkstraAlgorithm object = new DijkstraAlgorithm(list);
```

Use the `object` to find the shortest path from one vertex to another
```java
List<Path> result = object.compute('A', 'F');

for (Path path : result)
{
    System.out.println(path.getSource() + " -> " + path.getDestination() + " (" + path.getWeight() + ")");
}
```

Result:
```
A -> C (4)
C -> D (5)
D -> F (12)
```