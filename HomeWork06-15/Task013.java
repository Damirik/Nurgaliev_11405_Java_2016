import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Дамир on 26.03.2016.
 */

@Aspect
public class Task013 {
    @Before("execution(* *..*.setEmail(String))")
    public void Object(JoinPoint jp){
        String s  = (String) jp.getArgs()[0];
        Pattern p = Pattern.compile("^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*");
        Matcher m = p.matcher(s);
        if (m.find()){
            System.out.println("Email correct");
        }else{
            System.out.println("Email not correct");
        }
    }

}