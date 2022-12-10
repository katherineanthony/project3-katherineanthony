import java.util.ArrayList;

public class Person {
    private String name;
    private int birthYear;
    private int deathYear;
    private ArrayList<String> noteworthyEvents;
    private int index;
    private String marriage;

    public Person(String name, int birthYear, int deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        noteworthyEvents = new ArrayList<>();
        this.index = -1;
    }

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        noteworthyEvents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    // add: addEvent() ?

    public void addEvent(int year, String event) {
        noteworthyEvents.add(year + ": " + event);
    }

    public void addMarriage(String person) {
        this.marriage = person;
    }

    @Override
    public String toString() {
        return name + " (" +
                + birthYear + "-" + deathYear + ")" +
                "; " + noteworthyEvents + " m. " + marriage; // change this so it prints
                // noteworthy events in a proper way
    }
}
