import beans.Circle;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext context;
        context = new FileSystemXmlApplicationContext("E:\\LerningSpring\\src\\main\\java\\config\\appContext.xml");

        Circle circle1 = context.getBean(Circle.class);
        System.out.println(circle1.getCenter().getX());
        System.out.println(circle1.getCenter().getY());
        System.out.println(circle1.getRadius());

        context.close();
    }
}
