import java.util.HashMap;

/**
 * Person class contains the information for one person
 */
public class Person {
    private final String name;
    private final int birthYear;
    private int deathYear;
    private final HashMap<Integer, String> events;
    private int index;
    private String marriage;

    /**
     * Constructor for Person, takes a name, birthYear and deathYear. Initializes
     * those variables and events.
     *
     * @param name of person
     * @param birthYear of person
     * @param deathYear of person
     */
    public Person(String name, int birthYear, int deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
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
     * Method adds event to the HashMap of events with the year and description,
     * where the year is the key and the description is the value.
     *
     * @param year of event
     * @param event description
     */
    public void addEvent(int year, String event) {
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

    /**
     * Method uses insertion sort to sort events. First it copies over the years
     * from the hashmap of events, and then sorts the years. Then, it sorts and
     * returns the new array, which has the years in order.
     */
    public int[] sortEvents() {
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
        return allyears;
    }

    /**
     * toString for person and their information
     *
     * @return person's information
     */
    @Override
    public String toString() {
        String toBePrinted = "";
        toBePrinted += name + " (" + birthYear + "-";
        if (deathYear != 0) {
            toBePrinted += deathYear;
        }
        toBePrinted += ")";
        int[] years = sortEvents();
        for (int i = 0; i < events.size(); i++)
            toBePrinted += "; " + years[i] + ": " + events.get(years[i]);
        if (marriage != null)
            toBePrinted += " m. " + marriage;
        return toBePrinted;
    }
}
