package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class JpaApplicationTest{
   @Test
   public void isClassPresent(){
      assertDoesNotThrow(() -> Class.forName("com.example.JpaApplication"),
         "Expected com.example.JpaApplication not to be on class path");
   }
}
