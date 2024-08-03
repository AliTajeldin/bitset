package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class EncoderTest {
  @Test
  public void testNumIdToStr() {
    assertEquals("10203", Encoder.numIdToStr(1*36*36*36*36 + 2*36*36 + 3));
    assertEquals("000AZ", Encoder.numIdToStr(10*36 + 35));
  }

  @Test
  public void testStrIdToNum() {
    assertEquals(3*36*36*36*36 + 1*36*36 + 2, Encoder.strIdToNum("30102"));
    assertEquals(11*36*36*36*36 + 34*36*36 + 15, Encoder.strIdToNum("B0Y0F"));
    assertEquals(1*36*36 + 2*36 + 3, Encoder.strIdToNum("00123"));
  }
}
