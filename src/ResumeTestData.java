import model.Organization;
import model.OrganizationName;
import model.OrganizationSection;
import model.Resume;

import java.util.Arrays;
import java.util.Date;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume kislin = new Resume("uuid1", "Григорий Кислин");
        kislin.setPhone("+7(921) 855-0482");
        kislin.setSkype("skype:grigory.kislin");
        kislin.setEmail("mailto:gkislin@yandex.ru");
        kislin.setLinkedin("https://www.linkedin.com/in/gkislin");
        kislin.setGithub("https://github.com/gkislin");
        kislin.setStackoverflow("https://stackoverflow.com/users/548473");
        kislin.setHomepage("http://gkislin.ru/");

        kislin.setObjective("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        kislin.setPersonal("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");

        kislin.setAchievement(
                Arrays.asList(
                        "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                        "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk."
                )
        );

        kislin.setQualifications(
                Arrays.asList(
                        "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                        "Version control: Subversion, Git, Mercury, ClearCase, Perforce"
                )
        );

        OrganizationName orgname1 = new OrganizationName("Java Online Projects", "http://javaops.ru/");
        Organization org1 = new Organization(
                "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок.",
                orgname1,
                new Date(113, 9, 1),
                new Date()
        );
        OrganizationName orgname2 = new OrganizationName("Wrike", "https://www.wrike.com/");
        Organization org2 = new Organization(
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                orgname2,
                new Date(114, 9, 1),
                new Date(116, 0, 1)
        );
        kislin.setExperience(Arrays.asList(org1, org2));

        OrganizationName orgname3 = new OrganizationName("Coursera", "https://www.coursera.org/course/progfun");
        Organization org3 = new Organization(
                "\"Functional Programming Principles in Scala\" by Martin Odersky",
                "",
                orgname1,
                new Date(113, 2, 1),
                new Date(113, 4, 1)
        );
        OrganizationName orgname4 = new OrganizationName("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366");
        Organization org4 = new Organization(
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\" ",
                "",
                orgname1,
                new Date(111, 2, 1),
                new Date(111, 3, 1)
        );
        kislin.setEducation(Arrays.asList(org3, org4));

        System.out.println(kislin);
        System.out.println(kislin.getAll());

    }
}
