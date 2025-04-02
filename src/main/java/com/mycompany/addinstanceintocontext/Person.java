package com.mycompany.addinstanceintocontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Ella"; 
    
    private Parrot parrot;

	public Person() {
        System.out.println("This is the person constructer");
	}

    @Autowired
	public void setParrot(@Qualifier("parrot1") Parrot parrot) {
        System.out.println("setParrot method");
		this.parrot = parrot;
	}

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

