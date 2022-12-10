public class UserInterface {

    /**
     * This is an example method for how family tree works
     * @param familyTree of roosevelts
     */
    public static void printRoosevelts(FamilyTree familyTree) {
        familyTree.addPerson("Roosevelt", 1884, 1962);
        familyTree.addEvent("Roosevelt", "living", 1990);
        familyTree.addEvent("Roosevelt", "vibing", 1982);
        familyTree.addEvent("Roosevelt", "thriving", 1995);
        familyTree.addEvent("Roosevelt", "loving", 1965);
        familyTree.addEvent("Roosevelt", "laughing", 1993);

        familyTree.addPerson("Anna", 1990);
        familyTree.addRelationship("Roosevelt", "Anna", "parent");
        familyTree.addPerson("Louis", 1866, 1955);
        familyTree.addRelationship("Louis", "Anna", "married");
        familyTree.addPerson("Beatrice", 1990, 2009);
        familyTree.addRelationship("Roosevelt", "Beatrice", "child");
        familyTree.addPerson("Bobby", 1990, 2009);
        familyTree.addRelationship("Roosevelt", "Bobby", "parent");
        familyTree.addPerson("Peter John", 1866, 1955);
        familyTree.addRelationship("Peter John", "Beatrice", "parent");
        familyTree.addPerson("Mary Elizabeth", 1866, 1955);
        familyTree.addRelationship("Mary Elizabeth", "Anna", "child");
        familyTree.addPerson("Mary", 1866, 1955);

        familyTree.traceTree();
    }

    public static void main(String[] args) {
        FamilyTree roosevelts = new FamilyTree();
        printRoosevelts(roosevelts);
    }
}
