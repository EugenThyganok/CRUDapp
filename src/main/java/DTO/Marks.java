package DTO;

/**
 * Created by Eugen on 7/7/2017.
 */
public class Marks {
    private int id;
    private int markNumber;

    public Marks(int id, int markNumber) {
        this.id = id;
        this.markNumber = markNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarkNumber() {
        return markNumber;
    }

    public void setMarkNumber(int markNumber) {
        this.markNumber = markNumber;
    }
}
