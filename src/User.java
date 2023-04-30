import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String phoneNumber;
    private String email;
    private String login;
    private String password;
    private boolean isAdmin;

    public User(String firstName, String lastName, String patronymic, String phoneNumber, String email, String login, String password, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.isAdmin=false;
    }

    public String getFirstName() {
       return firstName;
    }

    public boolean setFirstName(String firstName) {
        if(firstName.matches("^[\\p{IsCyrillic}\\s.-]+$")){
            this.firstName=firstName;
            return true;
        }else {
            System.out.println("Введите корректное имя");
        }
        return false;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        if(lastName.matches("^[\\p{IsCyrillic}\\s.-]+$")){
            this.lastName=lastName;
            return true;
        }else {
            System.out.println("Введите корректную фамилию");
        }
        return false;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public boolean setPatronymic(String patronymic) {
        if(patronymic.matches("^[\\p{IsCyrillic}\\s.-]+$")){
            this.patronymic=patronymic;
            return true;
        }else {
            System.out.println("Введите корректное отчество");
        }
        return false;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        if(phoneNumber.matches("^\\+?[0-9]+$")){
            this.phoneNumber=phoneNumber;
            return true;
        }else {
            System.out.println("Введите корректный номер телефона");
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$")){
            this.email=email;
            return true;
        }else {
            System.out.println("Введите корректную эл. почту");
        }
        return false;
    }

    public String getLogin() {
        return login;
    }

    public boolean setLogin(String login) {
        if(login.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$")){
            this.login=login;
            return true;
        }else {
            System.out.println("Введите корректный логин");
        }
        return false;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")){
            this.password=password;
            return true;
        }else {
            System.out.println("Введите корректный пароль");
        }
        return false;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return login != null ? login.hashCode() : 0;
    }
}
