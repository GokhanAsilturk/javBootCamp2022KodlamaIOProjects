package kodlama.ioDay4.Kodlama.io.Devs.Entities.Concretes;

import kodlama.ioDay4.Kodlama.io.Devs.Entities.Abstracts.Entity;

public class Language implements Entity {

    private String name;
    private int id;

    public Language(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
