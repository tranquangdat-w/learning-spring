package com.mycompany.addinstanceintocontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Parrot
 */

@Component
// @Primary
public class Parrot {
    private String name;

    public Parrot() {
        this.name = "parrot";
    }

	public Parrot(String name) {
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
