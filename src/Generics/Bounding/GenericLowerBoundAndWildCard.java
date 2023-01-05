package Generics.Bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundAndWildCard {
    public static void main(String[] args) {
        //********* addElements *********
        List<Object> ol = new ArrayList<>();
        addElements(ol);

        List<Number> nl = new ArrayList<>();
        addElements(nl);

        //List<Double> dl = new ArrayList<>();
        //addElements(dl); // CompileTimeError CTE, generic öncesi yapılarda RunTe olurdu

        //********* printElements **********
        //List<String> st = new ArrayList<>();
        //printElements(st);
        printElements(new ArrayList<String>());

        //********* printObj **********
        List<String> strList = new ArrayList<>();
        //printObj(strList); //CTE

        List<Object> objectList = new ArrayList<>();
        printObj(objectList);
    }

    // super Integer ---> bana Integer'ın parent'larını getir
    public static void addElements(List<? super Integer> list){
        // ? : WildCard (tipi bilinmeyen)
        for (int i=1; i<=10; i++){
            list.add(i);
        }
    }
        //WildCard sınırlamaları
    public static void printElements(List<?> listOfUnkown){
       // listOfUnkown.add("Java"); --> ?'den dolayı data türü netleşmeden add methodu islemleri yapamayız
       // listOfUnkown.add(null); //illa eklenecekse null eklenebilir
        for (Object object : listOfUnkown){
            System.out.println(object);
        }
    }

    // ? --> Object
    public static void printObj(List<Object> listOfObject){
        listOfObject.add("Java");
        for (Object object : listOfObject){
            System.out.println(object);
        }

    }


}
