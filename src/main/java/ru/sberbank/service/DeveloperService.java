package ru.sberbank.service;

import ru.sberbank.data.Developer;

import java.util.ArrayList;

public class DeveloperService {
    public ArrayList<Developer> list;

    public DeveloperService() {
        this.list = new ArrayList<>();
    }

    public void createDeveloper(int id, String firstName, String secondName) {
        if((firstName == null || firstName.isEmpty()) || (secondName == null  || secondName.isEmpty())) {
            throw new IllegalStateException("Incorrect params, Developer not created");
        }
        list.add(new Developer(id, firstName, secondName));
    }

    public Developer getDeveloper(String firstName, String secondName) {
        for (Developer t: list)  {
            if(firstName.equalsIgnoreCase(t.firstName) && secondName.equalsIgnoreCase(t.secondName)) {
                return t;
            }
        }
        throw new IllegalStateException("Developer not found");
    }

    public ArrayList<Developer> getFreeDevelopers() {
        ArrayList<Developer> freeDevelopers = new ArrayList<>();
        for (Developer n: list) {
            if(n.isFree) {
                freeDevelopers.add(n);
            }
        }
        if (freeDevelopers.isEmpty()) {
            throw new IllegalStateException("No free Developers");
        }
        return freeDevelopers;
    }

}