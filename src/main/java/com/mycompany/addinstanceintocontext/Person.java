package com.mycompany.addinstanceintocontext;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
    private String name; 

    private final Parrot parrot;

    public Person() {
        this.parrot = new Parrot("Person with default parrot");
    }

    public Person(String name) {
        this.parrot = new Parrot("Person with default parrot");
        this.name = name;
    }
    
    @Autowired
	public Person(Parrot parrot) {
		this.parrot = parrot;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Parrot getParrot() {
		return parrot;
	}

    @Override
    public String toString() {
        return "Person [name=" + name + ", parrot=" + parrot + "]";
    }
}
