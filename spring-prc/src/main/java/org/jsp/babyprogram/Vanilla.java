package org.jsp.babyprogram;

import org.springframework.stereotype.Component;

@Component(value = "vani")
public class Vanilla implements IceCream {
	public void eat() {
		System.out.println("Baby eating vanilla iceCream");
	}
}
