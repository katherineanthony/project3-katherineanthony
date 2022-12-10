import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Person {
    private String name;
    private int birthYear;
    private int deathYear;
    private ArrayList<String> noteworthyEvents;
    private HashMap<Integer, String> events;
    private int index;
    private String marriage;

    /**
     * Constructor for Person, takes a name, birthYear and deathYear. Initializes
     * those variables and noteworthyEvents.
     *
     * @param name of person
     * @param birthYear of person
     * @param deathYear of person
     */
    public Person(String name, int birthYear, int deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        noteworthyEvents = new ArrayList<>();
        events = new HashMap<>();
    }

    /**
     * Constructor for Person without deathYear. Initializes the same variables as
     * the above constructor.
     *
     * @param name of person
     * @param birthYear of person
     */
    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        noteworthyEvents = new ArrayList<>();
        events = new HashMap<>();
    }

    /**
     * Sets the index of the person in the disjoint set.
     *
     * @param index in the disjoint set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Returns the index of the person in the disjoint set.
     *
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Method adds event to the ArrayList of events with the year and description.
     *
     * @param year of event
     * @param event description
     */
    public void addEvent(int year, String event) {
        noteworthyEvents.add(year + ": " + event);
        events.put(year, event);
    }

    /**
     * Method adds marriage (spouse's name) to the marriage variable.
     *
     * @param person that is spouse
     */
    public void addMarriage(String person) {
        this.marriage = person;
    }

    public void sortEvents() {
        int[] allyears = new int[events.keySet().size()];
        int index = 0;
        for (int key : events.keySet())
            allyears[index++] = key;
        for (int i = 1; i < allyears.length; i++) {
            int temp = allyears[i];
            int j = i - 1;
            while (j >= 0 && temp < allyears[j]) {
                allyears[j + 1] = allyears[j];
                --j;
            }
            allyears[j + 1] = temp;
        }

    }

    @Override
    public String toString() {
        String toBePrinted = "";
        toBePrinted += name + " (" + birthYear + "-";
        if (deathYear != 0) {
            toBePrinted += deathYear;
        }
        toBePrinted += ")";
        sortEvents();
        for (int i = 0; i < noteworthyEvents.size(); i++)
            toBePrinted += "; " + noteworthyEvents.get(i);
        if (marriage != null)
            toBePrinted += " m. " + marriage;
        return toBePrinted;
    }
}
