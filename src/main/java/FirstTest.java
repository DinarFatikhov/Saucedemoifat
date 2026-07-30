import org.testng.annotations.Test;

import java.util.*;

import static org.testng.AssertJUnit.assertEquals;


public class FirstTest {
    @Test
    public void bla() {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Andrew", "12345");
        phoneBook.put("Mark", "2222");
        phoneBook.put("kr", "1111");
        phoneBook.put("Andrew", "77777");

        System.out.println(phoneBook);
    }
}


/*
public class FirstTest {
    //КРАТНО 3, ВОЗВРАЩАТЬ "T"
    //КРАТНО 5, ВОЗВРАЩАТЬ "M"
    //КРАТНО 3 И 5, ВОЗВРАЩАТЬ "ТИМ"
    //ВОЗВРАЩАТЬ "FAIL"

    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "ТИМ";
        } else if (number % 5 == 0) {
            return "M";
        } else if (number % 3 == 0) {
            return "T";
        } else return "FAIL";
    }

    @Test
    public void checkNumber() {
        String actualResult = trialCode(3);
        assertEquals(actualResult, "T");
    }

    @Test
    public void checkNumber2() {
        String actualResult = trialCode(25);
        assertEquals(actualResult, "M");

    }

    @Test
    public void checkNumber3() {
        String actualResult = trialCode(15);
        assertEquals(actualResult, "ТИМ");
    }

    @Test
    public void checkNumber4() {
        String actualResult = trialCode(17);
        assertEquals(actualResult, "FAIL");
    }
}


public class FirstTest {
    @Test
    public void bla() {
        Deque<String> orders = new ArrayDeque<>();
        orders.push("A");
        orders.push("B");
        orders.push("C");
        //LIFO последний пришел первым ушел
        //FIFO Первый пришел первым ушел
        System.out.println(orders.pop());
    }
}


*/
