package Multithread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Homework implements Runnable{

    private int firstNumber=1;
    private final Object LOCK=new Object();

    public Homework(){

    }

    ArrayList<Integer>dividedlist1=new ArrayList<>();
    ArrayList<Integer>dividedlist2=new ArrayList<>();
    ArrayList<Integer>dividedlist3=new ArrayList<>();
    ArrayList<Integer>dividedlist4=new ArrayList<>();

    public ArrayList<Integer> getTeksayılar() {
        return teksayılar;
    }

    public ArrayList<Integer>getçiftsayılar(){
        return çiftsayıları;
    }

    ArrayList<Integer>teksayılar=new ArrayList<>();
    ArrayList<Integer>çiftsayıları=new ArrayList<>();

    @Override
    public void run() {

        synchronized (LOCK){
            System.out.println(getFirstNumber());

            if(this.firstNumber<2500){
                dividedlist1.add(firstNumber);
                System.out.println(this.firstNumber + " " + "added to dividedList1");
            }else if(2500<this.firstNumber&&this.firstNumber<5000){
                dividedlist2.add(firstNumber);
                System.out.println(this.firstNumber + " " + "added to dividedList2");
            }else if(5000<this.firstNumber&&firstNumber<7500){
                dividedlist3.add(firstNumber);
                System.out.println(this.firstNumber + " " + "added to dividedList3");
            }else {
                dividedlist4.add(firstNumber);
                System.out.println(this.firstNumber + " " + "added to dividedList4");
            }

            if(firstNumber%2==0){
                çiftsayıları.add(firstNumber);
                System.out.println(this.firstNumber + " " + "added to Even Number List");
            }else {
                teksayılar.add(firstNumber);
                System.out.println(this.firstNumber + " " + "added to Odd Number List");
            }
            firstNumber++;
        }
    }
    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

}

