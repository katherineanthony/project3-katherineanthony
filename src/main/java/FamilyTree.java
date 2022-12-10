import java.util.ArrayList;
import java.util.HashMap;

/**
 * FamilyTree holds the information for all the people in one family.
 */
public class FamilyTree {

    private final HashMap<String, Person> people;
    private final ArrayList<Integer> disjointSet;
    private final ArrayList<ArrayList<Person>> adjacencyList;

    /**
     * Constructor for class initializes people, disjointSet and adjacencyList
     */
    public FamilyTree() {
        people = new HashMap<>();
        disjointSet = new ArrayList<>();
        adjacencyList = new ArrayList<>();
    }

    /**
     * This method adds a person to the family tree by taking their name and
     * years of birth and death. It gives them a disjointSet/ArrayList vertex
     * and puts them into the HashMap of people.
     *
     * @param toBeAdded person
     * @param birthYear of person
     * @param deathYear of person
     */
    public void addPerson(String toBeAdded, int birthYear, int deathYear) {
        Person person = new Person(toBeAdded, birthYear, deathYear);
        int vertex = disjointSet.size();
        person.setIndex(vertex);
        disjointSet.add(-1);
        ArrayList<Person> tempList = new ArrayList<>();
        adjacencyList.add(vertex, tempList);
        people.put(toBeAdded, person);
    }

    /**
     * This constructor is the same as the other except takes no death year
     * in the case that the person is still living.
     *
     * @param tobeAdded person
     * @param birthYear of person
     */
    public void addPerson(String tobeAdded, int birthYear) {
        Person person = new Person(tobeAdded, birthYear);
        int vertex = disjointSet.size();
        person.setIndex(vertex);
        disjointSet.add(-1);
        ArrayList<Person> tempList = new ArrayList<>();
        adjacencyList.add(vertex, tempList);
        people.put(tobeAdded, person);
    }

    /**
     * Finds the person from the HashMap and then adds the event
     * to that person.
     *
     * @param person to add event to
     * @param event description
     * @param year of event
     */
    public void addEvent(String person, String event, int year) {
        Person toBeAddedTo = people.get(person);
        toBeAddedTo.addEvent(year, event);
    }

    /**
     * Updates the disjoint set values so that we can later find the root. This method
     * loops until the parent is found and updates values accordingly.
     *
     * @param parent person
     * @param child person
     */
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

    /**
     * Method unions people according to their relationships, and adds them to the
     * adjacencyList as necessary. Marriage is a special case because married people
     * become "one" person --> aka are on the same level.
     * @param person1 in the relationship
     * @param person2 in the relationship
     * @param relationship type
     */
    public void addRelationship(String person1, String person2, String relationship) {
        Person p1 = people.get(person1);
        Person p2 = people.get(person2);

        if (relationship.compareToIgnoreCase("married") == 0)
            p2.addMarriage(person1);
        if (relationship.compareToIgnoreCase("parent") == 0) {
            union(p1, p2);
            adjacencyList.get(p1.getIndex()).add(p2);
        }
        if (relationship.compareToIgnoreCase("child") == 0) {
            union(p2, p1);
            adjacencyList.get(p2.getIndex()).add(p1);
        }
    }

    /**
     * Method traces the tree recursively and prints out the tree in order.
     * Beginning with the root node, it prints no indents but increases as the
     * generations increase. It recursively calls for each generation if there
     * are children of children.
     *
     * @param curr person
     * @param numIndents to print
     */
    public void printTree(Person curr, int numIndents) {
        for (int i = 0; i < adjacencyList.get(curr.getIndex()).size(); i++) {
            for (int j = 0; j < numIndents; j++)
                System.out.print("  ");
            System.out.println(adjacencyList.get(curr.getIndex()).get(i));
            int newIndents = numIndents + 1;
            if (adjacencyList.get(curr.getIndex()).size() > 0)
                printTree(adjacencyList.get(curr.getIndex()).get(i), newIndents);
        }
    }

    /**
     * Method initializes variables needed for printTree() and finds the root from
     * the disjointSet. Then, it finds the root (with only the root's index) from
     * people, and then passes that to printTree().
     */
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
        Person curr = root;
        int numIndents = 0;
        printTree(curr, numIndents);
    }
}
