import java.util.EmptyStackException;

/**
 * Created by zhiyou on 14-12-7.
 */
class Resource{
    private String name;
    private String sex;
    boolean flag = false;
    public void set(String name,String sex){
        if (flag)
            try {
                this.wait();
            }catch (Exception e){}
        this.sex = sex;
        this.name = name;
        flag = true;
        notify();//唤醒另一个线程的开启
    }
    public void out(){
        if(!flag){
            try {
                this.wait();
            }catch (Exception e){}
            System.out.println(name + "+++++" + sex);
            flag = false;
            notify();
        }
    }


}
class Input implements Runnable {
    private Resource r;//引用

    Input(Resource r) {
        this.r = r;
    }

    public void run() {
        boolean flag = true;
        while (true) {

            if (flag)
                r.set("lingming", "nam");
            else
                r.set("nv", "lili");
        }
    }
}
class Output implements Runnable{
    private Resource r;//引用
    Output (Resource r){
        this.r = r;
    }
    public void run() {
        while (true)
            r.out();
    }

    }
 class xinxijiaoliu  {
    public static void main(String[] arge) {

        Resource r = new Resource();
        new Thread(new Input(r)).start();
        new Thread(new Output(r)).start();

    }

}