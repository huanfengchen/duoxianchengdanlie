/**
 * Created by zhiyou on 14-12-12.
 */
class Stop implements Runnable{
    private boolean flage = true;
    public void run(){
        while (true){
            System.out.println(Thread.currentThread().getName()+"main----");
        }
    }
    public void Changeflage(){
        flage = false;
    }
}
public class Change {
    public static void main(String[] arge){
            Stop s= new Stop();
        Thread t1= new Thread(s);
        Thread t2 = new Thread(s);
        t1.start();
        t2.start();
        int num = 0;
        while (true)
        {
            s.Changeflage();
            if(num++ == 60){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"----"+num);
        }
    }
}
