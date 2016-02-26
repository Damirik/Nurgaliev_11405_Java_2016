
public class Matrix2x2 {
    double[][] m = new double[2][2];

    public Matrix2x2() {
        this(0);
    }

    public Matrix2x2(double x) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] = x;
            }
        }
    }

    public Matrix2x2(double[][] m2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] = m2[i][j];
            }
        }
    }

    public Matrix2x2(double x, double x1, double x2, double x3) {
        m[0][0] = x;
        m[0][1] = x1;
        m[1][0] = x2;
        m[1][1] = x3;
    }

    public Matrix2x2 add(double[][] m2) {
        double[][] m3 = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m3[i][j] = m[i][j] + m2[i][j];
            }
        }
        return new Matrix2x2(m3);
    }

    public void add2(double[][] m2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] += m2[i][j];
            }
        }
    }


    public Matrix2x2 sub(double[][] m2) {
        double[][] m3 = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m3[i][j] = m[i][j] - m2[i][j];
            }
        }
        return new Matrix2x2(m3);
    }

    public void sub2(double[][] m2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] -= m2[i][j];
            }
        }
    }


    public Matrix2x2 multNumber(double ch) {
        double[][] m2 = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m2[i][j] = m[i][j] * ch;
            }
        }
        return new Matrix2x2(m2);
    }

    public void multNumber2(double ch) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] *= ch;
            }
        }
    }


    public Matrix2x2 mult(Matrix2x2 m2) {
        return new Matrix2x2(m[0][0] * m2.m[0][0] + m[0][1] * m2.m[1][0], m[0][0] * m2.m[0][1] + m[0][1] * m2.m[1][1], m[1][0] * m2.m[0][0] + m[1][1] * m2.m[1][0], m[1][0] * m2.m[0][0] + m[1][1] * m2.m[1][0]);

    }

    public void mult2(Matrix2x2 m2) {
        m[0][0] = m[0][0] * m2.m[0][0] + m[0][1] * m2.m[1][0];
        m[0][1] = m[0][0] * m2.m[0][1] + m[0][1] * m2.m[1][1];
        m[1][0] = m[1][0] * m2.m[0][0] + m[1][1] * m2.m[1][0];
        m[1][1] = m[1][0] * m2.m[0][0] + m[1][1] * m2.m[1][0];

    }


    public double det() {
        return m[0][0] * m[1][1] - m[1][0] * m[0][1];
    }

    public void transpon() {
        double a = m[0][1];
        m[0][1] = m[1][0];
        m[1][0] = a;

    }

    public Matrix2x2 inverseMatrix() {
        if (this.det() == 0) return new Matrix2x2();
        else {
            Matrix2x2 m2 = new Matrix2x2(1, 0, 0, 1);
            double a = this.m[1][0] / this.m[0][0];
            m2.m[1][0] = m2.m[1][0] - a * m2.m[0][0];
            double b = this.m[1][1] - this.m[0][1] * a;
            m2.m[1][1] = m2.m[1][1] - a * m2.m[0][1];
            a = this.m[0][1] / b;
            m2.m[0][1] = m2.m[0][1] - a * m2.m[1][1];
            m2.m[0][0] = m2.m[0][0] - a * m2.m[1][0];
            m2.m[0][0] /= this.m[0][0];
            m2.m[0][1] /= this.m[0][0];
            m2.m[1][0] /= b;
            m2.m[1][1] /= b;
            return m2;
        }

    }


    public Matrix2x2 equivalentDiagonal() {
        Matrix2x2 m2 = new Matrix2x2();
        m2.m[0][0] = this.m[0][0];
        m2.m[1][1] = this.m[1][1];
        return m2;
    }


}

