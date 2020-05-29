package storage;

import model.*;

import java.time.LocalDate;
import java.util.Arrays;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume test = getTestKislinResume();

        System.out.println(test);
        System.out.println(test.getAll());

    }

    public static Resume getTestKislinResume(){
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

        kislin.setSection(SectionType.EXPERIENCE, new OrganizationsSection(Arrays.asList(
                new Organization(
                        new OrganizationName("Java Online Projects", "http://javaops.ru/"),
                        "Автор проекта.",
                        "Создание, организация и проведение Java онлайн проектов и стажировок.",
                        LocalDate.of(2013, 10, 1),
                        LocalDate.now()
                ),
                new Organization(
                        new OrganizationName("Wrike", "https://www.wrike.com/"),
                        "Старший разработчик (backend)",
                        "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                        LocalDate.of(2014, 10, 1),
                        LocalDate.of(2016, 1, 1)
                ),
                new Organization(
                        new OrganizationName("RIT Center", ""),
                        "Java архитектор",
                        "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python",
                        LocalDate.of(2012, 4, 1),
                        LocalDate.of(2014, 10, 1)
                ),
                new Organization(
                        new OrganizationName("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/"),
                        "Ведущий программист",
                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.",
                        LocalDate.of(2010, 12, 1),
                        LocalDate.of(2012, 4, 1)
                ),
                new Organization(
                        new OrganizationName("Yota", "https://www.yota.ru/"),
                        "Ведущий специалист",
                        "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)",
                        LocalDate.of(2008, 6, 1),
                        LocalDate.of(2010, 12, 1)
                ),
                new Organization(
                        new OrganizationName("Enkata", "http://enkata.com/"),
                        "Разработчик ПО",
                        "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).",
                        LocalDate.of(2007, 3, 1),
                        LocalDate.of(2008, 6, 1)
                ),
                new Organization(
                        new OrganizationName("Siemens AG", "https://www.siemens.com/ru/ru/home.html"),
                        "Разработчик ПО",
                        "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).",
                        LocalDate.of(2005, 1, 1),
                        LocalDate.of(2006, 2, 1)
                ),
                new Organization(
                        new OrganizationName("Alcatel", "http://www.alcatel.ru/"),
                        "Инженер по аппаратному и программному тестированию",
                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).",
                        LocalDate.of(1997, 9, 1),
                        LocalDate.of(2005, 1, 1)
                )
        )));
        OrganizationName notDoubledOrganizationName = new OrganizationName(
                "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "http://www.ifmo.ru/");
        kislin.setSection(SectionType.EDUCATION, new OrganizationsSection(Arrays.asList(
                new Organization(
                        new OrganizationName("Coursera", "https://www.coursera.org/course/progfun"),
                        "\"Functional Programming Principles in Scala\" by Martin Odersky",
                        "",
                        LocalDate.of(2013, 3, 1),
                        LocalDate.of(2013, 5, 1)
                ),
                new Organization(
                        new OrganizationName("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366"),
                        "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\" ",
                        "",
                        LocalDate.of(2011, 3, 1),
                        LocalDate.of(2011, 4, 1)
                ),
                new Organization(
                        new OrganizationName("Siemens AG", "http://www.siemens.ru/"),
                        "3 месяца обучения мобильным IN сетям (Берлин)",
                        "",
                        LocalDate.of(2005, 1, 1),
                        LocalDate.of(2005, 4, 1)
                ),
                new Organization(
                        new OrganizationName("Alcatel", "http://www.alcatel.ru/"),
                        "6 месяцев обучения цифровым телефонным сетям (Москва)",
                        "",
                        LocalDate.of(1997, 9, 1),
                        LocalDate.of(1998, 3, 1)
                ),
                new Organization(
                        notDoubledOrganizationName,
                        "Аспирантура (программист С, С++)",
                        "",
                        LocalDate.of(1993, 9, 1),
                        LocalDate.of(1996, 7, 1)
                ),
                new Organization(
                        notDoubledOrganizationName,
                        "Инженер (программист Fortran, C)",
                        "",
                        LocalDate.of(1987, 9, 1),
                        LocalDate.of(1993, 7, 1)
                ),
                new Organization(
                        new OrganizationName("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/"),
                        "Закончил с отличием",
                        "",
                        LocalDate.of(1984, 9, 1),
                        LocalDate.of(1987, 6, 1)
                )
        )));
        return kislin;
    }
}
