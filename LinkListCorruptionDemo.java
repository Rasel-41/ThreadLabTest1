public class LinkListCorruptionDemo {
    private static LinkList<Integer>list = new LinkedList<>();
    static class Addthread extends Thread{
        private Random random = new Random();
        public void run(){
            while (true){
                int value = random.nextInt(100);
                System.out.println("Adding");
            }
        }
    }
}
