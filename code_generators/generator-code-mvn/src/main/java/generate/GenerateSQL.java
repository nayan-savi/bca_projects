package generate;

import common.StringWrap;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GenerateSQL {


    static String generateInsertSql(Class complaintsClass) {
        String insertSql = "INSERT INTO ${className} (${columnName}) VALUES (${columnValues}+\"')";
        Field[] declaredFields = complaintsClass.getDeclaredFields();
        String className = complaintsClass.getSimpleName();
        String declareName = className.toLowerCase();
        String columnValues = "${declare}.${getter}()";
        String columnName = Arrays.stream(declaredFields).map(Field::getName)
                .map(String::toUpperCase).collect(Collectors.joining(","));
        StringBuffer bf = new StringBuffer("'\"+");
        Arrays.stream(declaredFields).forEach(field -> {
            String getterName = StringWrap.getterByWord(field.getName());
            bf.append(columnValues.replace("${declare}", declareName).replace("${getter}", getterName));
            bf.append(",");
        });
        String values = bf.toString().substring(0, bf.toString().length() - 1).replace(",", "+ \"','\" +");
        insertSql = insertSql.replace("${className}", className.toUpperCase()).replace("${columnName}", columnName).replace("${columnValues}", values);
        return insertSql;
    }

}
