package CrackingTheCodingInterview.LinkedList;

/**
 * Created by SanthoshVarathan on 07/07/17.
 */
public class loopDetection {
    static node detectLoopPointCorrectMethod(LinkedList<Integer> list){
        node slowRunner = list.getHead(), fastRunner = slowRunner;
        while(true){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if(slowRunner==fastRunner)break;
        }
        slowRunner = list.getHead();
        while(slowRunner!=fastRunner){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }
        return fastRunner;
    }
    static node detectLoopPointMethod(LinkedList<Integer> list){
        node slowRunner = list.getHead(), fastRunner = slowRunner.next.next,kRunner = slowRunner;
        while(slowRunner!=fastRunner){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        System.out.println("detected loop"+slowRunner.data+" "+fastRunner.data);
        int count = 1;slowRunner = slowRunner.next;
        while(slowRunner!=fastRunner){
            count++;
            slowRunner = slowRunner.next;
        }
        System.out.println("Loop length:"+count);
        for(int i=0;i<count;i++)
            kRunner = kRunner.next;
        System.out.println("Positioned k runner at:"+kRunner.data);

        slowRunner = list.getHead();
        while (slowRunner.next!=kRunner.next){
            slowRunner = slowRunner.next;
            kRunner = kRunner.next;
        }
        return kRunner.next;
    }
    public static void main(String ar[]){
        LinkedList<Integer> list = SingleLinkedList.generateTestList(10,true);
        node runner = list.getHead();
        for(int i=0;i<5;i++)
            runner = runner.next;
        list.getTail().next = runner;
        System.out.println((Integer)detectLoopPointCorrectMethod(list).data);
    }
}
