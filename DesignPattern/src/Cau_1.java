import java.util.*;
public class Cau_1 {

}
class Person {
    String name;
    Date dob;
    String gender;
    Person spouse;
    List<Person> children = new ArrayList<>();

    public Person(String name, Date dob, String gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public void marry(Person spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }

    public void addChild(Person child) {
        this.children.add(child);
        if (this.spouse != null) {
            this.spouse.children.add(child);
        }
    }

    public boolean isMarried() {
        return this.spouse != null;
    }

    public boolean hasTwoChildren() {
        return this.children.size() == 2;
    }
}

class FamilyTree {
    List<Person> members = new ArrayList<>();

    public void addMember(Person person) {
        this.members.add(person);
    }

    public List<Person> getUnmarriedMembers() {
        List<Person> unmarried = new ArrayList<>();
        for (Person person : members) {
            if (!person.isMarried()) {
                unmarried.add(person);
            }
        }
        return unmarried;
    }

    public List<Person> getCouplesWithTwoChildren() {
        List<Person> couples = new ArrayList<>();
        for (Person person : members) {
            if (person.isMarried() && person.hasTwoChildren()) {
                couples.add(person);
            }
        }
        return couples;
    }
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        // Create some people
        Person james = new Person("James", new Date(), "Male");
        Person hana = new Person("Hana", new Date(), "Female");
        Person ryan = new Person("Ryan", new Date(), "Male");
        Person kai = new Person("Kai", new Date(), "Male");
        Person jennifer = new Person("Jennifer", new Date(), "Female");

        // Add them to the family tree
        familyTree.addMember(james);
        familyTree.addMember(hana);
        familyTree.addMember(ryan);
        familyTree.addMember(kai);
        familyTree.addMember(jennifer);

        // Set up relationships
        james.marry(hana);
        james.addChild(ryan);
        james.addChild(kai);
        kai.marry(jennifer);

        // Test the methods
        List<Person> unmarried = familyTree.getUnmarriedMembers();
        System.out.println("Unmarried people:");
        for (Person person : unmarried) {
            System.out.println(person.name);
        }

        List<Person> couplesWithTwoChildren = familyTree.getCouplesWithTwoChildren();
        System.out.println("Couples with two children:");
        for (Person person : couplesWithTwoChildren) {
            System.out.println(person.name + " and " + person.spouse.name);
        }
    }
};

