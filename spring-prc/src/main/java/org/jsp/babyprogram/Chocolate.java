package org.jsp.babyprogram;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "choco")
@Primary
public class Chocolate implements IceCream{
	public void eat() {
		System.out.println("Baby eating chocolate iceCream");
	}
}
