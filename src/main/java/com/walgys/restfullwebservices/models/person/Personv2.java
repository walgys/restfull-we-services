package com.walgys.restfullwebservices.models.person;

public class Personv2 {
    private Name name;

    public Personv2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Personv2{" +
                "name=" + name +
                '}';
    }
}
