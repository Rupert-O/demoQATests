package WO10Modemy;

import org.junit.Test;

import java.util.*;

public class Exercise2 {
    private String title = "Lord of the rings";
    private String author = "John Ronald Ruel Tolkien";
    private int yearOfRelease = 1920;

    //konstruktor
    public Exercise2(){
        System.out.println("conctructor called");
    }
    //getter
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getYearOfRelease(){
        return yearOfRelease;
    }
    //setter
    public void setAuthor(String authorParam){
        author = authorParam;
    }
    public void setTitle(String titleParam){
        title = titleParam;
    }
    public void setYearOfRelease(int yearOfReleaseParam) {
        yearOfRelease = yearOfReleaseParam;
    }

//    @Test
//    public static void main(String[] args){
//        Exercise2 obj = new Exercise2();
//        System.out.println(obj.author);
//    }

    @Test
    public void toSentence(){
        Exercise2 testObj2 = new Exercise2();
        System.out.println(testObj2.getTitle() + " by " + testObj2.getAuthor() + " (" + testObj2.getYearOfRelease() + ")");
    }

    @Test
    public void testMethodDivide(){
        Scanner s = new Scanner(System.in);
        try{
            int dzielna = 5;
            int dzielknik = 0;
            int result = dzielna/dzielknik;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

 class testOfGetterAndSetter{

    public static void main(String[] args) {
        Exercise2 testObj = new Exercise2();
        System.out.println("wyciagniety tytuł " + testObj.getTitle());
        System.out.println("ROk w klasie " + testObj.getYearOfRelease());
        testObj.setYearOfRelease(2022);
        System.out.println("Nowa wartośc yearOfRelaese ustawiona przez setter: " + testObj.getYearOfRelease());
    }

}

class Employee{
    private String Employee;
    private float Salary;

    public String getEmployee(){
        return Employee;
    }
    public void setEmployee(String employeeParam){
        Employee = employeeParam;
    }
    public float getSalary(){
        return Salary;
    }
    public void setSalary(float salaryParam){
        Salary = salaryParam;
    }

    public static void main(String[] args){
        Employee zatrudniony = new Employee();
        zatrudniony.setEmployee("adam dabrowski");
        zatrudniony.setSalary(1456);
        System.out.println(zatrudniony.getEmployee() + " zarabia " + zatrudniony.getSalary());
    }
}

class ListExercises{


    public static void main(String[] args){
        List<Integer> liczbyCalkowite = new ArrayList<>();
        for(int i=1; i<= 15; i++){
            liczbyCalkowite.add(i);
        }
        System.out.println("lista z wszystkimi: " + liczbyCalkowite);
        List<Integer> parzyste = new ArrayList<>();

        //filter out parzyste
        for(int number : liczbyCalkowite){
            if(number % 2 == 0){
                parzyste.add(number);
            }else{}
        }
        System.out.println("lista z parzystymi: " + parzyste);

        //sort out form bigger to smaller
        parzyste.sort(Collections.reverseOrder());
        System.out.println("lista posortowana: " + parzyste);
    }


}

class findMax{

    public static Integer findMaks(Integer[] tablica){
        Integer x = tablica[0];
        for (int i = 0; i < tablica.length; i++) {
            if(x < tablica[i]){
                x = tablica[i];
                //System.out.println(x);
            }
        }
        return x;
    }

    public static void main(String[] args){
        Integer[] tab = {4, 15, -3, 22, 8};
        System.out.println(findMaks(tab));
    }
}

class enumAndSwitch{
    public enum Day{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }
    public static void main(String[] args){
        System.out.println( Day.MONDAY.ordinal());
        Day dzien = Day.MONDAY;
        switch (dzien){
            case MONDAY:
                System.out.println("poniedzialek");
                break;
            case TUESDAY:
                System.out.println("wtorek");
                break;
            default:
                System.out.println("nic");
                break;
        }
    }
}

class verifyPassword{

    static boolean isValidPassword(String password){

        boolean conditionLength = false;
        boolean conditionCapitalLetter = false;
        boolean atLeastOneDigit = false;
        boolean validationResult = false;

        //verify length
        Integer passLenghth = password.length();
        if(passLenghth >= 8){
            conditionLength = true;
        }
        System.out.println("Pass contains sufficient number of character: " + conditionLength  + " (" + passLenghth + ") ");

        // verify containing capital letters
        conditionCapitalLetter = password.matches(".*[A-Z].*");
        System.out.println("Pass contains upperCase letters: " + conditionCapitalLetter);

        //verify containing digits
        atLeastOneDigit = password.matches(".*\\d.*");
        System.out.println("Pass contains any digit: " + atLeastOneDigit);

        //check if all conditions are TRUE
        if(conditionLength && conditionCapitalLetter && atLeastOneDigit){
            validationResult = true;
        }
        return validationResult;
    }

    public static void main(String[] args){
        String pass = "Ggsgsgfs5gdgfd";
        System.out.println("result of password validation: " + isValidPassword(pass));

    }
}
class randomExercises{

    public static void main(String[] args){
        Integer[] arr = {12, 4, 5};
        for(Integer numer : arr){
            System.out.println(numer);
        }
        Integer x = 0;
        while(x < 5){
            System.out.println(x);
            arr[x] = x;
            x++;
        }
        do{
            System.out.println(x);
            x++;
        }while(x < 5);

    }
    public String randomExercises(){
        return "fsdfds";
    }
}