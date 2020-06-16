package generate;

import common.StringWrap;

import java.lang.reflect.Field;
import java.util.Arrays;

public class GenerateController {

    public static String generateController(Class complaintsClass, String controller) {
        String set = "${declareName}.${setter}(request.getParameter(\"${name}\"));";
        Field[] declaredFields = complaintsClass.getDeclaredFields();
        String className = complaintsClass.getSimpleName();
        String declareName = className.toLowerCase();
        StringBuffer bf = new StringBuffer();
        Arrays.stream(declaredFields).forEach(field -> {
            String setterName = StringWrap.setterByWord(field.getName());
            String name = field.getName();
            String replace = set.replace("${declareName}", declareName).replace("${setter}", setterName).replace("${name}", name);
            bf.append(replace + "\n");
        });
        controller = controller.replace("${className}", className).replace("${declareName}", declareName)
                .replace("${setData}", bf.toString());

        return controller;
    }

    public static String generateDaoImpl(Class complaintsClass, String daoImpl) {
        String setDbData = "${declareName}.${setter}(rs.getString(\"${columnName}\"));";
        Field[] declaredFields = complaintsClass.getDeclaredFields();
        String className = complaintsClass.getSimpleName();
        String declareName = className.toLowerCase();
        StringBuffer bf = new StringBuffer();

        Arrays.stream(declaredFields).forEach(field -> {
            String setterName = StringWrap.setterByWord(field.getName());
            String replace = setDbData.replace("${declareName}", declareName).replace("${setter}", setterName)
                    .replace("${columnName}", field.getName().toUpperCase());
            bf.append(replace + "\n");
        });
        daoImpl = daoImpl.replace("${className}", className).replace("${declareName}", declareName)
                .replace("${view}", className.toUpperCase())
                .replace("${setDbData}", bf.toString()).replace("${insert}", GenerateSQL.generateInsertSql(complaintsClass));

        return daoImpl;
    }

    public static String generateInterface(Class complaintsClass, String inter) {
        String className = complaintsClass.getSimpleName();
        String declareName = className.toLowerCase();
        inter = inter.replace("${className}", className).replace("${declareName}", declareName);
        return inter;
    }

}
