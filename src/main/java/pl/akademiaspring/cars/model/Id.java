package pl.akademiaspring.cars.model;

public class Id {

    private long id;

    public Id() {
    }

    public Id (long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
