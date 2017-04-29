package ru.job4j.calculator;

/**
* Class for math operations.
*
* @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
* @version $Id$
* @since 0.1
*/

public class Calculator {
	private double result;
		
	public void add(double first, double second) {
		result = first + second;
	}
	
	public void substract(double first, double second) {
		result = first - second;
	}
	
	public void div(double first, double second) {
		result = first / second;
	}
	
	public void multiple(double first, double second) {
		result = first * second;
	}
	
	public double getResult() {
		return result;
	}
}