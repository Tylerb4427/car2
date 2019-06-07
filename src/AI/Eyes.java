/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

/**
 *
 * @author bovenzit2681
 */
public class Eyes { //Tyler's Contribution▼

    public static final int range = 12;
    public static final double thetaRange = 90;

    public static double scan(double x, double y, double theta) {
        double val = 0;
        int lS = 0;
        int rS = 0;
        //for (double t = theta - (thetaRange / 2); t <= theta + (thetaRange / 2); t+=45) {
        double t = -theta - 65;
        for (double r = 1; r < range; r++) {
            if (Wall.getList()[Util.round(x + r * Math.cos(Util.toRadian(t)))][Util.round(y + r * Math.sin(Util.toRadian(t)))]) {

                rS++;

            }
        }
        t = -theta + 50;
        for (double r = 1; r < range; r++) {
            if (Wall.getList()[Util.round(x + r * Math.cos(Util.toRadian(t)))][Util.round(y + r * Math.sin(Util.toRadian(t)))]) {

                lS++;

            }
        }
//        t = -theta -90;
//        for (double r = 1; r < 5; r++) {
//            if (Wall.getList()[Util.round(x + r * Math.cos(Util.toRadian(t)))][Util.round(y + r * Math.sin(Util.toRadian(t)))]) {
//
//               rS+=5;
//
//            }
//        }


        //System.out.println(lS+" : "+rS);
        double tA = 4;

//        if (lS > rS) {
//            return tA;
//        }
//        if (lS == rS) {
//            return 0;
//        }
        //System.out.println(-(rS-lS)/5);
        return (-18) * (rS - lS);
        //return val / (Math.random() * 4000);
    }
}
