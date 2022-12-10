public class UserInterface {

    public static void printRoosevelts(FamilyTree familyTree) {
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
        FamilyTree roosevelts = new FamilyTree();
        printRoosevelts(roosevelts);
    }
}
