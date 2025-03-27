package com.mycompany.addinstanceintocontext;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
    private String name; 

    @Autowired
    private Parrot parrot;

    public Person() {
    }
    
	public Person(String name, Parrot parrot) {
        System.out.println("Person constructor");
		this.name = name;
		this.parrot = parrot;
	}

	public Person(String name) {
        this.name = name;
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
	public void setParrot(Parrot parrot) {
		this.parrot = parrot;
	}
    @Override
    public String toString() {
        return "Person [name=" + name + ", parrot=" + parrot + "]";
    }
}
