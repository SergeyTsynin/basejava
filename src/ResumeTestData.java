import model.Resume;

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

        System.out.println(kislin);
        System.out.println(kislin.getAll());

    }
}
