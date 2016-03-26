
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static javafx.beans.binding.Bindings.when;


/**
 * Created by damirik on 26/02/16.
 */

public class ComplexMatrixTest {
    @Test
    public void constructorShouldWorkCorrectly() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        ComplexNumber complexNumber = ac.getBean("a",ComplexNumber.class);
        when(complexNumber.getA()).thenReturn(1.0);
        when(complexNumber.getB()).thenReturn(2.0);
        ComplexMatrix2x2 cm = new ComplexMatrix2x2(complexNumber);
        Assert.assertTrue(cm.getMas(0, 0).getA() == 1.0 && cm.getMas(0, 0).getB() == 2.0);

    }

    @Test
    public void constructorWith4ParamsShouldWorkCorrectly() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        ComplexNumber cn1 = ac.getBean("a",ComplexNumber.class);
        ComplexNumber cn2 = ac.getBean("b",ComplexNumber.class);
        ComplexNumber cn3 = ac.getBean("c",ComplexNumber.class);
        ComplexNumber cn4 = ac.getBean("d",ComplexNumber.class);
        when(cn1.getA()).thenReturn(1.0);
        when(cn1.getB()).thenReturn(2.0);
        when(cn2.getA()).thenReturn(-1.0);
        when(cn2.getB()).thenReturn(-2.0);
        when(cn3.getA()).thenReturn(-3.0);
        when(cn3.getB()).thenReturn(-4.0);
        when(cn4.getA()).thenReturn(3.0);
        when(cn4.getB()).thenReturn(4.0);
        ComplexMatrix2x2 cm = new ComplexMatrix2x2(cn1, cn2, cn3, cn4);
        Assert.assertTrue(cm.getMas(0, 0).getA() == cn1.getA() && cm.getMas(0, 0).getB() == cn1.getB() && cm.getMas(0, 1).getA() == cn2.getA() && cm.getMas(0, 1).getB() == cn2.getB());

    }

    public void methodAddShouldAddComplexMatrixesCorrectly() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        ComplexNumber cn1 = ac.getBean("a",ComplexNumber.class);
        ComplexNumber cn2 = ac.getBean("b",ComplexNumber.class);
        ComplexNumber cn3 = ac.getBean("c",ComplexNumber.class);
        ComplexNumber cn4 = ac.getBean("d",ComplexNumber.class);
        when(cn1.getA()).thenReturn(1.0);
        when(cn1.getB()).thenReturn(2.0);
        when(cn2.getA()).thenReturn(-1.0);
        when(cn2.getB()).thenReturn(-2.0);
        when(cn3.getA()).thenReturn(-3.0);
        when(cn3.getB()).thenReturn(-4.0);
        when(cn4.getA()).thenReturn(3.0);
        when(cn4.getB()).thenReturn(4.0);
        ComplexMatrix2x2 cm1 = new ComplexMatrix2x2(cn1, cn2, cn3, cn4);
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2(cn1, cn2, cn4, cn3);
        ComplexMatrix2x2 cm3 = cm1.add(cm2);

        Assert.assertTrue(cm3.getMas(0, 0).getA() == 2.0 && cm3.getMas(0, 0).getB() == 4.0 && cm3.getMas(0, 1).getA() == -2.0 && cm3.getMas(0, 1).getB() == -4.0 && cm3.getMas(1, 0).getA() == 0.0 && cm3.getMas(1, 0).getB() == 0.0 && cm3.getMas(1, 1).getA() == 0.0 && cm3.getMas(1, 1).getB() == 0.0);
    }

    public void methodMulthouldMultMatrixesCorrectly() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        ComplexNumber cn1 = ac.getBean("a",ComplexNumber.class);
        ComplexNumber cn2 = ac.getBean("b",ComplexNumber.class);
        ComplexNumber cn3 = ac.getBean("c",ComplexNumber.class);
        ComplexNumber cn4 = ac.getBean("d",ComplexNumber.class);
        when(cn1.getA()).thenReturn(1.0);
        when(cn1.getB()).thenReturn(2.0);
        when(cn2.getA()).thenReturn(-1.0);
        when(cn2.getB()).thenReturn(-2.0);
        when(cn3.getA()).thenReturn(-3.0);
        when(cn3.getB()).thenReturn(-4.0);
        when(cn4.getA()).thenReturn(3.0);
        when(cn4.getB()).thenReturn(4.0);
        ComplexMatrix2x2 cm1 = new ComplexMatrix2x2(cn1, cn2, cn3, cn4);
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2(cn1, cn2, cn4, cn3);
        ComplexMatrix2x2 cm3 = cm1.mult(cm2);
        Assert.assertTrue(cm3.getMas(0, 0).getA() == -2.0 && cm3.getMas(0, 0).getB() == -4.0 && cm3.getMas(1, 1).getA() == -6.0 && cm3.getMas(1, 1).getB() == -8.0);
    }

    public void metodDetShoulReturnCorrectDeterminant() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        ComplexNumber cn1 = ac.getBean("a",ComplexNumber.class);
        ComplexNumber cn2 = ac.getBean("b",ComplexNumber.class);
        ComplexNumber cn3 = ac.getBean("c",ComplexNumber.class);
        ComplexNumber cn4 = ac.getBean("d",ComplexNumber.class);
        when(cn1.getA()).thenReturn(1.0);
        when(cn1.getB()).thenReturn(2.0);
        when(cn2.getA()).thenReturn(-1.0);
        when(cn2.getB()).thenReturn(-2.0);
        when(cn3.getA()).thenReturn(-3.0);
        when(cn3.getB()).thenReturn(-4.0);
        when(cn4.getA()).thenReturn(3.0);
        when(cn4.getB()).thenReturn(4.0);
        ComplexMatrix2x2 cm1 = new ComplexMatrix2x2(cn1, cn2, cn3, cn4);
        ComplexNumber det = cm1.det();
        Assert.assertTrue(det.getA() == 0.0 && det.getB() == 0.0);
    }
}