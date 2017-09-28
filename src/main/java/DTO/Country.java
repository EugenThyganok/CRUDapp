package DTO;

import java.sql.Timestamp;

/**
 * Created by Eugen on 9/27/2017.
 */
public class Country {
    private int id;
    private String name;
    private Timestamp time;
    private Timestamp updateTime;
    private String symbolizedName;

   public Country(int id, String name, Timestamp time, Timestamp updateTime, String symbolizedName) {
       this.id = id;
       this.name = name;
       this.time = time;
       this.updateTime = updateTime;
       this.symbolizedName = symbolizedName;
   }

   void getData() {
       System.out.println(id + " " + name + " " + time + " " + updateTime + " " + symbolizedName);
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getSymbolizedName() {
        return symbolizedName;
    }

    public void setSymbolizedName(String symbolizedName) {
        this.symbolizedName = symbolizedName;
    }
}
