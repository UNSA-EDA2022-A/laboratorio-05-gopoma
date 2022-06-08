package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestExercise2 {

  Exercise2 obj = new Exercise2();

  @Test
  public void case_1() {

    boolean result = obj.existenDuplicados("((a+b)+(c+d))");
    boolean expected = false;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_2() {

    boolean result = obj.existenDuplicados("((a+b)+((c+d)))");
    boolean expected = true;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_3() {

    boolean result = obj.existenDuplicados("(a+b)-(c+d)");
    boolean expected = false;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_4() {

    boolean result = obj.existenDuplicados("(a+(b+(c+d)))");
    boolean expected = false;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_5() {

    boolean result = obj.existenDuplicados("(a+b)+((c+d))");
    boolean expected = true;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_6() {

    boolean result = obj.existenDuplicados("((a+b))+c");
    boolean expected = true;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }
}