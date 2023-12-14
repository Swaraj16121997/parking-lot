package models;

// this is a base entity class which has all those common fields which are required in all the entities
public abstract class Base {    // abstract class because we don't want to create an object of this class
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
