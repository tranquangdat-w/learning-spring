package com.mycompany.addinstanceintocontext;

import org.springframework.stereotype.Component;

/**
 * Parrot
 */

@Component
public class Parrot {
    private String name;

	public Parrot() {
        System.out.println("Parrot with component class java!");
	}


	public Parrot(String name) {
        System.out.println("Parrot constructor");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Parrot [name=" + name + "]";
	}
}
