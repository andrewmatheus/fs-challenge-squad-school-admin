import classes.Director;
import classes.Employee;
import classes.Student;
import classes.Teacher;
import data.DirectorsData;
import data.StudentsData;
import data.TeachersData;
import menu.StudentActions;

import java.util.Scanner;

import static utils.Validations.validateEmail;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            int optionSelected;

            System.out.println("**************************************");
            System.out.println("*         UNIVERSIDADE ALT-F4        *");
            System.out.println("**************************************\n");

            do {
                System.out.println("+------------------------------------+");
                System.out.println("+           SEJA BEM VINDO           +");
                System.out.println("+------------------------------------+");
                System.out.println("| Você é aluno(a) ou funcionário(a)? |");
                System.out.println("|                                    |");
                System.out.println("| (1) - Sou Aluno(a)                 |");
                System.out.println("| (2) - Sou Funcionário(a)           |");
                System.out.println("|                                    |");
                System.out.println("+------------------------------------+");
                System.out.println("| (0) - Sair                         |");
                System.out.println("+------------------------------------+");
                System.out.print  ("Selecione uma opção para acesso: "     );

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        menuStudent(scan);
                        break;
                    case 2:
                        menuEmployee(scan);
                        break;
                    case 0:
                        System.out.println("Obrigado volte sempre. Universidade Alt F4, finalizada com sucesso!");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Informe uma opção do menu e tente novamente!");
                }
            } while (optionSelected != 0);

            scan.close();
        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    // <editor-fold desc="Student Access Methods">
    /*
     * student home menu
     * */
    public static void menuStudent(Scanner scan) {
        try {
            int optionSelected;

            do {
                System.out.println("+------------------------------+");
                System.out.println("+       PAINEL DO ALUNO        +");
                System.out.println("+       ---- LOGIN ----        +");
                System.out.println("+------------------------------+");
                System.out.println("|                              |");
                System.out.println("| (1) - Acessar meu painel     |");
                System.out.println("| (2) - Criar novo aluno(a)    |");
                System.out.println("|                              |");
                System.out.println("+------------------------------+");
                System.out.println("| (0) - Sair                   |");
                System.out.println("+------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        loginStudent(scan);
                        break;
                    case 2:
                        addNewStudent(scan, null);
                        break;
                    case 0:
                        System.out.println("Saindo do painel do aluno ...");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);
        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    /*
     * Student login method
     * */
    public static void loginStudent(Scanner scan) {
        try {
            String mail;

            do {
                System.out.println("Digite seu e-mail de acesso: ");
                mail = scan.next().trim().toLowerCase();

                if (!mail.trim().isEmpty()) {
                    if (validateEmail(mail)) {

                        Student student = StudentsData.findStudentByMail(mail);
                        
                        if (student == null) {
                            System.out.println("Aluno(a) não encontrado!");
                            student = addNewStudent(scan, mail);
                        }

                        menuStudentLogged(scan, student);

                        // caso exista turma aberta perguntar se já deseja se vincular a uma turma existente e realizar matricula
                        // Aqui tem q ter a funcionalidade de matricular numa turma (Cartão novo)

                    } else {
                        System.out.println("Você não informou um email válido. Tente novamente!");
                    }
                } else {
                    System.out.println("Você não informou um email válido.");
                }
            } while (!validateEmail(mail));

        } catch (Exception exception) {
            System.out.println("Falha em identificar um aluno ou e-mail informado não é válido!");
        }
    }

    /*
     * Method to generate a menu for the logged in student and their available actions
     * */
    public static void menuStudentLogged(Scanner scan, Student student) {
        StudentActions.menu(scan, student);
    }

    /*
     * Method for adding a new student
     * */
    public static Student addNewStudent(Scanner scan, String mail) {
        System.out.println("+---------------------------------+");
        System.out.println("+         NOVO ALUNO(A)           +");
        System.out.println("+---------------------------------+");
        if (mail == null || mail.isEmpty()) {
            System.out.println("Digite seu e-mail de acesso: ");
            mail = scan.next().trim().toLowerCase();

            if (!validateEmail(mail) && !mail.trim().isEmpty()) {
                do  {
                    System.out.println("E-mail inválido! tente novamente.");
                    System.out.println("Digite seu e-mail de acesso: ");
                    mail = scan.next().toLowerCase();
                } while ((!validateEmail(mail)));
            }
        }

        System.out.println("Digite seu nome: ");
        String nameStudent = scan.next().toLowerCase();
        System.out.println("Digite seu telefone: ");
        System.out.println("Exemplo: 48999999999 ");
        String phoneNumber = scan.next().toLowerCase();

        Student newStudent = new Student(nameStudent, mail, phoneNumber);
        StudentsData.addStudent(newStudent);

        return newStudent;
    }


    // <editor-fold desc="Employee Access Methods">
    /*
     * employee home menu
     * */
    public static void menuEmployee(Scanner scan) {
        try {
            int optionSelected;

            do {
                System.out.println("+---------------------------------+");
                System.out.println("+       PAINEL DO FUNCIONÁRIO     +");
                System.out.println("+         ---- LOGIN ----         +");
                System.out.println("+---------------------------------+");
                System.out.println("|                                 |");
                System.out.println("| (1) - Acessar meu painel        |");
                System.out.println("| (2) - Criar novo funcionário(a) |");
                System.out.println("|                                 |");
                System.out.println("+---------------------------------+");
                System.out.println("| (0) - Sair                      |");
                System.out.println("+---------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        loginEmployee(scan);
                        break;
                    case 2:
                        addNewEmployee(scan, null, null, "");
                        break;
                    case 0:
                        System.out.println("Saindo do painel do funcionário ...");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);
        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    /*
     * Employee login method
     * */
    public static void loginEmployee(Scanner scan) {
        try {
            String name;

            System.out.println("Digite seu nome para acesso: ");
            name = scan.next();

            if (name != null && !name.trim().isEmpty()) {

                Teacher teacher = TeachersData.findTeacherByName(name);

                if (teacher == null) {

                    Director director = DirectorsData.findDirectorByName(name);

                    if (director == null){
                        System.out.println("Seu nome não foi identificado em nossa base de dados! Realize seu cadastro:");

                        addNewEmployee(scan, null, null, name);

                    } else {
                        menuDirectorLogged(scan, director);
                    }

                } else {
                    menuTeacherLogged(scan, teacher);
                }

            } else {
                System.out.println("Você não informou um email válido.");
            }


        } catch (Exception exception) {
            System.out.println("Falha em identificar um aluno ou e-mail informado não é válido!");
        }
    }

    public static void addNewEmployee(Scanner scan, Director director, Teacher teacher, String name) {
        try {
            int optionSelected;

            System.out.println("+---------------------------------+");
            System.out.println("+      NOVO FUNCIONÁRIO(A)        +");
            System.out.println("+---------------------------------+");
            System.out.println("|                                 |");
            System.out.println("| (1) - Novo(a) Professor(a)      |");
            System.out.println("| (2) - Novo(a) Diretor(a)        |");
            System.out.println("|                                 |");
            System.out.println("+---------------------------------+");
            System.out.println("| (0) - Sair                      |");
            System.out.println("+---------------------------------+");

            System.out.print  ("Selecione uma opção: "     );

            optionSelected = scan.nextInt();

            switch (optionSelected) {
                case 1:
                    teacher = addNewTeacher(scan, name);
                    if (teacher != null) {
                        menuTeacherLogged(scan, teacher);
                    }
                    break;
                case 2:
                    director = addNewDirector(scan, name);
                    if (director != null) {
                        menuDirectorLogged(scan, director);
                    }
                    break;
                case 0:
                    System.out.println("Voltando tela de login funcionário!");
                    break;
                default:
                    System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
            }

        } catch (Exception exception) {
            System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
        }
    }

    /*
     * Method to generate a menu for the logged in Teacher and their available actions
     * */
    public static void menuTeacherLogged(Scanner scan, Teacher teacher) {
        try {
            int optionSelected;

            do {

                System.out.println("\nFUNCIONÁRIO: " + teacher.getName() );
                System.out.println("CARGO: PROFESSOR");
                System.out.println("+---------------------------------+");
                System.out.println("|                                 |");
                System.out.println("| (1) - Listar Alunos             |");
                System.out.println("| (2) - Adicionar Aluno na turma  |");
                System.out.println("| (3) - Remover Aluno da turma    |");
                System.out.println("|                                 |");
                System.out.println("+---------------------------------+");
                System.out.println("| (0) - Sair                      |");
                System.out.println("+---------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        System.out.println("Funcionalidade de listar alunos");
                        break;
                    case 2:
                        System.out.println("Funcionalidade de aluno na minha turma");
                        break;
                    case 3:
                        System.out.println("Funcionalidade de remover aluno da turma");
                        break;
                    case 0:
                        System.out.println("Deslogado com sucesso!");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);

        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    /*
     * Method to generate a menu for the logged in Director and their available actions
     * */
    public static void menuDirectorLogged(Scanner scan, Director director) {
        try {
            int optionSelected;

            do {

                System.out.println("\nFUNCIONÁRIO: " + director.getName() );
                System.out.println("CARGO: DIRETOR");
                System.out.println("+---------------------------------+");
                System.out.println("|                                 |");
                System.out.println("| (1) - Promover professor        |");
                System.out.println("| (2) - Adicionar novo professor  |");
                System.out.println("| (3) - Remover professor         |");
                System.out.println("| (4) - Relatório geral           |");
                System.out.println("|                                 |");
                System.out.println("+---------------------------------+");
                System.out.println("| (0) - Sair                      |");
                System.out.println("+---------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        System.out.println("Funcionalidade de listar alunos");
                        break;
                    case 2:
                        System.out.println("Funcionalidade de adicionar novo professor");
                        break;
                    case 3:
                        System.out.println("Funcionalidade de remover professor");
                        break;
                    case 4:
                        System.out.println("Funcionalidade de  listar todos os professores e todos os alunos, juntos dos ids deles");
                        break;
                    case 0:
                        System.out.println("Deslogado com sucesso!");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);

        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    /*
     * Method for adding a new Director
     * */
    public static Director addNewDirector(Scanner scan, String name) {

        try {
            if (name == null || name.isEmpty()) {
                System.out.println("Digite seu nome de acesso: ");
                name = scan.next().toLowerCase();
            }

            System.out.println("Digite seu salário: ");
            double salary = scan.nextDouble();
            System.out.println("Quantos ano(s) de experiência: ");
            int employmentYears = scan.nextInt();

            Director newDirector = new Director(name, salary, employmentYears);
            DirectorsData.addDirector(newDirector);

            return newDirector;
        } catch (Exception exception) {
            System.out.println("Não foi possível adicionar um diretor! tente novamente.");
            return null;
        }
    }

    /*
     * Method for adding a new Teacher
     * */
    public static Teacher addNewTeacher(Scanner scan, String name) {

        try {
            if (name == null || name.isEmpty()) {
                System.out.println("Digite seu nome de acesso: ");
                name = scan.next().toLowerCase();
            }

            System.out.println("Quantos ano(s) você tem: ");
            int age = scan.nextInt();
            System.out.println("Digite seu salário: ");
            double salary = scan.nextDouble();
            System.out.println("Quantos ano(s) de experiência: ");
            int employmentYears = scan.nextInt();

            Teacher newTeacher = new Teacher(name, age, salary, employmentYears);
            TeachersData.addTeacher(newTeacher);

            return newTeacher;
        } catch (Exception exception) {
            System.out.println("Não foi possível adicionar um professor! tente novamente.");
            return null;
        }
    }

    // </editor-fold>
}
