/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author bovenzit2681
 */
public class aiGroup {

    public static ArrayList<Car> group;
    private int numActive;

    public aiGroup(int num) {
        ArrayList<Integer> test = new ArrayList<>();
        ArrayList<Integer> test2 = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            test.add(1);
//            test2.add(0);
//        }
        group = new ArrayList<Car>();
        numActive = num;
        for (int i = 0; i < num; i++) {
            //group.add(new Car(100, 135, 0, 1, 1, Color.getHSBColor((float) i / num, 1f, .5f)));
            group.add(0, new Car(100, 145, 210, 1.2+Math.random()/5, 1, Color.getHSBColor(.1f+.8f*(float) i / num, 1f, 1f),i));
            group.get(i).setSpeed(1);
        }
    }

    public void drawAll(Graphics window) {
        for (Car i : getGroup()) {
            i.draw(window);
        }
    }
    
    public int getNumActive(){
        int num=0;
        for (Car i : getGroup()) {
            if(i.getActive())
                num++;
        }
        return num;
    }
    
    public void addCar(Car car) {
        group.add(car);
    }

    public void moveAll() {
        for (Car i : getGroup()) {
            if (i.getActive()) {
                i.drive();
                i.move();
            }
        }
        //System.out.println(numActive);
    }

    public void sort() {
        {
            int n = getGroup().size();
            Car temp;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (getGroup().get(j - 1).getScore() / getGroup().get(j - 1).getStep() > getGroup().get(j).getScore() / getGroup().get(j).getStep()) {
                        temp = getGroup().get(j - 1);
                        getGroup().set(j - 1, getGroup().get(j));
                        getGroup().set(j, temp);
                    }

                }
            }

        }

    }
    
    public int search(){
        double score=0;int index=0;
        for(int i=0;i<getGroup().size();i++){
            if(getGroup().get(i).getScore()>score){
                score= getGroup().get(i).getScore();
                index=i;
            }
        }
        return index;
    }


    public void checkCollision() {  // Gabe's contribution ▼
        //sort();
        
        for (int a = getGroup().size() - 1; a >= 0; a--) {
            
            Car temp = getGroup().get(a);
            temp.setSpeed(temp.getSpeed()-.1+Math.random()/5);
            if(temp.getSpeed()>1.7)
                temp.setSpeed(1.7);
            if(temp.getSpeed()<1)
                temp.setSpeed(1);
            int place=1;
//int place = search();
            if (temp.collided()) {
                //getGroup().remove(a);
                temp.setActive(false);
                //getGroup().add(new Car(100, 145, 210,  1.2+Math.random()/5, 1, Color.getHSBColor((float) 100, 1f, .5f), Util.subArray(getGroup().get(place).turns, 1, getGroup().get(place)), Util.subArray(getGroup().get(place).gas, 1, getGroup().get(place)), getGroup().get(place).getStep()));
//                        };
            }
            //getGroup().add(new Car(100, 105, 30, 1, 1, Color.getHSBColor((float) 100, 1f, .5f)));
        }

    }

    public static ArrayList<Car> getGroup() {
        return group;
    }
}
