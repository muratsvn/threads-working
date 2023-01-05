package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericType <T>{

    /*
        E ==> Element, collection gibi yapılarda kullanılır
        K ==> Key
        V ==> Value         Map<K,V> gibi
        N ==> Number
        T ==> Type
        S, U,..vb ==> 2, 3 ve 4.tipler için
     */

    private T type; //field, variable

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public static void main(String[] args) {

        //generic yapı kullanarak aynı class'dan 2 farklı data türünde obje oluşturulım

        GenericType<String> obj1 = new GenericType<>();
        // Trick: Diamond <> içine non-primitive type kullanabiliriz
        obj1.setType("Generic Types");

        //GenericType<String> obj2 = new GenericType<>();
            //obj2.setType(65); String girmem gerekirken int data türünü girinci CompileTE verdi

        //Note: Cast probleminden nasıl kurturuluruz
        GenericType<Integer> obj3 = new GenericType<>();
        obj3.setType(65);
        int a = obj3.getType(); // !!! CAST probleminden kurtulduk

        //Note: ClassCastException probleminden nasıl kurturuluruz
        // interfacelerden obj oluşturamayız Çünkü interface de oluşturulan methodlar abstract method
        List<String> list= new ArrayList<>();
        list.add("Alper");
        list.add("Halide");
            //list.add(22);         !!! CAST'den kurtulduk

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Generic");
            //map.put("Generic", 1) hata alırız


    }
}
