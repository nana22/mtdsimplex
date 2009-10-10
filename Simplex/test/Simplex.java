/* File: Simplex.java          */
/* Copyright (C) 1997 K. Ikeda */

import java.util.*;
import java.awt.*;
import java.applet.*;

class RN {

    int n;
    int d;

    RN() {
        n = 0;
        d = 1;
    }

    RN(int n) {
        this.n = n;
        this.d = 1;
    }

    RN(int n, int d) {
        this.n = n;
        this.d = d;
        reduce();
    }

    RN(String s) {
        int k = s.indexOf('/');
        if (k > 0) {
            d = Integer.valueOf(s.substring(k + 1)).intValue();
            s = s.substring(0, k);
        } else {
            d = 1;
        }
        n = Integer.valueOf(s).intValue();
        reduce();
    }

    int euclid(int a, int b) {
        int q, r;

        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (b == 0) {
            if (a == 0) {
                return -1;
            } else {
                return a;
            }
        }
        for (;;) {
            q = a / b;
            r = a % b;
            if (r == 0) {
                break;
            }
            a = b;
            b = r;
        }
        return b;
    }

    boolean reduce() {
        int c;

        if ((c = euclid(n, d)) < 0) {
            return false;
        }
        if (d < 0) {
            c *= -1;
        }
        n /= c;
        d /= c;
        return true;
    }

    void set(int n) {
        this.n = n;
        this.d = 1;
    }

    void set(int n, int d) {
        this.n = n;
        this.d = d;
    }

    void set(RN a) {
        n = a.n;
        d = a.d;
    }

    void mul(RN a) {
        a.reduce();
        RN aa = new RN(n, a.d);
        RN bb = new RN(a.n, d);
        aa.reduce();
        bb.reduce();
        n = aa.n * bb.n;
        d = aa.d * bb.d;
    }

    void div(RN a) {
        a.reduce();
        RN aa = new RN(n, a.n);
        RN bb = new RN(a.d, d);
        aa.reduce();
        bb.reduce();
        n = aa.n * bb.n;
        d = aa.d * bb.d;
    }

    void inv() {
        int x;
        x = n;
        n = d;
        d = x;
        reduce();
    }

    boolean plus(RN a) {
        int c, x, y;

        c = euclid(d, a.d);
        if (c < 0) {
            return false;
        }
        if ((x = a.d / c * n + d / c * a.n) == 0) {
            x = 0;
            y = 1;
        } else {
            y = d / c * a.d;
        }
        n = x;
        d = y;
        this.reduce();
        return true;
    }

    boolean minus(RN a) {
        int c, x, y;

        c = euclid(d, a.d);
        if (c < 0) {
            return false;
        }
        if ((x = a.d / c * n - d / c * a.n) == 0) {
            x = 0;
            y = 1;
        } else {
            y = d / c * a.d;
        }
        n = x;
        d = y;
        this.reduce();
        return true;
    }

    boolean gt(RN a) {
        RN c = new RN(n, d);
        c.minus(a);
        return c.n > 0;
    }

    boolean ge(RN a) {
        RN c = new RN(n, d);
        c.minus(a);
        return c.n >= 0;
    }

    boolean eq(RN a) {
        RN c = new RN(n, d);
        c.minus(a);
        return c.n == 0;
    }

    boolean le(RN a) {
        RN c = new RN(n, d);
        c.minus(a);
        return c.n <= 0;
    }

    boolean lt(RN a) {
        RN c = new RN(n, d);
        c.minus(a);
        return c.n < 0;
    }
}

public class Simplex extends Applet {

    int m, n, r, s;
    int step, cycle;
    RN[][] a = new RN[10][20];
    int[] base = new int[10];
    String message = "";

    void Print(Graphics g, FontMetrics fm, int x, int y, String s) {
        int w = fm.stringWidth(s);
        int h = fm.getHeight();
        g.drawString(s, x - w / 2, y - h / 2 + fm.getAscent());
    }

    void Print(Graphics g, FontMetrics fm, int x, int y, int n) {
        Print(g, fm, x, y, "" + n);
    }

    void Print(Graphics g, FontMetrics fm, int x, int y, RN rn) {
        int wn, wd, h = fm.getHeight();
        int sign;

        if (rn.n < 0) {
            sign = -1;
        } else {
            sign = 1;
        }
        if (rn.d == 1) {
            Print(g, fm, x, y, sign * rn.n);
            wd = fm.stringWidth("" + (sign * rn.n));
        } else {
            Print(g, fm, x, y - h / 2 - 2, sign * rn.n);
            Print(g, fm, x, y + h / 2 + 2, rn.d);
            wn = fm.stringWidth("" + sign * rn.n);
            wd = fm.stringWidth("" + rn.d);
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

    void input_data() {
        m = Integer.parseInt(getParameter("m"));
        n = Integer.parseInt(getParameter("n"));
        String sdat = getParameter("data");
        StringTokenizer st = new StringTokenizer(sdat, ",");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = new RN(st.nextToken());
            }
            base[i] = n + i;
            for (int j = n; j < n + m; j++) {
                RN rn = new RN(0);
                if (j == i + n) {
                    rn.set(1);
                }
                a[i][j] = rn;
            }
            a[i][n + m] = new RN(st.nextToken());
        }
        n += m;
    }

    boolean step1() {		/* search pivot s of (r, s) */
        RN c = new RN();

        s = 0;
        r = -1;
        c.set(a[m][s]);
        for (int j = 1; j < n; j++) {
            if (c.gt(a[m][j])) {
                s = j;
                c.set(a[m][s]);
            }
        }
        if (c.n >= 0) {
            s = -1;
            return true;
        } else {
            return false;
        }
    }

    boolean step2() {		/* search pivot r of (r, s) */
        RN t = new RN();
        RN c = new RN();

        for (int i = 0; i < m; i++) {
            if (a[i][s].n <= 0) {
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
        RN c = new RN();

        base[r] = s;
        c.set(a[r][s]);
        for (int j = 0; j <= n; j++) {
            a[r][j].div(c);
        }
    }

    void step4() {
        RN c = new RN();
        RN t = new RN();

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
        input_data();
        step = cycle = 0;
        s = r = -1;
        message = "click here.";
        setBackground(Color.white);
    }

    void select_color(Graphics g, int i, int j) {
        Color c;

        if ((step == 1 && i == m && j == s) || (step != 1 && i == r && j == s)) {
            c = Color.red;
        } else if ((step == 1 && i == m && j < n && a[i][j].n < 0) ||
                (step == 2 && (j == s || j == n) && i < m && a[i][s].n > 0) ||
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
        Print(g, fm, x, y, "basis");
        for (int j = 0; j < n; j++) {
            x += w;
            Print(g, fm, x, y, "x" + (j + 1));
        }
        x += w;
        Print(g, fm, x, y, "const");
        for (int i = 0; i <= m; i++) {
            x = 25 + w / 2;
            y += h;
            g.setColor(getBackground());
            g.fillRect(x - w / 2, y - h / 2, (n + 2) * w + 1, h + 1);
            g.setColor(Color.black);
            if (i == m) {
                Print(g, fm, x, y, "-z");
            } else {
                Print(g, fm, x, y, "x" + (base[i] + 1));
            }
            for (int j = 0; j <= n; j++) {
                select_color(g, i, j);
                x += w;
                Print(g, fm, x, y, a[i][j]);
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
