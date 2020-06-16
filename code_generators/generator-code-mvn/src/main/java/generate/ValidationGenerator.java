package generate;

import com.voilation.traffic.model.Complaint;
import common.StringWrap;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ValidationGenerator {
    public static String generateJavaScript(Class complaintsClass) {
        String declareTemplate = "var ${field} = document.${formName}.${field}.value;";

        String template = "if(${field} == null || ${field} == \"\") {\n" +
                "\talert('${name} is mandatory');\n" +
                "\tdocument.${formName}.${field}.focus();\n" +
                "\treturn false;\n" +
                "}";

        StringBuffer bf = new StringBuffer();

        String formName = complaintsClass.getSimpleName().toLowerCase();
        Field[] declaredFields = complaintsClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            String fields = field.getName();
            String declare = declare(declareTemplate, fields, formName);
            bf.append(declare+"\n");

        });
        bf.append("\n");

        Arrays.stream(declaredFields).forEach(field -> {
            String name = StringWrap.wordCapitalize(field.getName());
            String fields = field.getName();
            String logic = logic(template, fields, formName, name);
            System.out.println();
            bf.append(logic +" else \n");
        });
        return bf.toString();
    }

    private static String declare(String declareTemplate, String fields, String formName) {
        return declareTemplate.replace("${field}", fields).replace("${formName}", formName);
    }

    private static String logic(String template, String fields, String formName, String name) {
        return template.replace("${field}", fields).replace("${formName}", formName)
                .replace("${name}", name);
    }

}
