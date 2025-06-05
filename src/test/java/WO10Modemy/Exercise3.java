package WO10Modemy;

class testClass1{
    String tex = "fdsgsddgfs";
    Integer a = 4324;
    public static Integer sum(Integer a, Integer b){
        return a + b;
    }
    //method OVERLOADING
    public static Double sum(Double a, Double b, Double c){
        return a + b + c;
    }
}

public class Exercise3 {
    public static String testMethod(){
        Integer a = 5435635;
        return "test string";
    }
    public static void main(String[] args){

        testClass1 obj = new testClass1();
        //testMethod obj = new testMethod();

        System.out.println(obj.tex);
        System.out.println("Suma: " + obj.sum(5, 6));
        System.out.println("Suma: " + obj.sum(7.0, 8.6, 2.05));

        String test1 = "test1";
        String test2 = "test2";
    }
}

class test2{
    int vv = 9;
    test2(){
    };
    test2(int vv){
        this.vv = vv; //to vv from above is assigned value carreid by parameter (int vv)
    }
    public void printSTH(){
        System.out.println("Wydruk z klasy parent");
    }

    public static void main(String[] args){
        test2 obj = new test2(6);
        System.out.println(obj.vv);
    }
}

class test22 extends test2{
    @Override
    public void printSTH(){
        System.out.println("Wydruk z klasy child");
    }
    public static void main(String[] args){
        test22 obj = new test22();
        System.out.println(obj.vv); //wartosc vv jest dziediczona
        obj.printSTH(); //ovverride metody printSTH
    }
}