public class UserInterface {
    /**
     * Possible implementation:
     * - have a class of "Events" where events are taken as Strings
     *      and are converted into events
     * - have a class of a graph called relationships or family tree
     *      where taking a person, you get all their relationships and
     *      construct a graph
     */

    public static void roosevelts(FamilyTree familyTree) {
        familyTree.addPerson("Roosevelt", 1884, 1962);
        familyTree.addEvent("Roosevelt", "vibes", 1990);
        familyTree.addPerson("Anna", 1990);
        familyTree.addRelationship("Roosevelt", "Anna", "parent");
        familyTree.addPerson("Beatrice", 1990, 2009);
        familyTree.addRelationship("Roosevelt", "Beatrice", "child");
        familyTree.addPerson("Bobby", 1990, 2009);
        familyTree.addRelationship("Roosevelt", "Bobby", "parent");
        familyTree.addPerson("Peter John", 1866, 1955);
        familyTree.addRelationship("Peter John", "Beatrice", "parent");
        familyTree.addPerson("Mary Elizabeth", 1866, 1955);
        familyTree.addRelationship("Mary Elizabeth", "Anna", "child");
        familyTree.traceTree();
    }

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        roosevelts(familyTree);
//        familyTree.addPerson("Roosevelt", 1884, 1962);
//        familyTree.addEvent("Roosevelt", "vibes", 1990);
//        familyTree.addPerson("Anna", 1990);
//        familyTree.addRelationship("Roosevelt", "Anna", "parent");
//        familyTree.addPerson("Beatrice", 1990, 2009);
//        familyTree.addRelationship("Roosevelt", "Beatrice", "child");
//        familyTree.addPerson("Bobby", 1990, 2009);
//        familyTree.addRelationship("Roosevelt", "Bobby", "parent");
//        familyTree.traceTree();
    }
}
