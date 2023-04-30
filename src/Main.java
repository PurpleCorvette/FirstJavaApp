import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        User admin = new User("Попов", "Фёдор", "Васильевич", "+79991234567", "example@mail.ru", "admin", "password", false);
        admin.setAdmin(true);
        users.add(admin);

        while (true) {
            System.out.println("1 - Авторизация");
            System.out.println("2 - Регистрация");
            System.out.println("0 - Выход");

            String choice = in.nextLine();
            in.nextLine();

            switch (choice) {
                case "1":
                    authorize();
                    break;
                case "2":
                    registration();
                    break;
                case "0":
                    System.out.println("Вы вышли из программы");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Введите корретный номер операции");
                    break;
            }
        }
    }

    public static void authorize() {
        System.out.println("Введите логин");
        String login = in.nextLine();
        System.out.println("Введите пароль");
        String password = in.nextLine();

        User user = findUserByLogin(login);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Вы успешно авторизовались");

            if (user.isAdmin()) {
                adminMenu(user);
            } else {
                userMenu(user);
            }
        } else {
            System.out.println("Логин или пароль не существуют");
        }
    }

    private static void registration() {
        System.out.println("Введите фамилию");
        String firstName = in.nextLine();
        System.out.println("Введите имя");
        String lastName = in.nextLine();
        System.out.println("Введите отчество");
        String patronymic = in.nextLine();
        System.out.println("Введите номер телефона");
        String phoneNumber = in.nextLine();
        System.out.println("Введите почту");
        String email = in.nextLine();
        System.out.println("Введите логин");
        String login = in.nextLine();
        System.out.println("Введите пароль");
        String password = in.nextLine();

        if (findUserByLogin(login) == null) {
            User user = new User(firstName, firstName, patronymic, phoneNumber, email, login, password, false);
            users.add(user);
            System.out.println("Вы успешно зарегистрировались");
        } else {
            System.out.println("Такой пользователь уже существует");
        }
    }

    public static void adminMenu(User user) {
        while (true) {
            System.out.println("1 - Добавить товар");
            System.out.println("2 - Удалить товар");
            System.out.println("3 - Просмотр информации о пользователях");
            System.out.println("4 - Сменить роль пользователю");
            System.out.println("0 - Выход");

            String choice = in.nextLine();
            in.nextLine();

            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    removeProduct();
                    break;
                case "3":
                    viewUsers();
                    break;
                case "4":
                    changeRole();
                    break;
                case "0":
                    System.out.println("Вы вышли из программы");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Выберете корректное дейсвтие");
                    break;
            }
        }
    }

    public static void userMenu(User user) {
        while (true) {
            System.out.println("1 - Просмотр товаров");
            System.out.println("0 - Выход");

            String choice = in.nextLine();
            in.nextLine();

            switch (choice) {
                case "1":
                    viewProducts();
                    break;
                case "0":
                    System.out.println("Вы вышли из программы");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Выберете корректное дейсвтие");
                    break;
            }
        }
    }

    private static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("Нет товаров");
        } else {
            System.out.println("Доступные товары:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice() + "руб. ");
            }
        }
    }

    private static void addProduct() {
        System.out.println("Введите наименование");
        String name = in.nextLine();
        System.out.println("Введите цену");
        double price = in.nextDouble();
        in.nextLine();

        Product product = new Product(name, price);
        products.add(product);
        System.out.println("Продукт добавлен");
    }

    private static void removeProduct() {
        if (products.isEmpty()) {
            System.out.println("Товары отсутствют");
            return;
        }
        System.out.println("Введите номер товара для удаления");
        int index = in.nextInt() - 1;
        in.nextLine();

        if (index >= 0 && index < products.size()) {
            products.remove(index);
            System.out.println("Товар удален");
        } else {
            System.out.println("Неверный номер товара");
        }
    }

    private static void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("Нет зарегистрированных пользователей");
        } else {
            System.out.println("Зарегистрированные пользователи:");
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                System.out.println((i + 1) + ". " + user.getLastName() + " " + user.getFirstName() + " " + " (" + (user.isAdmin() ? "администратор" : "посетитель") + ")");
            }
        }
    }

    private static void changeRole() {
        System.out.println("Введите номер пользователя для смены роли");
        int index = in.nextInt() - 1;
        in.nextLine();

        if (index >= 0 && index < users.size()) {
            User user = users.get(index);
            user.setAdmin(!user.isAdmin());
            System.out.println("Роль пользователя успешно изменена");
        } else {
            System.out.println("Неверный номер пользователя");
        }
    }

    public static User findUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
