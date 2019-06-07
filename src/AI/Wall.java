/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author bovenzit2681
 */
public class Wall implements WallData {

    private static boolean[][] wall;

    public Wall() {
        wall = new boolean[800][600];
        for (int i = 0; i < 800; i += 1) {
            for (int j = 0; j < 600; j += 1) {
                wall[i][j] = false;
            }
        }
        for (int i = 0; i < xVals.length; i += 1) {
            wall[yVals[i]][Util.round(xVals[i]*.95)] = true;
        }
    }

    public void drawAll(Graphics window) {
        for (int i = 0; i < 800; i += 1) {
            for (int j = 0; j < 600; j += 1) {
                if (wall[i][j]) {
                    window.setColor(Color.white);
                    window.drawRect(i, j, 1, 1);
                }
            }
        }
    }

    public static boolean[][] getList() {
        return wall;
    }
}
