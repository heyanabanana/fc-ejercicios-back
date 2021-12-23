package ejerciciodos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //USUARIOS
        ArrayList<User> users = new ArrayList<User>();
        RegisterService registerService = new RegisterService(users);
        LoginService loginService = new LoginService(users);

        Menu menu = new Menu(registerService, loginService, users);

        menu.menuService();
    }

    public static class Menu {
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_RESET = "\u001B[0m";

        private RegisterService registerService;
        private LoginService loginService;
        private ArrayList<User> users;


        //CONSTRUCTOR MENU
        public Menu(RegisterService registerService, LoginService loginService, ArrayList<User> users) {
            this.users = users;
            this.registerService = registerService;
            this.loginService = loginService;
        }

        //MENU PARA INTERACTUAR POR CONSOLA
        public void menuService() {
            Scanner sc = new Scanner(System.in);
            int option = 0;
            do {
                System.out.println(ANSI_PURPLE + "----" + ANSI_RESET);
                System.out.println(ANSI_PURPLE + "Bienvenido, escoja una opción:" + ANSI_RESET);
                System.out.println(ANSI_PURPLE + "----" + ANSI_RESET);

                System.out.println("1. Registro");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Ver usuarios");
                System.out.println("4. Salir");
                System.out.println(ANSI_PURPLE + "----" + ANSI_RESET);

                System.out.println(ANSI_PURPLE + "Ha escogido la opción:"+ ANSI_RESET);

                //ELEGIR OPCION
                try {
                    option = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_PURPLE + "Elija una opción:"+ ANSI_RESET);
                    menuService();
                }
                switch (option) {
                    case 1:
                        showRegister();
                    case 2:
                        showLogin();
                    case 3:
                        showUsers();
                    case 4: {
                        System.out.println("Finish code");
                        System.exit(0);
                    }
                    default:
                        System.out.println("Por valor, introduzca una opción del 1 al 4");
                }

            } while (true) ;
        }


        public void showRegister() {
                Scanner sc = new Scanner(System.in);
            System.out.println(ANSI_PURPLE + "----" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "REGISTRO DE USUARIO" + ANSI_RESET);

            System.out.println("Email:");
                String email = sc.nextLine();
                
                System.out.println("Contraseña:");
                String password = sc.nextLine();
                
                registerService.isRegister(email, password);
                
                menuService();
        }


        public void showLogin() {

            Scanner sc = new Scanner(System.in);
            System.out.println(ANSI_PURPLE + "----" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "LOGIN DE USUARIO" + ANSI_RESET);

            System.out.println("Email:");
            String email = sc.nextLine();

            System.out.println("Contraseña:");
            String password = sc.nextLine();

            int result = loginService.login(email, password);

            System.out.println(loginService.responseLogin(result));
            menuService();

        }


        // SHOW USERS
        public void showUsers() {
            for (User user : this.users) {
                System.out.println(ANSI_PURPLE + "----" + ANSI_RESET);
                System.out.println(ANSI_PURPLE + "USUARIOS REGISTRADOS" + ANSI_RESET);

                System.out.println(user);
            }
            menuService();
        }



        // GET SET
        public ArrayList<User> getUsers() {
            return users;

        }

        public void setUsers(ArrayList<User> users) {
            this.users = users;
        }

        public RegisterService getRegisterService() {
            return registerService;
        }

        public void setRegisterService(RegisterService registerService) {
            this.registerService = registerService;
        }

        public LoginService getLoginService() {
            return loginService;
        }

        public void setLoginService(LoginService loginService) {
            this.loginService = loginService;
        }
    }



}
