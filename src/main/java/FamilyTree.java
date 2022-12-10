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
            p2.addMarriage(person1);
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

    public void printTree(boolean done, Person curr, int numIndents) {
        for (int i = 0; i < adjacencyList.get(curr.getIndex()).size(); i++) {
            for (int j = 0; j < numIndents; j++)
                System.out.print("  ");
            System.out.println(adjacencyList.get(curr.getIndex()).get(i));
            int newIndents = numIndents + 1;
            if (adjacencyList.get(curr.getIndex()).size() > 0)
                printTree(false, adjacencyList.get(curr.getIndex()).get(i), newIndents);
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
        Person root = null;
        for (Person p: people.values()) {
            if (p.getIndex() == index)
                root = p;
        }
        System.out.println(root);
        boolean done = false;
        Person curr = root;
        int numIndents = 0;
        printTree(done, curr, numIndents);
    }

    @Override
    public String toString() {
        return " " + people; // change this
    }
}
