package com.nikandr.spring;


public class Profile {
    private static Integer freeID;
    private Person person;
    private Integer id;

    public Profile(Person person) {
        if (freeID == null) {
            freeID = 0;
        }
        this.person = person;
        this.id = freeID++;
    }

    public void shareProfile(Person otherPerson) {
        System.out.printf("Profile with id: [%d] and owned by person '%s' was shared with '%s'\n",
                id,
                person.getName(),
                otherPerson.getName());
    }

    public void logProfileInfo() {
        System.out.printf("Profile with id: [%d] and owned by person '%s'\n",
                id,
                person.getName());
    }
}
