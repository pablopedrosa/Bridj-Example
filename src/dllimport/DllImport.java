/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dllimport;
import org.bridj.*;     // C interop and core classes
import org.bridj.ann.*; // annotations
import org.bridj.cpp.*; // C++ runtime
import static org.bridj.Pointer.*; // pointer factories such as allocateInt(), pointerTo(java.nio.Buffer), etc...
import java.lang.reflect.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;


@Library("test")
public class DllImport {
    static {
        BridJ.register(); // binds all native methods in this class and its subclasses
    }
    
    public static native int sum(int i, int j);
    public static native int changeInt(Pointer<Integer > a);
    public static native int returnCharAst(Pointer<Byte > val);
    public static native int returnCharArr(Pointer<Byte > val);
    public static native int completeFunction(int DeviceAddress, Pointer<Integer > CurrentAddress, Pointer<Byte > SerialNum);
    
    public static void main(String[] args) {
        //Creo un objeto de tipp Pointer<Integer> pointA, no tiene constructor, 
        //simplemente lo creo con la funcion pointerToInt, quien me devuelve la 
        //dirección de memoria del entero que le ponga.
        Pointer<Integer> pointA = pointerToInt(0);
        
        //Creo un objeto de tipp Pointer<Byte> pointByte, no tiene constructor, 
        //simplemente lo inicializo con la funcion pointerToByte, quien me devuelve la 
        //dirección de memoria del byte que le ponga.
        Pointer<Byte> pointByte = pointerToByte((byte)0x00);
        
        
        //Creo un objeto de tipo Pointer<Byte> y otro de tipo Pointer<Integer>
        //simplemente lo inicializo con la funcion pointerToByte, quien me devuelve la 
        //dirección de memoria del byte que le ponga.
        Pointer<Integer> curAd = pointerToInt(0);
        Pointer<Byte> serialNumber = pointerToBytes((byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56);
        
        //Ejemplo funcional para entrar en calor.
        System.out.println("Valor devuelto por -Function Sum: "+sum(6, 9));
        System.out.println("--------------------------------------------------------------------");
        
        //Ejemplo funcional de pasarle un puntero a un entero.
        int i = changeInt(pointA);
        System.out.println("Tomo el valor por referencia :D Function changeInt: "+pointA.getInt());
        System.out.println("Valor devuelto por Function changeInt: "+i);
        System.out.println("--------------------------------------------------------------------");

        //Ejemplo funcional de pasarle una referencia a un byte
        i = returnCharAst(pointByte);
        char chr = (char)pointByte.getByte();
        System.out.println("Tomo el valor por referencia :D Function returnCharAst: "+chr);
        System.out.println("Valor devuelto por Function changeInt: "+i);
        System.out.println("--------------------------------------------------------------------");        

        //Ejemplo de una cabecera de funcion como la que tenemos en la funcion GetSerialNum
        String str = new String(serialNumber.getBytes());
        System.out.println("Valor de curAd antes de entrar a la funcion: "+curAd.getInt());
        System.out.println("Valor de serialNumber antes de entrar a la funcion: "+str);
        i = completeFunction(0, curAd, serialNumber);
        
        String str2 = new String(serialNumber.getBytes());
        System.out.println("Valor de curAd al salir de la funcion completeFunction: "+curAd.getInt());
        System.out.println("Valor de serialNumber al salir de la funcion completeFunction: "+str2);
        System.out.println("Valor devuelto por Function changeInt: "+i);
        System.out.println("--------------------------------------------------------------------");
    }
}
