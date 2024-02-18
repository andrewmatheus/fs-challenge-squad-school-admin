import classes.Employee;
import classes.Student;

import java.util.Scanner;

import static utils.Validations.validateEmail;

public class Main2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            int optionSelected;

            System.out.println("*******************************");
            System.out.println("*     UNIVERSIDADE ALT-F4     *");
            System.out.println("*******************************\n");

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
                         addNewStudent(scan);
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
    // pendente ações após informar email para criar ou buscar o usuario;
    public static void loginStudent(Scanner scan) {
        try {
            String mail;
            String StudentExample = "Miguel";
            do {
                System.out.println("Digite seu e-mail de acesso: ");
                mail = scan.next();

                if (mail != null && !mail.trim().isEmpty()) {
                    if (validateEmail(mail)) {
                        System.out.println("prossegui no sistema");
                        // Preciso da lista de students e caso não existe preciso do adicionar studant;

                        // tendo o aluno aqui abaixo vou colocar o menu do aluno onde ele poderar executar as ações do aluno;

                        // caso exista turma aberta perguntar se já deseja se vincular a uma turma existente e realizar matricula

                    } else {
                        System.out.println("Você não informou um email válido. Tente novamente!");
                    }
                } else {
                    System.out.println("Você não informou um email válido.");
                }
            } while (!validateEmail(mail));

            // possuindo o estudante levar para o menu de ações do aluno
            if (StudentExample != null && !StudentExample.trim().isEmpty()) {
                Student student = new Student("John Due", mail, "4899998888");
                menuStudentLogged(scan, student);
            }
        } catch (Exception exception) {
            System.out.println("Falha em identificar um aluno ou e-mail informado não é válido!");
        }
    }

    /*
     * Method to generate a menu for the logged in student and their available actions
     * */
    // pendencia: aqui vai mudar de String para student quando possuir estudante real
    public static void menuStudentLogged(Scanner scan, Student student) {
        try {
            int optionSelected;

            do {

                System.out.println("\n ALUNO: " + student.getName() );
                System.out.println("+--------------------------------+");
                System.out.println("|                                |");
                System.out.println("| (1) - Meu(s) Cursos            |");
                System.out.println("| (2) - Matricular em novo Curso |");
                System.out.println("| (3) - Abandonar curso          |");
                System.out.println("| (4) - Trancar Matrícula        |");
                System.out.println("| (5) - Ativar Matrícula         |");
                System.out.println("|                                |");
                System.out.println("+--------------------------------+");
                System.out.println("| (0) - Sair                     |");
                System.out.println("+--------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        System.out.println("Funcionalidade de listar curso");
                        break;
                    case 2:
                        System.out.println("Funcionalidade de matricular curso (adicionar curso)");
                        break;
                    case 3:
                        System.out.println("Funcionalidade de abandonar curso (remover curso)");
                        break;
                    case 4:
                        System.out.println("Funcionalidade de Trancar matrícula (proprio aluno)");
                        break;
                    case 5:
                        System.out.println("Funcionalidade de Ativar matrícula (proprio aluno)");
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
    * Method for adding a new student
    * */
    public static void addNewStudent(Scanner scan) {
        // utilizar o metodo adicionar novo aluno de studentsData ainda a ser criado
        System.out.println("adicionado novo aluno");
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
                        addNewEmployee(scan);
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
            String mail;

            do {
                System.out.println("Digite seu e-mail de acesso: ");
                mail = scan.next();

                if (mail != null && !mail.trim().isEmpty()) {
                    if (validateEmail(mail)) {

                        // conversar com o grupo como funciona o lance diretor
                        // Preciso da lista de professores e diretores e caso não existe preciso do adicionar um de acordo com opção selecionada;

                        // tendo o funcionário aqui abaixo vou colocar o menu do funcionario onde ele poderar executar as ações do professor ou diretor dependendo da posicao dele;

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
    // pendencia: aqui vai mudar de String para student quando possuir estudante real
    public static void menuEmployeeLogged(Scanner scan, Employee employee) {
        try {
            int optionSelected;
//            Employee employee = new Employee("Joe", 5000, 30);
            do {

                System.out.println("\n FUNCIONÁRIO: " + employee.getName() );
                System.out.println("\n CARGO: " + employee.getJobLevel() );
                System.out.println("+--------------------------------+");
                System.out.println("|                                |");
                System.out.println("|                                |");
                System.out.println("+--------------------------------+");
                System.out.println("| (0) - Sair                     |");
                System.out.println("+--------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = scan.nextInt();

                switch (optionSelected) {
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
     * Method for adding a new Employee
     * */
    public static void addNewEmployee(Scanner scan) {
        // utilizar o metodo adicionar novo funcionario
        System.out.println("adicionado novo funcionario");
    }

    // </editor-fold>

}
