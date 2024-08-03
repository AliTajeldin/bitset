package com.example;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CacheTest {
  @Test
  public void testCacheHasSetClear() {
    Cache c = new Cache(36*36);
    
    assertFalse(c.has("00012"));
    c.set("00012");
    assertTrue(c.has("00012"));
    c.clear("00012");
    assertFalse(c.has("00012"));
    
  }
  
  @Test
  public void testCacheReadWrite() throws IOException {
    final int size = 36*36;
    final String fileName = "/tmp/a.gz";

    // write part
    Cache c = new Cache(size);
    String[] vals = {"00012", "000AA", "000AZ", "00001", "0008C"};
    for (String v : vals) {
      c.set(v);
    }
    c.save("/tmp/a.gz");

    // read part
    Cache c2 = new Cache(fileName, size);
    for (String v : vals) {
      assertTrue(c2.has(v));
    }
    assertFalse(c2.has("00000"));
    assertFalse(c2.has("000ZZ"));
  }

}