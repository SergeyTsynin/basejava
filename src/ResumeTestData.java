import model.OrganizationName;
import model.Resume;

import java.util.Arrays;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume kislin = new Resume("uuid1", "Григорий Кислин");
//        kislin.setPhone("+7(921) 855-0482");
//        kislin.setSkype("skype:grigory.kislin");
//        kislin.setEmail("mailto:gkislin@yandex.ru");
//        kislin.setLinkedin("https://www.linkedin.com/in/gkislin");
//        kislin.setGithub("https://github.com/gkislin");
//        kislin.setStackoverflow("https://stackoverflow.com/users/548473");
//        kislin.setHomepage("http://gkislin.ru/");
//
//        kislin.setObjective("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
//        kislin.setPersonal("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
//
//        kislin.setAchievement(
//                Arrays.asList(
//                        "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
//                        "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk."
//                )
//        );
//
//        kislin.setQualifications(
//                Arrays.asList(
//                     "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
//                     "Version control: Subversion, Git, Mercury, ClearCase, Perforce"
//                )
//        );

        OrganizationName org1 = new OrganizationName("Java Online Projects","http://javaops.ru/");
        OrganizationName org2 = new OrganizationName("Wrike","https://www.wrike.com/");
        OrganizationName org3 = new OrganizationName("Coursera","https://www.coursera.org/course/progfun");
        OrganizationName org4 = new OrganizationName("Luxoft","http://www.luxoft-training.ru/training/catalog/course.html?ID=22366");
        System.out.println(org1);

//        System.out.println(kislin);
//        System.out.println(kislin.getAll());

    }
}
