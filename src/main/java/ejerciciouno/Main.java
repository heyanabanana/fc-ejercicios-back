package ejerciciouno;


import ejerciciouno.validation.Validate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
            ArrayList<String[]> users = new ArrayList<>();
            ArrayList<String[]> usersIncorrect = new ArrayList<>();
            ArrayList<Integer> linesIncorrect = new ArrayList<>();
            String route = "src/main/java/ejerciciouno/fichero.csv";
            System.out.println(ANSI_YELLOW + "---- Fichero ----" + ANSI_RESET);
            System.out.println(route);

            System.out.println(ANSI_YELLOW + "---- Errores del fichero ----" + ANSI_RESET);
            uploadArchive(route, users, usersIncorrect, linesIncorrect);
            System.out.println(ANSI_RED + "Usuarios incorrectos en el archivo: " + ANSI_RESET + usersIncorrect.size());
            System.out.println(ANSI_RED + "Las lineas " + linesIncorrect + " en el archivo no validas");

            System.out.println(ANSI_YELLOW + "----" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Lineas validas: " + ANSI_RESET + users.size());
            printArray(users);
            System.out.println(ANSI_RED + "Lineas no validas: " + ANSI_RESET + usersIncorrect.size());
            printArray(usersIncorrect);


        }

        /**
         *  Leer el arhivo csv y guardarlo en un arrayList cada linea
         *  Separar en un array de String usando como separador la  ","
         *  Comprobar si hay users repetidos
         *  Comprobar si cada campo es valido
         *  Comprobar si no falta ningun campo
         */
        public static void uploadArchive(String route, ArrayList<String[]> users, ArrayList<String[]> usersIncorrect, ArrayList<Integer> linesIncorrect) {
            int lineNumber = 0;
            String[] user;
            try {
                FileReader fr = new FileReader(route);
                BufferedReader br = new BufferedReader(fr);
                String line;

                while ((line = br.readLine()) != null) {
                    lineNumber++;
                    user = line.split(",");
                    for (int i = 0; i < user.length; i++) user[i] = user[i].trim();
                    if (!Validate.verifyDuplicateEmail(users, user)) {
                        usersIncorrect.add(user);
                        linesIncorrect.add(lineNumber);
                        System.err.println("El usuario de la linea " + lineNumber + " con email " + user[0] + " ya existe en el archivo.");
                    } else if (!Validate.verifyThreeParameters(user, 3)) {
                        System.err.println("El usuario de la linea " + lineNumber + " del archivo, no es correcto, tiene menos de 3 campos.");
                        usersIncorrect.add(user);
                        linesIncorrect.add(lineNumber);

                    } else if (!Validate.verifyEmail(user[0])) {
                        System.err.println("El usuario de la linea " + lineNumber + " del archivo, no es correcto, el correo no es valido.");
                        usersIncorrect.add(user);
                        linesIncorrect.add(lineNumber);
                    } else if (!Validate.verifyFullname(user[1])) {
                        System.err.println("El usuario de la linea " + lineNumber + " del archivo, no es correcto, el nombre no es valido.");
                        usersIncorrect.add(user);
                        linesIncorrect.add(lineNumber);
                    } else if (!Validate.verifyUsername(user[2])) {
                        System.err.println("El usuario de la linea " + lineNumber + " del archivo, no es correcto, el usuario no es valido.");
                        usersIncorrect.add(user);
                        linesIncorrect.add(lineNumber);
                    } else {
                        users.add(user);
                    }
                }
                br.close();
            } catch (Exception e) {
                System.out.println("Error al leer el archivo");
            }

        }

        public static void printArray(ArrayList<String[]> users) {
            for (String[] user : users) {
                System.out.println(Arrays.toString(user));
            }
            System.out.println(ANSI_YELLOW + "---" + ANSI_RESET);
        }

    }