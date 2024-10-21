package QuestionNumber1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Answer1 {
    private static ArrayList<Integer> list = new ArrayList<>();
    public void addElement(int element){
        synchronized (this){
            list.add(element);
        }
    }
    public void removeElement() {
        synchronized (this) {
            if (!list.isEmpty()) {
                list.removeFirst();
            }
        }
    }
    public void print(){
        synchronized (this){
            System.out.println(list);
        }
    }


    public static void main(String[] args)throws InterruptedException {
        Answer1 corruptionList = new Answer1();
        Runnable addTask =()->{
            for (int i=0;i<100;i++){
                corruptionList.addElement(i);
            }
        };
        Runnable removeTask = ()->{
            for (int i =0;i<100;i++){
                corruptionList.removeElement();
            }
        };

        Thread thread1 = new Thread(addTask);
        Thread thread2 = new Thread(removeTask);
        Thread thread3 = new Thread(addTask);
        Thread thread4 = new Thread(removeTask);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try{
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        corruptionList.print();
    }
}
