import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by damirik on 26/02/16.
 */


public class Matrix2x2Test {

    public final static double EPS = 1e-9;

    @Test
    public void MatrixShouldNotBeNull() {
        ArrayList<Matrix2x2> matrix2x2s = new ArrayList<>();
        matrix2x2s.add(new Matrix2x2());
        matrix2x2s.add(new Matrix2x2(2));
        matrix2x2s.add(new Matrix2x2(new double[2][2]));
        matrix2x2s.add(new Matrix2x2(0, 0, 0, 0));

        for (Matrix2x2 matrix2x2 : matrix2x2s) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    Assert.assertNotEquals(null, matrix2x2.m[i][j]);
                }
            }
        }
    }

    @Test
    public void AddTest() {

        Matrix2x2 m1 = new Matrix2x2(0, 1, 2, 3);
        Matrix2x2 m2 = new Matrix2x2(3, 2, 1, 0);
        Matrix2x2 m3 = m1.add(m2.m);
        m1.add2(m2.m);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(3, m1.m[i][j], EPS);
                Assert.assertEquals(3, m3.m[i][j], EPS);
            }
        }

    }

    @Test
    public void SubTest() {
        Matrix2x2 m1 = new Matrix2x2(5, 5, 5, 5);
        Matrix2x2 m2 = new Matrix2x2(2, 2, 2, 2);
        Matrix2x2 m3 = m1.sub(m2.m);
        m1.sub2(m2.m);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(3, m1.m[i][j], EPS);
                Assert.assertEquals(3, m3.m[i][j], EPS);
            }
        }

    }

    @Test
    public void MultTest() {
        Matrix2x2 m1 = new Matrix2x2(3, 3, 3, 3);
        Matrix2x2 m2 = m1.multNumber(2);
        m1.multNumber2(2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(6, m1.m[i][j], EPS);
                Assert.assertEquals(6, m2.m[i][j], EPS);
            }
        }
        Matrix2x2 m3 = m1.mult(m2);
        Matrix2x2 m4 = m1.mult(m2);
        m1.mult2(m2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(72, m3.m[i][j], EPS);
                Assert.assertEquals(72, m4.m[i][j], EPS);
            }
        }

    }

    @Test
    public void DetTest() {
        Matrix2x2 m1 = new Matrix2x2(0, 1, 2, 3);
        double det = m1.det();
        Assert.assertEquals(-2, det, EPS);

    }

    @Test
    public void TransponTest() {
        Matrix2x2 m1 = new Matrix2x2(0, 1, 2, 3);
        Matrix2x2 m2 = new Matrix2x2(0, 2, 1, 3);
        m1.transpon();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(m1.m[i][j], m2.m[i][j], EPS);
            }
        }


    }

    @Test
    public void InverseTest() {
        Matrix2x2 m1 = new Matrix2x2();
        Matrix2x2 m2 = new Matrix2x2(1, 2, 3, 4);
        double det2 = m2.det();
        Matrix2x2 m3 = m1.inverseMatrix();
        Matrix2x2 m4 = m2.inverseMatrix();
        m2.multNumber2(1 / det2);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(m1.m[i][j], m3.m[i][j], EPS);
            }
        }
        Assert.assertEquals(m2.m[1][1], m4.m[0][0], EPS);
        Assert.assertEquals(-m2.m[0][1], m4.m[0][1], EPS);
        Assert.assertEquals(-m2.m[1][0], m4.m[1][0], EPS);
        Assert.assertEquals(m2.m[0][0], m4.m[1][1], EPS);

    }


    @Test
    public void EquivalentDiagonalTest() {
        Matrix2x2 matrix2x2 = new Matrix2x2();
        matrix2x2.equivalentDiagonal();
        Assert.assertEquals(matrix2x2.m[0][1], 0, EPS);
        Assert.assertEquals(matrix2x2.m[1][0], 0, EPS);
    }

}
