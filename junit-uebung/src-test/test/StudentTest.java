package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import daten.Student;

public class StudentTest {

        @Test
        public void testToString() {
                Student josef = new Student("Frank","Buschman",false);
                String output = josef.toString();
                assertEquals("Student {firstName=Frank, lastName=Buschman}",
                                output);
        }

        @Test
        public void testStudentConstructor1Valid() {
                Student guenther = new Student("Peter","Engel");
                assertSame("Guenther",guenther.getFirstName());
                assertSame("Ericsson",guenther.getLastName());
                
                assertEquals("Guenther",guenther.getFirstName());
                assertEquals("Ericsson", guenther.getLastName());
                
        }

        @Test
        public void testStudentConstructor2Valid() {
                Student olaf = new Student("Hans","Huber",true);
                assertSame("Olaf",olaf.getFirstName());
                assertSame("Schlafnixson",olaf.getLastName());
                
                assertEquals("Olaf",olaf.getFirstName());
                assertEquals("Schlafnixson", olaf.getLastName());
        }

        @Test(expected = IllegalArgumentException.class)
        public void testStudentConstructor1InValid() {
                Student guenther = new Student("Guenther"," ");                
        }

        @Test(expected = IllegalArgumentException.class)
        public void testStudentConstructor2InValid() {
                Student olaf = new Student("","Schlafnixson",true);
        }
        
        @Test
        public void testSetSelfEntitled() {
                Student jesus = new Student("Jesus","Christ",true);
                assertEquals(true, jesus.getSelfEntitled());
        }

        @Test
        public void testCompareToFirst() {
                Student hans = new Student("hans","huber");
                hans.setBirthDate(new Date(2000,1,1));
                int x=0;
                int result=hans.compareTo(hans);
                assertTrue(x==result);
        }
        @Test
        public void testCompareToSecond() {
                Student hans = new Student("hans","huber");
                hans.setBirthDate(new Date(2001,2,4));
                
                Student mike = new Student("Mike","Mayer");
                mike.setBirthDate(new Date(2012,3,4));
                
                int result =hans.compareTo(mike);
                System.out.println(result);
                assertTrue(result>0);
        }
        @Test
        public void testCompareToThird() {
                Student hans = new Student("hans","huber");
                hans.setBirthDate(new Date(2001,2,4));
                
                Student mike = new Student("Mike","Mayer");
                mike.setBirthDate(new Date(2012,3,4));
                
                int result=mike.compareTo(hans);
                System.out.println(result);
                assertTrue(result<0);
        }
}