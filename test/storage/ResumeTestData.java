package storage;

import model.*;

import java.time.LocalDate;
import java.util.*;

public class ResumeTestData {
    public static void main(String[] args) {
//        Resume test = getTestKislinResume();
        Resume test = getFakeResume("uuid42");
        System.out.println(test);
        System.out.println(test.getAll());
    }

    private static Resume getTestKislinResume() {
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
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Автор проекта.",
                                        "Создание, организация и проведение Java онлайн проектов и стажировок.",
                                        LocalDate.of(2013, 10, 1),
                                        LocalDate.now()
                                )))
                ),
                new Organization(
                        new OrganizationName("Wrike", "https://www.wrike.com/"),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Старший разработчик (backend)",
                                        "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                                        LocalDate.of(2014, 10, 1),
                                        LocalDate.of(2016, 1, 1)
                                )))
                ),
                new Organization(
                        new OrganizationName("RIT Center", ""),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Java архитектор",
                                        "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python",
                                        LocalDate.of(2012, 4, 1),
                                        LocalDate.of(2014, 10, 1)
                                )))
                ),
                new Organization(
                        new OrganizationName("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/"),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Ведущий программист",
                                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.",
                                        LocalDate.of(2010, 12, 1),
                                        LocalDate.of(2012, 4, 1)
                                )))
                ),
                new Organization(
                        new OrganizationName("Yota", "https://www.yota.ru/"),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Ведущий специалист",
                                        "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)",
                                        LocalDate.of(2008, 6, 1),
                                        LocalDate.of(2010, 12, 1)
                                )))
                ),
                new Organization(
                        new OrganizationName("Enkata", "http://enkata.com/"),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Разработчик ПО",
                                        "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).",
                                        LocalDate.of(2007, 3, 1),
                                        LocalDate.of(2008, 6, 1)
                                )))
                ),
                new Organization(
                        new OrganizationName("Siemens AG", "https://www.siemens.com/ru/ru/home.html"),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Разработчик ПО",
                                        "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).",
                                        LocalDate.of(2005, 1, 1),
                                        LocalDate.of(2006, 2, 1)
                                )))
                ),
                new Organization(
                        new OrganizationName("Alcatel", "http://www.alcatel.ru/"),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Инженер по аппаратному и программному тестированию",
                                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).",
                                        LocalDate.of(1997, 9, 1),
                                        LocalDate.of(2005, 1, 1)
                                )))
                )
        )));
        OrganizationName notDoubledOrganizationName = new OrganizationName(
                "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "http://www.ifmo.ru/");
        kislin.setSection(SectionType.EDUCATION, new OrganizationsSection(Arrays.asList(
                new Organization(
                        new OrganizationName("Coursera", "https://www.coursera.org/course/progfun"),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "\"Functional Programming Principles in Scala\" by Martin Odersky",
                                        null,
                                        LocalDate.of(2013, 3, 1),
                                        LocalDate.of(2013, 5, 1)
                                )))
                ),
                new Organization(
                        new OrganizationName("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366"),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\" ",
                                        null,
                                        LocalDate.of(2011, 3, 1),
                                        LocalDate.of(2011, 4, 1)
                                )))
                ),
                new Organization(
                        new OrganizationName("Siemens AG", "http://www.siemens.ru/"),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "3 месяца обучения мобильным IN сетям (Берлин)",
                                        null,
                                        LocalDate.of(2005, 1, 1),
                                        LocalDate.of(2005, 4, 1)
                                )))
                ),
                new Organization(
                        new OrganizationName("Alcatel", "http://www.alcatel.ru/"),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "6 месяцев обучения цифровым телефонным сетям (Москва)",
                                        null,
                                        LocalDate.of(1997, 9, 1),
                                        LocalDate.of(1998, 3, 1)
                                )))
                ),
                new Organization(
                        notDoubledOrganizationName,
                        new ArrayList<>(Arrays.asList(
                                new Position(
                                        "Аспирантура (программист С, С++)",
                                        null,
                                        LocalDate.of(1993, 9, 1),
                                        LocalDate.of(1996, 7, 1)
                                ),
                                new Position(
                                        "Инженер (программист Fortran, C)",
                                        null,
                                        LocalDate.of(1987, 9, 1),
                                        LocalDate.of(1993, 7, 1)
                                )))
                ),
                new Organization(
                        new OrganizationName("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/"),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Закончил с отличием",
                                        null,
                                        LocalDate.of(1984, 9, 1),
                                        LocalDate.of(1987, 6, 1)
                                )))
                )
        )));
        return kislin;
    }

    static Resume getFakeResume(String uuid) {

        final Random rnd = new Random();
        String[] firstName = new String[]{"Марина", "Светлана", "Ирина", "Анна"};
        String[] lastName = new String[]{"Киселёва", "Петрова", "Васильева", "Михайлова"};
        String fullName = firstName[rnd.nextInt(4)] + " " +
                lastName[rnd.nextInt(4)];

        Resume guineaPig = new Resume(uuid, fullName);

        String convertedFN = transliterate(fullName);
        int pointPosition = convertedFN.indexOf(".");
        String fullNameWithoutPoint = convertedFN.substring(0, pointPosition) +
                convertedFN.substring(pointPosition + 1);

        guineaPig.setContact(ContactType.PHONE, "+7(921) 555-" + (rnd.nextInt(9000) + 1000));
        guineaPig.setContact(ContactType.SKYPE, "skype:" + convertedFN);
        guineaPig.setContact(ContactType.EMAIL, "mailto:" + convertedFN + "@gmail.com");
        guineaPig.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/" + fullNameWithoutPoint);
        guineaPig.setContact(ContactType.GITHUB, "https://github.com/" + fullNameWithoutPoint);
        guineaPig.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/" +
                (rnd.nextInt(900000) + 100000));
        guineaPig.setContact(ContactType.HOMEPAGE, "http://" + fullNameWithoutPoint + ".ua/");

        guineaPig.setSection(
                SectionType.OBJECTIVE, new TextSection(
                        "Универсальный специалист со случайным номером: " +
                                (rnd.nextInt(900000) + 100000)));

        List<String> p1 = new ArrayList<>();
        p1.add("аналитический");
        p1.add("альтернативный");
        p1.add("креативный");
        p1.add("внимательный");
        p1.add("исключительный");
        List<String> p2 = new ArrayList<>();
        p2.add("склад ума");
        p2.add("подход к решению задач");
        p2.add("взгляд на жизнь");
        p2.add("подход к людям");
        p2.add("идиотизм");
        StringBuilder personal = new StringBuilder();
        int count = 5;
        final int STOP = 3;
        for (int i = 0; i < STOP; i++) {
            int pointer1 = rnd.nextInt(count);
            int pointer2 = rnd.nextInt(count);
            personal.append(p1.get(pointer1)).append(" ");
            personal.append(p2.get(pointer2));
            if (i < STOP - 1) {
                personal.append(", ");
            } else {
                personal.append(".");
            }
            p1.remove(pointer1);
            p2.remove(pointer2);
            count -= 1;
        }
        personal.replace(0, 1, personal.substring(0, 1).toUpperCase());
        guineaPig.setSection(
                SectionType.PERSONAL, new TextSection(personal.toString()));

        guineaPig.setSection(SectionType.ACHIEVEMENT, new ListSection(
                getAchievementList()
        ));

        guineaPig.setSection(SectionType.QUALIFICATIONS, new ListSection(
                Arrays.asList(
                        "JBoss, Tomcat, Jetty, WebLogic, WSO2",
                        "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                        "Office: Excel, Word, Powerpoint"
                )
        ));

        LocalDate[] dates = oTemporaOMores();
        String[] names = getFakeOrganizationName();

        guineaPig.setSection(SectionType.EXPERIENCE, new OrganizationsSection(Arrays.asList(
                new Organization(
                        new OrganizationName(names[0], "http://" + names[0] + getFakeOrganizationDomain()),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        getFakeJobTitle(),
                                        getFakeJobDescription(),
                                        dates[1],
                                        dates[0]
                                )))
                ),
                new Organization(
                        new OrganizationName(names[1], "http://" + names[1] + getFakeOrganizationDomain()),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        getFakeJobTitle(),
                                        getFakeJobDescription(),
                                        dates[3],
                                        dates[2]
                                )))
                )
        )));

        guineaPig.setSection(SectionType.EDUCATION, new OrganizationsSection(Arrays.asList(
                new Organization(
                        new OrganizationName("Школа " + names[2], "http://" + names[2] + getFakeOrganizationDomain()),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Закончила с отличием",
                                        null,
                                        dates[5],
                                        dates[4]
                                )))
                ),
                new Organization(
                        new OrganizationName("Ясли " + names[3], "http://" + names[3] + getFakeOrganizationDomain()),
                        new ArrayList<>(Collections.singletonList(
                                new Position(
                                        "Выгнали за неуспеваемость",
                                        null,
                                        dates[7],
                                        dates[6]
                                )))
                )
        )));

        return guineaPig;
    }

    private static String transliterate(String cyrillic) {
        cyrillic = cyrillic.toLowerCase();
        String[] cyr = {" ", "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};
        String[] lat = {".", "a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "y", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "ts", "ch", "sh", "sch", "", "i", "", "e", "ju", "ja"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cyrillic.length(); i++) {
            char ch = cyrillic.charAt(i);
            int pos = Arrays.asList(cyr).indexOf(String.valueOf(ch));
            if (pos >= 0) {
                builder.append(lat[pos]);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    private static LocalDate[] oTemporaOMores() {
        Random rnd = new Random();
        LocalDate[] times = new LocalDate[9];
        times[0] = LocalDate.now();
        for (int i = 1; i < 8; i += 2) {
            times[i] = times[i - 1].minusYears(1).minusMonths(rnd.nextInt(12));
            times[i + 1] = times[i].minusMonths(rnd.nextInt(12));
        }
        return times;
    }

    private static String[] getFakeOrganizationName() {
        Random rnd = new Random();
        String[] names = new String[4];
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < names.length; j++) {
            sb.delete(0, sb.length());
            int len = rnd.nextInt(8) + 2;
            for (int i = 0; i < len; i++) {
                sb.append((char) (rnd.nextInt(122 - 97) + 97 + 1));
            }
            names[j] = sb.toString();
        }
        return names;
    }

    private static String getFakeOrganizationDomain() {
        Random rnd = new Random();
        String[] domain = new String[]{".de", ".ru", ".ua", ".us", ".com", ".au"};
        return domain[rnd.nextInt(domain.length)];
    }

    private static String getFakeJobTitle() {
        List<String> p1 = new ArrayList<>();
        List<String> p2 = new ArrayList<>();
        List<String> p3 = new ArrayList<>();
        p1.add("старший");
        p1.add("ведущий");
        p1.add("главный");
        p1.add("младший");
        p1.add("никакой");
        p2.add("мойщик");
        p2.add("архитектор");
        p2.add("программист");
        p2.add("специалист");
        p2.add("инженер");
        p3.add("проекта");
        p3.add("ПО");
        p3.add("Java");
        p3.add("баз данных");
        p3.add("моделей");
        return stringConstructor(p1, p2, p3, 1);
    }

    private static String getFakeJobDescription() {
        List<String> p1 = new ArrayList<>();
        List<String> p2 = new ArrayList<>();
        List<String> p3 = new ArrayList<>();
        p1.add("тестирование");
        p1.add("отладка");
        p1.add("внедрение");
        p1.add("реализация");
        p1.add("разработка");
        p1.add("переделка");

        p2.add("информационной");
        p2.add("мобильной");
        p2.add("алгоритмической");
        p2.add("серверной");
        p2.add("дурацкой");
        p2.add("суеверной");

        p3.add("модели");
        p3.add("имплементациии");
        p3.add("статистики");
        p3.add("интеграции");
        p3.add("утилизации");
        p3.add("мультипликации");
        return stringConstructor(p1, p2, p3, 3);
    }

    private static String stringConstructor(List<String> l1, List<String> l2, List<String> l3, int len) {
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        int count = l1.size();
        for (int i = 0; i < len; i++) {
            int pointer1 = rnd.nextInt(count);
            int pointer2 = rnd.nextInt(count);
            int pointer3 = rnd.nextInt(count);
            result.append(l1.get(pointer1)).append(" ");
            result.append(l2.get(pointer2)).append(" ");
            result.append(l3.get(pointer3));
            if (i < len - 1) {
                result.append(", ");
            } else {
                result.append(".");
            }
            l1.remove(pointer1);
            l2.remove(pointer2);
            l3.remove(pointer3);
            count -= 1;
        }
        result.replace(0, 1, result.substring(0, 1).toUpperCase());
        return result.toString();
    }

    private static List<String> getAchievementList() {
        List<String> result = new ArrayList<>();
        String[] s = getFakeJobDescription().split(",");
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim();
            result.add(s[i].toUpperCase().charAt(0) + s[i].substring(1));
        }
        return result;
    }
}
