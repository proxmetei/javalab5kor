import java.lang.reflect.Field;
import java.util.Properties;
import java.lang.annotation.Annotation;
import java.io.FileReader;
import java.io.IOException;


public class Injector {
    FileReader fileReader = null;
    Properties properties = new Properties();
    public Injector(){
        try{
            fileReader = new FileReader("src/main/resources/injection.properties");
            properties.load(fileReader);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public <T> void inject(T object) throws InstantiationException,IllegalAccessException {
        Class objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();
        for(Field field:fields){
            Annotation fieldAnnotation = field.getAnnotation(AutoInjectable.class);
            if(fieldAnnotation!=null){
                field.setAccessible(true);
                Class res =null;
                try{
                    String className = (String) properties.get(field.getType().getTypeName());
                    res = Class.forName(className);
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
                field.set(object, res.newInstance());
            }
        }
    }
}
