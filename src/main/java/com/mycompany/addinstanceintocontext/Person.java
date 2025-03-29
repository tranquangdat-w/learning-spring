package com.mycompany.addinstanceintocontext;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name; 

    private Parrot parrot;

    public Person() {
    }

    public Person(String name ) {
        this.name = name;
    }

    public Person(Parrot parrot) {
    }

	public Person(String name, Parrot parrot) {
		this.name = name;
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
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", parrot=" + parrot + "]";
    }
}
