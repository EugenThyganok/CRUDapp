package DTO;

/**
 * Created by Eugen on 7/7/2017.
 */
public class Groups {
    private int Id;
    private String title;
    public Groups(int id, String title) {
        Id = id;
        this.title = title;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
