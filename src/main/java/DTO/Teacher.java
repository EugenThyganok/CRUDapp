package DTO;

/**
 * Created by Eugen on 7/7/2017.
 */
public class Teacher {
    private int Id;
    private String name;

    public Teacher(int id, String name, String lastName, int groupdId) {
        this.Id = id;
        this.name = name;
        this.lastName = lastName;
        this.groupdId = groupdId;
    }

    private String lastName;
    private int groupdId;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupdId() {
        return groupdId;
    }

    public void setGroupdId(int groupdId) {
        this.groupdId = groupdId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
