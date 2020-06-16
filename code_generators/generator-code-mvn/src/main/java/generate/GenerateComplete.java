package generate;

import com.system.bugtracker.model.Employee;
import com.system.bugtracker.model.Ticket;
import common.StringWrap;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GenerateComplete {
    public static void main(String[] args) throws IOException {
        String type = "view";
        Class aClass = Ticket.class;

        if (type.equals("add")) {
            String path = "src/main/resources/add.txt";
            System.out.println(add(aClass, GenerateComplete.readContentFromFile(path)));
        } else if (type.equals("view")) {
            String path = "src/main/resources/view.txt";
            System.out.println(view(aClass, GenerateComplete.readContentFromFile(path)));
        } else if (type.equals("modify")) {
            String path = "src/main/resources/modify.txt";
            System.out.println(modify(aClass, GenerateComplete.readContentFromFile(path)));
        } else if(type.equals("controllerIntImpl")) {
            String controller = "src/main/resources/controller.txt";
            System.out.println(GenerateController.generateController(aClass, GenerateComplete.readContentFromFile(controller)));
            System.out.println();
            String inter = "src/main/resources/interface.txt";
            System.out.println(GenerateController.generateInterface(aClass, GenerateComplete.readContentFromFile(inter)));
            System.out.println();
            String impl = "src/main/resources/impl.txt";
            System.out.println(GenerateController.generateDaoImpl(aClass, GenerateComplete.readContentFromFile(impl)));
        }
    }

    static String readContentFromFile(String path) throws IOException {
        return Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String modify(Class complaintsClass, String modify) {
        StringBuffer bf = new StringBuffer();
        String rowTrModify = "<tr>\n" +
                "\t<td>${columnName}</td>\n" +
                "\t<td><input type=\"text\" name=\"${name}\" value=\"<%=${dname}.${getterName}() %>\"/></td>\n" +
                "</tr>";
        Field[] declaredFields = complaintsClass.getDeclaredFields();
        String dname = complaintsClass.getSimpleName().toLowerCase();
        String packageName = complaintsClass.getTypeName();
        String className = complaintsClass.getSimpleName();
        String declareName = className.toLowerCase();
        Arrays.stream(declaredFields).forEach(field -> {
            String columnName = StringWrap.wordCapitalize(field.getName());
            String getterName = StringWrap.getterByWord(field.getName());
            String name = field.getName();
            String replace = rowTrModify.replace("${columnName}", columnName).replace("${name}", name)
                    .replace("${dname}", dname).replace("${getterName}", getterName);
            bf.append("\n" + replace);
        });

        modify = modify.replace("${rowData}", bf.toString()).replace("${package}", packageName)
                .replace("${declare}", declareName).replace("${className}", className);
        return modify;
    }

    static String add(Class complaintsClass, String add) {
        Field[] declaredFields = complaintsClass.getDeclaredFields();
        String className = complaintsClass.getSimpleName();
        String dname = className.toLowerCase();
        StringBuffer bf = new StringBuffer();
        String addTr = "<tr><td>${columnName}</td><td><input type=\"text\" name=\"${name}\"/></td></tr>";
        Arrays.stream(declaredFields).forEach(field -> {
            String columnName = StringWrap.wordCapitalize(field.getName());
            String name = field.getName();
            String replace = addTr.replace("${columnName}", columnName).replace("${className}", className)
                    .replace("${name}", name);
            bf.append("\n" + replace);
        });

        add = add.replace("${trData}", bf.toString())
                .replace("${javascriptValidation}", ValidationGenerator.generateJavaScript(complaintsClass))
                .replace("${name}", dname);

        return add;
    }

    static String view(Class complaintsClass, String view) {
        Field[] declaredFields = complaintsClass.getDeclaredFields();
        String viewTd = "<td><%=${declare}.get(i).${getterName}()%></td>";
        String viewTh = "<td>${displayName}</td>";
        String className = complaintsClass.getSimpleName();
        String declareName = className.toLowerCase();
        String packageName = complaintsClass.getTypeName();
        StringBuffer viewTdBr = new StringBuffer();

        Arrays.stream(declaredFields).forEach(field -> {
            String getterName = StringWrap.getterByWord(field.getName());
            String replace = viewTd.replace("${declare}", declareName).replace("${getterName}", getterName);
            viewTdBr.append(replace + "\n");
        });

        StringBuffer viewTdTh = new StringBuffer();
        Arrays.stream(declaredFields).forEach(field -> {
            String displayName = StringWrap.wordCapitalize(field.getName());
            String replace = viewTh.replace("${displayName}", displayName);
            viewTdTh.append(replace+"\n");
        });

        view = view.replace("${data}", viewTdBr.toString())
                .replace("${headers}", viewTdTh.toString())
                .replace("${declare}", declareName).replace("${package}", packageName)
                .replace("${className}", className).replace("${declare}", declareName);

        return view;
    }
}
