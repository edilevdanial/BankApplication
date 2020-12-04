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
        if (users_Choose == 0) {
            entryToAcc();
        } else {
            addUser();
        }
    }

    public void addUser() {
        System.out.println("Для регистраций напишите своё имя");
        String name_users = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Напишите свою Фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = string_scanner();

        this.id++;
        users.add(id);
        users.add(name_users);
        users.add(lastName);
        passwords.put(id, password);
        users.add(200);
        entryToAcc();
    }

    public void entryToAcc() {
        boolean isNotSuccessful = false;
        int checkisPass = 0;
        do {
            System.out.println("Введите сюда ваш id: ");
            String users_password;
            int users_id = scanner.nextInt();
            scanner.nextLine();
            if (passwords.containsKey(users_id)) {
                System.out.println("Введите Пароль");
                users_password = scanner.nextLine();
                if (passwords.containsValue(users_password)) {
                    System.out.println("Вы успешно вошли в аккаунт");
                    isNotSuccessful = true;
                }else {
                    System.out.println("Неверный Пароль попробуйте еще");
                        users_password = scanner.nextLine();
                        checkisPass++;
                    if (passwords.containsValue(users_password)) {
                        System.out.println("Вы успешно вошли в аккаунт");
                        isNotSuccessful = true;
                    }
                }
            } else {
                System.out.println("Такого Пользователя не существует,попробуйте еще");
                checkisPass++;
            }
        }
        while (!isNotSuccessful&&checkisPass<5);
        if(checkisPass>5){
            System.out.println("Превышен лимит попробуйте позже");
        }
        if (isNotSuccessful){
            operationsUser();
        }
    }

    private int int_scanner() {
        return scanner.nextInt();
    }

    private String string_scanner() {
        return scanner.nextLine();
    }

    public void operationsUser() {
        users.add("Danial");
        users.add("edilev");
        boolean isCheck = false;
        while (!isCheck) {
            System.out.println("Ваш счёт: " + scope);
            int operation_Choose;
            System.out.println("Что вы хотите сделать? ");
            System.out.println("[0]:Пополнить");
            System.out.println("[1]:Перевести");
            System.out.println("[2]:Выйти");
            operation_Choose = scanner.nextInt();
            if (operation_Choose == 0) {
                System.out.println("Сколько тенге вы хотите пополнить ваш счёт?");
                int scope_users = scanner.nextInt();
                this.scope = scope_users + scope;
            } else if (operation_Choose ==1){
                System.out.println("Кому вы хотите перевести деньги? ");
                int getI = 0;
                for (int i = 0; i < users.size(); i++) {
                    System.out.println((i + 1) + " " + users.get(i));
                    getI = i;
                }
                int choose_translate = scanner.nextInt();
                //TODO тут нужно будет изменить условие или вообще убрать чтоб ошибок не было код не рабочий
                if (choose_translate == users.indexOf(getI)) {
                    System.out.println("Сколько вы хотите скинуть деньги?:" + users.get(getI));
                    int translate_scope = int_scanner();
                    if (translate_scope > scope) {
                        System.out.println("У Вас недостачно средств");
                    } else {
                        System.out.println("Вы перевели" + translate_scope + "этому" + users.get(getI));
                        scope = scope - translate_scope;
                    }
                }
            }else {
                isCheck=true;
            }
        }
    }

}

