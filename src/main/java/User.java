import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class User {
    private int id = 0;
    private String Name;
    private String lastName;
    transient String password;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList users = new ArrayList();
    private HashMap<Integer,String> passwords = new HashMap();

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
        if (users_Choose == 0){

        }else {
            addUser(users);
        }
    }

    public void addUser(ArrayList base) {
        System.out.println("Добро пожаловать в наш Банк, для регистраций напишите своё имя");
        this.Name = scanner.nextLine();
        System.out.println("Напишите свою Фамилию");
        lastName = scanner.nextLine();
        System.out.println("Введите пароль");
        password = scanner.nextLine();
        this.id++;
        base.add(id,Name);
        base.add(lastName);
        passwords.put(id,password);
    }
    public void entryToAcc(){
        boolean isNotSuccsesful = false;
        while (!isNotSuccsesful) {
            System.out.println("Введите сюда ваш id: ");
            int users_id = int_scanner();
            String users_password;
                if (passwords.containsKey(users_id)) {
                    System.out.println("Введите Пароль");
                    users_password = string_scanner();
                    if (passwords.containsValue(users_password)){
                        System.out.println("Вы успешно вошли");
                        isNotSuccsesful = true;
                    }
                } else {
                    System.out.println("Такого Пользователя не существует,попробуйте еще");
                }
        }
    }
    private int int_scanner(){
        return scanner.nextInt();
    }

    private String string_scanner(){
        return scanner.nextLine();
    }

}

