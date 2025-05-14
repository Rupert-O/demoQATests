package WO10Modemy;

import org.junit.Test;

public class Exercises1 {
    @Test
    public void FizzBuzz(){
        for (int i = 1; i <=50; i++){
            if (i%5 == 0 && i%3 == 0){
                System.out.println("FizzBuzz " + i);
            } else if (i%5 == 0) {
                System.out.println("Buzz " + i);
            } else if (i%3 == 0) {
                System.out.println("Fizz " + i);
            }else {
                System.out.println(i);
            }
        }
    }
}