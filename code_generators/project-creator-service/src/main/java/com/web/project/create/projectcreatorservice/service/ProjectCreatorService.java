package com.web.project.create.projectcreatorservice.service;

import com.web.project.create.projectcreatorservice.funcinterface.CreateFileWrite;
import com.web.project.create.projectcreatorservice.model.Project;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProjectCreatorService {

    private static String _packages = "";
    private final Map<String, String> replaceStringMap = new HashMap<>();
    private String displayName;


    /*public static void main(String[] args) {
        Project project = new Project();
        project.setProjectName("first-project");
        project.setProjectPath("F:/ProjectCreated");
        project.setPackageName("com.first.project");

        new ProjectCreatorService().createProject(project);
    }*/


    CreateFileWrite<Map<String, String>, String, String, String, Boolean, Boolean> createFileWrite = (replaceStringMap, templatePath, createPath, fileName, hasReplace) -> {
        try {
            Path _project = Paths.get(createPath +"/"+ fileName);
            Files.createFile(_project);
            String content = readContentFromFile(templatePath);
            if(hasReplace) {
                for(Map.Entry<String, String> entries : replaceStringMap.entrySet()) {
                    content = content.replace(entries.getKey(), entries.getValue());
                }
            }
            Files.write(_project, content.getBytes());
        } catch (IOException e) {
            return false;
        }
        return true;
    };

    public void createProject(Project project) {
        createFolderStructures(project);
        createSettingsFiles(project);
        createConfigFiles(project);
        createControllerClasses(project);
        createDaoClasses(project);
        createUtilClasses(project);
        createModelClasses(project);
        createJspPages(project);
        createSql(project);
        System.out.println("=============================");
        System.out.println("Need to be taken care manually by user \n1. Create Database and tables \n2. Load all images css and js files to project folder \n3. Import as web project in Eclipse ");
    }

    private void createFolderStructures(Project project) {
        displayName = project.getProjectName().replace("-", "");
        replaceStringMap.put("${projectName}", project.getProjectName());
        replaceStringMap.put("${packageName}", project.getPackageName());
        replaceStringMap.put("${databaseName}", displayName);
        String directories = project.getProjectPath() + "/" + project.getProjectName();
        String src = "src";
        String webContent = "WebContent";
        String setting = ".settings";
        String metaInf = "META-INF";
        String webInf = "../WEB-INF";
        String sql = "sql";
        String css = "../../css";
        String js = "../js";
        String images = "../images";
        String jspLogin = "../jsp/login";
        String jspAdmin = "../admin";
        String modules = "controller/../model/../util/../dao";
        _packages = getPackages(project);
        Path settingPath = Paths.get(directories, setting);
        Path srcPath = Paths.get(directories, src, _packages, modules);
        Path webPath = Paths.get(directories, webContent, metaInf, webInf, sql, css, js, images, jspLogin, jspAdmin);
        try {
            Files.createDirectories(settingPath);
            Files.createDirectories(srcPath);
            Files.createDirectories(webPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createSql(Project project) {
        String location = project.getAbsolutePath()+"/WebContent/WEB-INF/sql";

        // SQL
        String sqlTemplate = "src/main/resources/templates/sql/query.txt";
        String sqlFileName = displayName+".sql";
        Boolean sqlResult = createFileWrite.apply(replaceStringMap, sqlTemplate, location, sqlFileName, true);
        System.out.println("Config File "+sqlFileName+" created: "+ sqlResult);
    }

    private void createSettingsFiles(Project project) {
        String location = project.getAbsolutePath()+"/.settings";

        // File 1
        String file1Template = "src/main/resources/templates/setting/file1.txt";
        String file1FileName = ".jsdtscope";
        Boolean file1Result = createFileWrite.apply(replaceStringMap, file1Template, location, file1FileName, false);
        System.out.println("Config File "+file1FileName+" created: "+ file1Result);

        // File 2
        String file2Template = "src/main/resources/templates/setting/file2.txt";
        String file2FileName = "org.eclipse.jdt.core.prefs";
        Boolean file2Result = createFileWrite.apply(replaceStringMap, file2Template, location, file2FileName, false);
        System.out.println("Config File "+file2FileName+" created: "+ file2Result);

        // File 3
        String file3Template = "src/main/resources/templates/setting/file3.txt";
        String file3FileName = "org.eclipse.wst.common.component";
        Boolean file3Result = createFileWrite.apply(replaceStringMap, file3Template, location, file3FileName, true);
        System.out.println("Config File "+file3FileName+" created: "+ file3Result);

        // File 4
        String file4Template = "src/main/resources/templates/setting/file4.txt";
        String file4FileName = "org.eclipse.wst.common.project.facet.core.xml";
        Boolean file4Result = createFileWrite.apply(replaceStringMap, file4Template, location, file4FileName, false);
        System.out.println("Config File "+file4FileName+" created: "+ file4Result);

        // File 5
        String file5Template = "src/main/resources/templates/setting/file5.txt";
        String file5FileName = "org.eclipse.wst.jsdt.ui.superType.container";
        Boolean file5Result = createFileWrite.apply(replaceStringMap, file5Template, location, file5FileName, false);
        System.out.println("Config File "+file5FileName+" created: "+ file5Result);

        // File 6
        String file6Template = "src/main/resources/templates/setting/file6.txt";
        String file6FileName = "org.eclipse.wst.jsdt.ui.superType.name";
        Boolean file6Result = createFileWrite.apply(replaceStringMap, file6Template, location, file6FileName, false);
        System.out.println("Config File "+file6FileName+" created: "+ file6Result);
    }

    private void createUtilClasses(Project project) {
        String location = project.getAbsolutePath()+"/src/"+_packages+"/util";

        // ConnectionDb
        String dbTemplate = "src/main/resources/templates/connectdb.txt";
        String dbFileName = "ConnectionDb.java";
        Boolean dbResult = createFileWrite.apply(replaceStringMap, dbTemplate, location, dbFileName, true);
        System.out.println("Config File "+dbFileName+" created: "+ dbResult);
    }

    private void createJspPages(Project project) {
        String location = project.getAbsolutePath()+"/WebContent/jsp/login";

        // Login
        String loginTemplate = "src/main/resources/templates/jsp/login.txt";
        String loginFileName = "login.jsp";
        Boolean loginResult = createFileWrite.apply(replaceStringMap, loginTemplate, location, loginFileName, true);
        System.out.println("Config File "+loginFileName+" created: "+ loginResult);

        // Login Details
        String loginDetailsTemplate = "src/main/resources/templates/jsp/login_details.txt";
        String loginDetailsFileName = "loginDetails.jsp";
        Boolean loginDetailsResult = createFileWrite.apply(replaceStringMap, loginDetailsTemplate, location, loginDetailsFileName, true);
        System.out.println("Config File "+loginDetailsFileName+" created: "+ loginDetailsResult);

        // Registration
        String regImplTemplate = "src/main/resources/templates/jsp/reg.txt";
        String regImplFileName = "registration.jsp";
        Boolean regResult = createFileWrite.apply(replaceStringMap, regImplTemplate, location, regImplFileName,  true);
        System.out.println("Config File "+regImplFileName+" created: "+ regResult);

        location = project.getAbsolutePath()+"/WebContent/jsp/admin";
        String adminHeaderTemplate = "src/main/resources/templates/jsp/admin_header.txt";
        String adminHeaderFileName = "adminHeader.jsp";
        Boolean adminHeaderResult = createFileWrite.apply(replaceStringMap, adminHeaderTemplate, location, adminHeaderFileName,  true);
        System.out.println("Config File "+adminHeaderFileName+" created: "+ adminHeaderResult);

        String adminHomeTemplate = "src/main/resources/templates/jsp/admin_home.txt";
        String adminHomeFileName = "adminHome.jsp";
        Boolean adminHomeResult = createFileWrite.apply(replaceStringMap, adminHomeTemplate, location, adminHomeFileName,  false);
        System.out.println("Config File "+adminHomeFileName+" created: "+ adminHomeResult);

        location = project.getAbsolutePath()+"/WebContent/jsp";
        String footTemplate = "src/main/resources/templates/jsp/footer.txt";
        String footFileName = "footer.jsp";
        Boolean footResult = createFileWrite.apply(replaceStringMap, footTemplate, location, footFileName,  false);
        System.out.println("Config File "+footFileName+" created: "+ footResult);

        String logoutTemplate = "src/main/resources/templates/jsp/logout.txt";
        String logoutFileName = "logout.jsp";
        Boolean logoutResult = createFileWrite.apply(replaceStringMap, logoutTemplate, location, logoutFileName,  false);
        System.out.println("Config File "+logoutFileName+" created: "+ logoutResult);
    }

    private void createModelClasses(Project project) {
        String location = project.getAbsolutePath()+"/src/"+_packages+"/model";

        // Login
        String loginTemplate = "src/main/resources/templates/login.txt";
        String loginFileName = "Login.java";
        Boolean loginResult = createFileWrite.apply(replaceStringMap, loginTemplate, location, loginFileName, true);
        System.out.println("Config File "+loginFileName+" created: "+ loginResult);

        // Registration
        String regImplTemplate = "src/main/resources/templates/registation.txt";
        String regImplFileName = "Registration.java";
        Boolean regResult = createFileWrite.apply(replaceStringMap, regImplTemplate, location, regImplFileName, true);
        System.out.println("Config File "+regImplFileName+" created: "+ regResult);
    }

    private void createDaoClasses(Project project) {

        String location = project.getAbsolutePath()+"/src/"+_packages+"/dao";

        // LoginDao
        String loginDaoTemplate = "src/main/resources/templates/login_dao.txt";
        String loginDaoFileName = "LoginDao.java";
        Boolean loginDaoResult = createFileWrite.apply(replaceStringMap, loginDaoTemplate, location, loginDaoFileName,  true);
        System.out.println("Config File "+loginDaoFileName+" created: "+ loginDaoResult);

        // LoginDaoImpl
        String loginDaoImplTemplate = "src/main/resources/templates/login_dao_impl.txt";
        String loginDaoImplFileName = "LoginDaoImpl.java";
        Boolean loginDaoImplResult = createFileWrite.apply(replaceStringMap, loginDaoImplTemplate, location, loginDaoImplFileName,  true);
        System.out.println("Config File "+loginDaoFileName+" created: "+ loginDaoImplResult);

        // RegistrationDao
        String regDaoTemplate = "src/main/resources/templates/reg_dao.txt";
        String regDaoFileName = "RegistrationDao.java";
        Boolean regDaoResult = createFileWrite.apply(replaceStringMap, regDaoTemplate, location, regDaoFileName,  true);
        System.out.println("Config File "+regDaoFileName+" created: "+ regDaoResult);

        // RegistrationDaoImpl
        String regDaoImplTemplate = "src/main/resources/templates/reg_dao_impl.txt";
        String regDaoImplFileName = "RegistrationDaoImpl.java";
        Boolean regDaoImplResult = createFileWrite.apply(replaceStringMap, regDaoImplTemplate, location, regDaoImplFileName,  true);
        System.out.println("Config File "+regDaoFileName+" created: "+ regDaoImplResult);

    }

    private void createControllerClasses(Project project) {
        String location = project.getAbsolutePath()+"/src/"+_packages+"/controller";

        // Login Controller
        String controllerTemplate = "src/main/resources/templates/login_controller.txt";
        String controllerFileName = "LoginController.java";
        Boolean projectResult = createFileWrite.apply(replaceStringMap, controllerTemplate, location, controllerFileName,  true);
        System.out.println("Config File "+controllerFileName+" created: "+ projectResult);

        // Registration Controller
        String regTemplate = "src/main/resources/templates/registration_controller.txt";
        String regFileName = "RegistrationController.java";
        Boolean regResult = createFileWrite.apply(replaceStringMap, regTemplate, location, regFileName,  true);
        System.out.println("Config File "+regFileName+" created: "+ regResult);

    }

    private void createConfigFiles(Project project) {
        String location = "";
        String projectTemplate = "src/main/resources/templates/project.txt";
        String projectFileName = ".project";
        location = project.getAbsolutePath();
        Boolean projectResult = createFileWrite.apply(replaceStringMap, projectTemplate, location,projectFileName,  true);
        System.out.println("Config File "+projectFileName+" created: "+ projectResult);

        String webTemplate = "src/main/resources/templates/web.txt";
        String webFileName = "web.xml";
        location = project.getAbsolutePath()+"/WebContent/WEB-INF/";
        Boolean webResult = createFileWrite.apply(replaceStringMap, webTemplate, location, webFileName,  true);
        System.out.println("Config File "+webFileName+" created: "+webResult);

        String classPathTemplate = "src/main/resources/templates/classpath.txt";
        String classPathFileName = ".classpath";
        location = project.getAbsolutePath();
        Boolean classPathResult = createFileWrite.apply(replaceStringMap, classPathTemplate, location, classPathFileName,  false);
        System.out.println("Config File "+classPathResult+" created: "+classPathResult);


    }

    private String getPackages(Project project) {
        return Arrays.stream(project.getPackageName().split("\\.")).collect(Collectors.joining("/"));
    }

    static String readContentFromFile(String path) throws IOException {
        return Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
