package yods;

import java.util.Stack;

/**
 *
 * @author Mehmed Emirhan AMAÇ
 * Yabanci Ogrenci Denetim Sistemi
 *
 */
public class YODS {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Stack myStack= new Stack();
       
        Student ogr=new Student("English","Emirhan Amac","900","12345");
        Admin admin=new Admin("Ahmet","Adali","123456");
        Advisor ad=new Advisor("German","Mehmet Baltekin","1000","sifredeneme");
        Advisor ad1=new Advisor("Polish","Salih Yazici","1001","salih123");
        Advisor ad2=new Advisor("Chinese","Yamatoso Gerwan","1002","chingo");
        //Polymorphishm
        User ogr2=new Student("Turkish","Abdullah Cayci","901","abcy");
        
        myStack.add(ogr);
        myStack.add(ogr2);
        myStack.add(ad);
        myStack.add(ad1);
        myStack.add(ad2);
        System.out.println("Admin tarafindan degistirilmeden once danismanin sifesi: "+admin.getPassword(ad));
        admin.setPassword(ad, "sifredegisti");//
        System.out.println("Admin tarafindan degistirildikten sonra danismanin sifesi: "+admin.getPassword(ad));
        
        System.out.println(myStack.pop());
        
        
        User [] dizi=new User[6];//dizide nesne saklama
        dizi[0]=admin;
        System.out.println(dizi[0].getName());
        dizi[0]=null;
    }
    
}
