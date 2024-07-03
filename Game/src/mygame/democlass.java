package mygame;

import java.awt.Rectangle;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
public class democlass extends Gameplay {
 public static void main(String[]args) {
	 Result result= JUnitCore.runClasses(test.class);
	 
	 System.out.println("Test 1 Result="+result.wasSuccessful());
	 System.out.println("Test 2 Result="+result.wasSuccessful());
	 
}}
