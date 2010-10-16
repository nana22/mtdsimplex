/* File: Simplex.java          */
/* Copyright (C) 1997 K. Ikeda */

import simplex.resolvedor.mate.RationalNumber;
import java.util.*;
import java.awt.*;
import java.applet.*;

public class Simplex extends Applet {

    int m, n, r, s;
    int step, cycle;
    RationalNumber[][] a = new RationalNumber[10][20];
    int[] base = new int[10];
    String message = "";

    void print(Graphics g, FontMetrics fm, int x, int y, String s) {
        int w = fm.stringWidth(s);
        int h = fm.getHeight();
        g.drawString(s, x - w / 2, y - h / 2 + fm.getAscent());
    }

    void print(Graphics g, FontMetrics fm, int x, int y, int n) {
        print(g, fm, x, y, "" + n);
    }

    void print(Graphics g, FontMetrics fm, int x, int y, RationalNumber rn) {
        int wn, wd, h = fm.getHeight();
        int sign;

        if (rn.numerator < 0) {
            sign = -1;
        } else {
            sign = 1;
        }
        if (rn.denominator == 1) {
            print(g, fm, x, y, sign * rn.numerator);
            wd = fm.stringWidth("" + (sign * rn.numerator));
        } else {
            print(g, fm, x, y - h / 2 - 2, sign * rn.numerator);
            print(g, fm, x, y + h / 2 + 2, rn.denominator);
            wn = fm.stringWidth("" + sign * rn.numerator);
            wd = fm.stringWidth("" + rn.denominator);
            if (wn > wd) {
                wd = wn;
            }
            g.drawLine(x - wd / 2, y - 1, x + wd / 2, y - 1);
        }
        if (sign < 0) {
            wn = wd / 2 + fm.stringWidth("-") + 2;
            wd = fm.getHeight();
            g.drawString("-", x - wn, y - wd / 2 + fm.getAscent());
        }
    }

    void inputData() {
//        m = Integer.parseInt(getParameter("m"));
//        numerator = Integer.parseInt(getParameter("numerator"));
//        String sdat = getParameter("data");
//        m = 2;
//        numerator = 2;
//        String sdat = "5/2,5,150,5,2,120,-3/2,-1,0";
//        StringTokenizer st = new StringTokenizer(sdat, ",");
        m = 3;
        n = 2;
        String sdat = "1,0,4,0,2,12,3,2,18,-3,-5,0";
        StringTokenizer st = new StringTokenizer(sdat, ",");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = new RationalNumber(st.nextToken());
            }
            base[i] = n + i;
            for (int j = n; j < n + m; j++) {
                RationalNumber rn = new RationalNumber(0);
                if (j == i + n) {
                    rn.set(1);
                }
                a[i][j] = rn;
            }
            a[i][n + m] = new RationalNumber(st.nextToken());
        }
        n += m;
    }

    boolean step1() {		/* search pivot s of (r, s) */
        RationalNumber c = new RationalNumber();

        s = 0;
        r = -1;
        c.set(a[m][s]);
        for (int j = 1; j < n; j++) {
            if (c.gt(a[m][j])) {
                s = j;
                c.set(a[m][s]);
            }
        }
        if (c.numerator >= 0) {
            s = -1;
            return true;
        } else {
            return false;
        }
    }

    boolean step2() {		/* search pivot r of (r, s) */
        RationalNumber t = new RationalNumber();
        RationalNumber c = new RationalNumber();

        for (int i = 0; i < m; i++) {
            if (a[i][s].numerator <= 0) {
                continue;
            }
            t.set(a[i][n]);
            t.div(a[i][s]);
            if (r < 0 || t.lt(c)) {
                r = i;
                c.set(t);
            }
        }
        if (r < 0) {
            return true;
        } else {
            return false;
        }
    }

    void step3() {		/* pivot operation 1 */
        RationalNumber c = new RationalNumber();

        base[r] = s;
        c.set(a[r][s]);
        for (int j = 0; j <= n; j++) {
            a[r][j].div(c);
        }
    }

    void step4() {
        RationalNumber c = new RationalNumber();
        RationalNumber t = new RationalNumber();

        for (int i = 0; i <= m; i++) {
            if (i == r) {
                continue;
            }
            c.set(a[i][s]);
            for (int j = 0; j <= n; j++) {
                t.set(c);
                t.mul(a[r][j]);
                a[i][j].minus(t);
            }
        }
        r = s = -1;
    }

    @Override
    public void init() {
        inputData();
        step = cycle = 0;
        s = r = -1;
        message = "click here.";
        setBackground(Color.white);
    }

    void selectColor(Graphics g, int i, int j) {
        Color c;

        if ((step == 1 && i == m && j == s) || (step != 1 && i == r && j == s)) {
            c = Color.red;
        } else if ((step == 1 && i == m && j < n && a[i][j].numerator < 0) ||
                (step == 2 && (j == s || j == n) && i < m && a[i][s].numerator > 0) ||
                (step == 3 && (i == r || j == s))) {
            c = Color.blue;
        } else {
            c = Color.black;
        }
        g.setColor(c);
    }

    @Override
    public void paint(Graphics g) {
        int w, h;
        int x, y;

        FontMetrics fm = g.getFontMetrics();
        w = fm.stringWidth("012345") + 10;
        h = fm.getHeight() * 2 + 4;

        x = 25 + w / 2;
        y = 25 + h / 2;
        g.setColor(getBackground());
        g.fillRect(x - w / 2, y - h / 2, (n + 2) * w + 1, h + 1);
        g.setColor(Color.black);
        print(g, fm, x, y, "basis");
        for (int j = 0; j < n; j++) {
            x += w;
            print(g, fm, x, y, "x" + (j + 1));
        }
        x += w;
        print(g, fm, x, y, "const");
        for (int i = 0; i <= m; i++) {
            x = 25 + w / 2;
            y += h;
            g.setColor(getBackground());
            g.fillRect(x - w / 2, y - h / 2, (n + 2) * w + 1, h + 1);
            g.setColor(Color.black);
            if (i == m) {
                print(g, fm, x, y, "-z");
            } else {
                print(g, fm, x, y, "x" + (base[i] + 1));
            }
            for (int j = 0; j <= n; j++) {
                selectColor(g, i, j);
                x += w;
                print(g, fm, x, y, a[i][j]);
            }
        }
        g.setColor(getBackground());
        g.fillRect(25, 25 + (m + 2) * h, 300, (h - 4) / 2 + 1);
        g.fillRect(25, 25 - h / 2, 120, (h - 4) / 2 + 1);
        g.setColor(Color.black);
        g.drawString(message, 25, 25 + (m + 2) * h + fm.getAscent());
        g.drawString("Cycle " + cycle, 25, 25 - h / 2 + fm.getAscent());
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public boolean mouseDown(Event ev, int x, int y) {
        boolean isOptimal = false;
        boolean isUnbounded = false;

        switch (step) {
            case 0:
                if (isOptimal = step1()) {
                    message = "Optimal";
                } else {
                    message = "Select x" + (s + 1) + " to enter the basis.";
                }
                break;
            case 1:
                if (isUnbounded = step2()) {
                    message = "Unbounded";
                } else {
                    message = "Select x" + (base[r] + 1) + " to leave the basis.";
                }
                break;
            case 2:
                step3();
                message = "Replace the simplex tableau.";
                break;
            case 3:
                step4();
                message = "Repeat the cycle.";
                cycle++;
                break;
            case 4:
                init();
                message = "Click here";
                repaint();
                return true;
            default:
                break;
        }
        step++;
        repaint();
        step %= 4;
        if (isOptimal || isUnbounded) {
            step = 4;
        }
        return true;
    }
}