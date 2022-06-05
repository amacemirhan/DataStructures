/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yods;

/**
 *
 * @author dicle
 */
public class LinkedList {
        Ders ilk=null, son=null;
    public void add(String dersAdi, String dersKodu, int kredi){
        Ders ders = new Ders(dersAdi,dersKodu,kredi);
        if(ilk==null){
            ilk=ders;
            son=ders;
        }
        else{
            son.next=ders;
            son= ders; 
        }
    }
    public void listele(){
        Ders gecici = ilk;
        System.out.println("Listeleniyor...");
        if(gecici==null){
            System.out.println("Ekli bir ders bulunmamaktadir.");
        }
        while(gecici != null){
            System.out.println("Ders Adi: "+gecici.dersAdi+" || Ders Kodu: "+gecici.dersKodu+" || Ders Kredisi: "+gecici.kredi);
            gecici = gecici.next;
        }
    }
    public boolean remove(String dersKodu){
        Ders temp = ilk ,onceki=ilk;
        while(temp != null){
            if(temp.dersKodu.equals(dersKodu)){
                break;
            }
            onceki = temp; 
            temp = temp.next;
        }
        if(temp == null){
            return false;
        }
        if( ilk == son){
            ilk=null;
            son=null;
        }
        else{
            if(temp == ilk){
                ilk = temp.next;
            }
            else if(temp == son){
                son= onceki;
                onceki.next=null;
            }
            else{
                onceki.next = temp.next;
            }
            return true;
        }
    return false;}
public class Ders{
    String dersAdi, dersKodu;
    int kredi;
    Ders next;
    public Ders(String dersAdi, String dersKodu,int kredi) {
        this.dersAdi = dersAdi;
        this.dersKodu = dersKodu;
        this.kredi = kredi;
        this.next = null;
    }
}
}
