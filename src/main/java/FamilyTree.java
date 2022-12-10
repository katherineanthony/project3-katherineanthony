import java.util.ArrayList;
import java.util.HashMap;

public class FamilyTree {
    // can use an adjacency matrix to contain it?
    // will be both directed and weighted
    // to describe levels

    private HashMap<String, Person> people;
    private ArrayList<Integer> disjointSet; // default value is 0, which is what we want
    private ArrayList<ArrayList<Person>> adjacencyList;

    // create a DISJOINT set because then you could show familial relationships more easily?

    public FamilyTree() {
        people = new HashMap<>();
        disjointSet = new ArrayList<>();
        adjacencyList = new ArrayList<>();
    }

    public void addPerson(String toBeAdded, int birthYear, int deathYear) {
        Person person = new Person(toBeAdded, birthYear, deathYear);
        int vertex = disjointSet.size();
        person.setIndex(vertex);
        disjointSet.add(-1);
        ArrayList<Person> tempList = new ArrayList<>();
        adjacencyList.add(vertex, tempList);
        people.put(toBeAdded, person);
    }

    public void addPerson(String tobeAdded, int birthYear) {
        Person person = new Person(tobeAdded, birthYear);
        int vertex = disjointSet.size();
        person.setIndex(vertex);
        disjointSet.add(-1);
        ArrayList<Person> tempList = new ArrayList<>();
        adjacencyList.add(vertex, tempList);
        people.put(tobeAdded, person);
    }

    public void addEvent(String person, String event, int year) {
        Person toBeAddedTo = people.get(person);
        toBeAddedTo.addEvent(year, event);
    }

    public void union(Person parent, Person child) {
        int parentIndex = parent.getIndex();
        int childIndex = child.getIndex();
        while (parentIndex > -1) {
            if (disjointSet.get(parentIndex) > -1)
                parentIndex = disjointSet.get(parentIndex);
            else {
                disjointSet.set(childIndex, parent.getIndex());
                disjointSet.set(parentIndex, disjointSet.get(parentIndex) - 1);
                parentIndex = -1;
            }
        }
    }

    public void addRelationship(String person1, String person2, String relationship) {
        Person p1 = people.get(person1);
        Person p2 = people.get(person2);

        if (relationship.compareToIgnoreCase("married") == 0) {

        }
        if (relationship.compareToIgnoreCase("parent") == 0) {
            union(p1, p2);
            adjacencyList.get(p1.getIndex()).add(p2);
        }
        if (relationship.compareToIgnoreCase("child") == 0) {
            union(p2, p1);
            adjacencyList.get(p2.getIndex()).add(p1);
        }
    }

    public void traceTree() {
        int smallestIndex = 10000;
        int index = 0;
        for (int i = 0; i < disjointSet.size(); i++) {
            if (disjointSet.get(i) < smallestIndex) {
                smallestIndex = disjointSet.get(i);
                index = i;
            }
        }
        //System.out.println("smallest: " + smallestIndex + " i: " + index);

        //System.out.println("root's children: " + adjacencyList.get(index));
        Person root = null;
        // do a recursive call on those children to print them all out
        for (Person p: people.values()) {
            if (p.getIndex() == index)
                root = p;
        }
        System.out.println(root);
        boolean done = false;
        Person curr = root;
        while (!done) {
            if (adjacencyList.get(curr.getIndex()).size() == 0) {
                done = true;
            }
            else {
                Person temp = adjacencyList.get(curr.getIndex()).get(0);
                for (int i = 0; i < adjacencyList.get(curr.getIndex()).size(); i++) {
                    if (adjacencyList.get(curr.getIndex()).get(i) != null)
                        System.out.println(adjacencyList.get(curr.getIndex()).get(i));
                }
                curr = temp;
            }
        }
    }

    @Override
    public String toString() {
        return " " + people; // change this
    }
}
