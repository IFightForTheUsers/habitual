package habitual.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Habit {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(columnDefinition = "boolean default false")
    private boolean monday;
    @Column(columnDefinition = "boolean default false")
    private boolean tuesday;
    @Column(columnDefinition = "boolean default false")
    private boolean wednesday;
    @Column(columnDefinition = "boolean default false")
    private boolean thursday;
    @Column(columnDefinition = "boolean default false")
    private boolean friday;
    @Column(columnDefinition = "boolean default false")
    private boolean saturday;
    @Column(columnDefinition = "boolean default false")
    private boolean sunday;

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

    public boolean isMonday() {
        return monday;
    }

    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    public boolean isThursday() {
        return thursday;
    }

    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }

    public boolean isFriday() {
        return friday;
    }

    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }

    public boolean isSunday() {
        return sunday;
    }

    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }
}
