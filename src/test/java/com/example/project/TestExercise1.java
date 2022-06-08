package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestExercise1 {

  Exercise1 obj = new Exercise1();

  @Test
  public void case_1() {

    boolean result = obj.esBalanceado("()()()[()]()");
    boolean expected = true;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_2() {

    boolean result = obj.esBalanceado("((()))[]");
    boolean expected = true;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_3() {

    boolean result = obj.esBalanceado("([])[](");
    boolean expected = false;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_4() {

    boolean result = obj.esBalanceado("([{)]}");
    boolean expected = false;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_5() {

    boolean result = obj.esBalanceado("[");
    boolean expected = false;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_6() {

    boolean result = obj.esBalanceado("[][][]{{{}}}");
    boolean expected = true;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

}
