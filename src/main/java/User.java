import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class User {
    private int id = 0;
    private String Name;
    private String lastName;
    transient String password;
    private int scope = 0;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList users = new ArrayList();
    private HashMap<Integer, String> passwords = new HashMap();

    public User(String name, String fullName, String password) {
        Name = name;
        lastName = fullName;
        this.password = password;
    }

    public User(String name, String fullName) {
        Name = name;
        lastName = fullName;
    }

    public User(String name) {
        Name = name;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void welcomeToTheBank() {
        int users_Choose;
        System.out.println("Добро Пожаловать в Deni Bank");
        System.out.println("Что вы хотите сделать?");
        System.out.println("[0]:ВОЙТИ");
        System.out.println("[1]:РЕГИСТРАЦИЯ");
        users_Choose = scanner.nextInt();
//        if (users_Choose == 0) {
//            entryToAcc();
//        } else {
//            addUser();
//        }
    }

    public void addUser() {
        System.out.println("Для регистраций напишите своё имя");
        String name_users = scanner.nextLine();
        System.out.println("Напишите свою Фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = string_scanner();

        this.id++;
        users.add(id);
        users.add(name_users);
        users.add(lastName);
        passwords.put(id, password);
        //entryToAcc();
    }

    public void entryToAcc() {
        boolean isNotSuccessful = false;
        do {
            System.out.println("Введите сюда ваш id: ");
            String users_password = null;
            int users_id = scanner.nextInt();
            scanner.nextLine();
            if (passwords.containsKey(users_id)) {
                System.out.println("Введите Пароль");
                users_password = scanner.nextLine();
                if (passwords.containsValue(users_password)) {
                    System.out.println("Вы успешно вошли");
                    isNotSuccessful = true;
                        operationsUser();
                }
            }else {
                    System.out.println("Такого Пользователя не существует,попробуйте еще");
                }

            }
            while (isNotSuccessful) ;

        }

    private int int_scanner() {
        return scanner.nextInt();
    }

    private String string_scanner() {
        return scanner.nextLine();
    }

    public void operationsUser() {
        System.out.println("Ваш счёт: " + scope);
        int operation_Choose;
        System.out.println("Что вы хотите сделать? ");
        System.out.println("[0]:Пополнить");
        System.out.println("[1]:Перевести");
        operation_Choose = int_scanner();
        if (operation_Choose == 0) {
            System.out.println("Сколько тенге вы хотите пополнить ваш счёт?");
            int scope_users = int_scanner();
            this.scope = scope_users + scope;
        } else if (operation_Choose == 0) {
            System.out.println("Кому вы хотите перевести деньги? ");
            int i = 0;
            for (i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + " " + users.get(i));
            }
            int choose_translate = int_scanner();
            if (choose_translate == i) {
                System.out.println("Сколько вы хотите скинуть деньги?:" + users.get(i));
                int translate_scope = int_scanner();
                if (translate_scope > scope) {
                    System.out.println("У Вас недостачно средств");
                } else {
                    System.out.println("Вы перевели" + translate_scope + "этому" + users.get(i));
                    scope = scope - translate_scope;
                }
            }
        }
    }

}

