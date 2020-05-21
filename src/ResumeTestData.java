import model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume kislin = new Resume("uuid1", "Григорий Кислин");
        kislin.setContact(ContactType.PHONE, "+7(921) 855-0482");
        kislin.setContact(ContactType.SKYPE, "skype:grigory.kislin");
        kislin.setContact(ContactType.EMAIL, "mailto:gkislin@yandex.ru");
        kislin.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        kislin.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        kislin.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        kislin.setContact(ContactType.HOMEPAGE, "http://gkislin.ru/");

        kislin.setSection(
                SectionType.OBJECTIVE, new TextSection(
                        "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        kislin.setSection(
                SectionType.PERSONAL, new TextSection(
                        "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        kislin.setSection(SectionType.ACHIEVEMENT, new ListSection(
                Arrays.asList(
                        "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                        "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk."
                )
        ));

        kislin.setSection(SectionType.QUALIFICATIONS, new ListSection(
                Arrays.asList(
                        "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                        "Version control: Subversion, Git, Mercury, ClearCase, Perforce"
                )
        ));

        OrganizationName orgname1 = new OrganizationName("Java Online Projects", "http://javaops.ru/");
        Organization org1 = new Organization(
                "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок.",
                orgname1,
                LocalDate.of(2013, 10, 1),
                LocalDate.now()
        );
        OrganizationName orgname2 = new OrganizationName("Wrike", "https://www.wrike.com/");
        Organization org2 = new Organization(
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                orgname2,
                LocalDate.of(2014, 10, 1),
                LocalDate.of(2016, 1, 1)
        );
        kislin.setSection(SectionType.EXPERIENCE, new OrganizationsSection(Arrays.asList(org1, org2)));

        OrganizationName orgname3 = new OrganizationName("Coursera", "https://www.coursera.org/course/progfun");
        Organization org3 = new Organization(
                "\"Functional Programming Principles in Scala\" by Martin Odersky",
                "",
                orgname1,
                LocalDate.of(2013, 3, 1),
                LocalDate.of(2013, 5, 1)
        );
        OrganizationName orgname4 = new OrganizationName("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366");
        Organization org4 = new Organization(
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\" ",
                "",
                orgname1,
                LocalDate.of(2011, 3, 1),
                LocalDate.of(2011, 4, 1)
        );
        kislin.setSection(SectionType.EDUCATION, new OrganizationsSection(Arrays.asList(org3, org4)));

        System.out.println(kislin);
        System.out.println(kislin.getAll());

    }
}
