package Generics.InterfaceType;

public interface GenericInterface <T>{

    //Generic : data türünden bağımsız yapılar oluşturmaya yarar
    void setValue(T t);
    T getValue();

}
