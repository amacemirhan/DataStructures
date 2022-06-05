
package yods;

/**
 *
 * @author dicle
 */
public class Queue<T> {
    Object [] kuyrukDizisi;
    int front,rear,size,items;
    
    public Queue(int size){
        this.size=size;
        kuyrukDizisi=new Object[this.size];
        front = 0;
        rear=-1;
        items=0;        
    }
    
    public void enqueue (Object o){
        if(DoluMu()){
            //System.out.println("Kuyruk Dolu");
            return;
        }
        else{
        rear++;
        kuyrukDizisi[rear]=o;
        items++;
            //System.out.println("Ekleme tamamlandi");
        }
    }
    public boolean DoluMu(){
        return (items==size); // rear==size-1 de çalıştı.
    }
    public boolean BosMu(){
        return(items==0); // rear==-1 çalıştı.
    }
    public T dequeue(){
        if(BosMu()){
            //System.out.println("Kuyruk Boş");
            return null;
        }
        T removeObject = (T) kuyrukDizisi[front];
        for(int i=1;i<rear+1;i++){
            T tmp;
            tmp=(T) kuyrukDizisi[i];
            kuyrukDizisi[i-1]=tmp;
        }
        kuyrukDizisi[rear]=null;
        items--;
        rear--;
        return removeObject;
    }
    public boolean yerVarMi(){
        if(items<size)
        return true;
        else
        return false;
    }
    
    public void Kuyrukyazdir(){
        //System.out.println("Kuyruktaki Elemanlar");
        for(int i=0;i<kuyrukDizisi.length;i++){
            //System.out.println((i+1)+". Eleman: "+kuyrukDizisi[i]);
        }
        
    }
}
