package Sample.Collections.SetAndSort;

public class myPerson implements Comparable<myPerson> {
    int id;
    String name;

    public myPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(myPerson p) {
        return this.name.compareTo(p.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
