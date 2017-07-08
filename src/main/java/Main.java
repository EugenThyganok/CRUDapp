import Bean.BeanClass;
import DTO.Groups;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Eugen on 7/6/2017.
 */
public class Main {
    public static void main(String[] argc) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        BeanClass<Groups> demo = (BeanClass) context.getBean("db");

        demo.update(new Groups(1,"DBTheory"));
    }
}
