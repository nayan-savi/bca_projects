package generate;

import com.voilation.traffic.model.Complaint;
import com.voilation.traffic.model.Vehicle;
import common.StringWrap;

import java.lang.reflect.Field;
import java.util.Arrays;

public class GenerateDaoImpl {

    public static void main(String[] args) {
        Class aClass = Vehicle.class;
        generateUpdateImpl(aClass);

    }

    static String generateUpdateImpl(Class complaintsClass) {

        String setter =  "${declareName}.${setter}(rs.getString(\"${name}\"));";
        Field[] declaredFields = complaintsClass.getDeclaredFields();
        String className = complaintsClass.getSimpleName();
        String declareName = className.toLowerCase();

        Arrays.stream(declaredFields).forEach(field -> {
            String setterName = StringWrap.setterByWord(field.getName());
            String replace = setter.replace("${declareName}", declareName).replace("${setter}", setterName)
                    .replace("${name}", field.getName().toUpperCase());
            System.out.println(replace);
        });
        return "";
    }

}
