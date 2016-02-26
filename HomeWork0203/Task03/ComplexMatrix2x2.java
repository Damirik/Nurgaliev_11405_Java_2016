/**
 * Created by damirik on 18/11/14.
 */
public class ComplexMatrix2x2 {
    private ComplexNumber[][] mas = new ComplexNumber[2][2];

    public ComplexMatrix2x2() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.mas[i][j] = new ComplexNumber();
            }
        }
    }

    public ComplexMatrix2x2(ComplexNumber complexNumber) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.mas[i][j] = complexNumber;
            }
        }
    }

    public ComplexMatrix2x2(ComplexNumber x1, ComplexNumber x2, ComplexNumber x3, ComplexNumber x4) {
        mas[0][0] = x1;
        mas[0][1] = x2;
        mas[1][0] = x2;
        mas[1][1] = x4;
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 m) {
        ComplexMatrix2x2 complexMatrix2x2 = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                complexMatrix2x2.mas[i][j] = this.mas[i][j].add(m.mas[i][j]);
            }
        }
        return complexMatrix2x2;
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 a) {
        ComplexMatrix2x2 m = new ComplexMatrix2x2();
        m.mas[0][0] = mas[0][0].mult(a.mas[0][0]).add(mas[0][1].mult(a.mas[1][0]));
        m.mas[0][1] = mas[0][0].mult(a.mas[0][1]).add(mas[0][1].mult(a.mas[1][1]));
        m.mas[1][0] = mas[1][0].mult(a.mas[0][0]).add(mas[1][1].mult(a.mas[1][0]));
        m.mas[1][1] = mas[1][0].mult(a.mas[0][1]).add(mas[1][1].mult(a.mas[1][1]));
        return m;
    }

    public ComplexNumber det() {
        ComplexNumber d = mas[0][0].mult(mas[1][1]).sub(mas[1][0].mult(mas[0][1]));
        return d;
    }

    public ComplexNumber getMas(int i, int j) {
        return mas[i][j];
    }
}