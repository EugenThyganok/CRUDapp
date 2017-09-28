import DAO.CountryDAO;
import DAO.IntrerfaceDAO;
import DAO.StudentDAO;
import DTO.Country;
import DTO.Groups;
import DTO.Marks;
import DTO.Student;
import javafx.util.converter.TimeStringConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

/**
 * Created by Eugen on 7/6/2017.
 */
public class Main {
    public static void main(String[] argc) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        CountryDAO demo = (CountryDAO) context.getBean(CountryDAO.class);
       // demo.update(new Student(1,"sdfd", "dfdf", 2, 2));
        Country country = demo.read(new Country(1, "sa", new Timestamp(24), new Timestamp(24), "sad"));
        System.out.println(context.getId() + " " + country.getName() + " " + country.getTime() + " " + country.getUpdateTime() + " " + country.getSymbolizedName());
        Class<CountryDAO> studentDAOClass = CountryDAO.class;


    }
}

/*JAVA CONFIG*/