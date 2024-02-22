package menu;

import classes.Course;
import classes.Director;
import classes.Student;
import classes.Teacher;
import classes.Class;
import data.ClassesData;
import data.CoursesData;
import data.StudentsData;
import data.TeachersData;
import enums.EmployeeLevel;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static data.TeachersData.removeTeacherById;


public class DirectorActions {

    public static void menu(Scanner scan, Director director) {
        try {
            int optionSelected;

            do {

                System.out.println("\nFUNCIONÁRIO: " + director.getName());
                System.out.println("CARGO: DIRETOR");
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("| (1)  - Promover professor           |");
                System.out.println("| (2)  - Adicionar/Remover professor  |");
                System.out.println("| (3)  - Adicionar/Remover aluno      |");
                System.out.println("| (4)  - Criar um Curso               |");
                System.out.println("| (5)  - Criar uma turma              |");
                System.out.println("| (6)  -                              |");
                System.out.println("| (7)  -                              |");
                System.out.println("| (8)  - Relatório geral              |");
                System.out.println("| (10) -                              |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println("| (0) - Sair                          |");
                System.out.println("+-------------------------------------+");
                System.out.print("Selecione uma opção: ");

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        // Promover o cargo de um professor, default BEGINNER.
                        promoteTeacher(scan);
                        break;
                    case 2:
                        // Adicionar ou remover professor
                        addRemoveTeacher(scan);
                        break;
                    case 3:
                        // Adicionar ou remover aluno
                        addRemoveStudent(scan);
                        break;
                    case 4:
                        //Criar um curso
                        createNewCourse(scan);
                        break;
                    case 5:
                        //Criar uma turma
                        createNewClass(scan);
                        break;
                    case 6:
//                        addStudentsToClass(scan); apaguei, não consegui
//                        break;
                    case 7:
                        //Lista alunos de uma turma TODO colocar no relatório
                        break;
                    case 8:
                        // Listar todos os professores e alunos com seus IDs
                        relatorioGeral(scan);
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
     * Método para listar todos os professores e estudantes
     * */
    public static void relatorioGeral(Scanner scan) {
        // Obter listas de professores, alunos e cursos
        List<Teacher> teachers = TeachersData.getTeachersList();
        List<Student> students = StudentsData.getStudentsList();
        //List<Course> courses = CoursesData.getCoursesList();
        List<Class> classes = ClassesData.getClassesList();

        // Exibir todos os professores
        System.out.println("\n------- Professores -------");
        for (Teacher teacher : teachers) {
            System.out.println("ID: " + teachers.indexOf(teacher) + ", " + teacher.toString());
        }

        // Exibir todos os alunos
        System.out.println("\n------- Alunos -------");
        for (Student student : students) {
            System.out.println("ID: " + students.indexOf(student) + ", " + student.toString());
        }

        // Exibir todos os cursos e turmas com seus respectivos professores
        System.out.println("\n------- Turmas e Cursos Asociados -------");
        for (Class class_ : classes) {
            Course course = class_.getCourse();
            String teacherName = course.getTeacher().getName();
            System.out.println("Turma: " + class_.getName() + ", Ano: " + class_.getYear() + ", Curso: " + course.getName() + ", Profesor: " + teacherName);
        }

        // Manter o menu ativo
        System.out.println("\nPressione qualquer tecla para voltar ao menu.");
        scan.nextLine();
        scan.nextLine();
    }



    /*
     * Method to promote a teacher to the next job level
     * */
    public static void promoteTeacher(Scanner scan) {
        try {
            // Lista de professores em ordem alfabética
            List<Teacher> teachers = TeachersData.getTeachersList();
            teachers.sort(Comparator.comparing(Teacher::getName));

            // Exibindo a lista de professores com índices, cargos e experiência
            System.out.println("Lista de Professores:");
            for (int i = 0; i < teachers.size(); i++) {
                Teacher teacher = teachers.get(i);
                System.out.println("Índice " + i + ": " + teacher.getName() + " - Cargo: " + teacher.getJobLevel() + ", Experiência: " + teacher.getEmploymentYears() + " anos");
            }

            // Solicitar ao diretor que escolha o índice do professor a ser promovido
            System.out.print("Digite o índice do professor que deseja promover (0 para sair): ");
            int index = scan.nextInt();

            if (index == 0) {
                System.out.println("Operação cancelada.");
                return;
            }

            if (index > 0 && index <= teachers.size()) {
                Teacher teacher = teachers.get(index - 1); // Ajuste o índice para começar em 1
                EmployeeLevel currentLevel = teacher.getJobLevel();
                EmployeeLevel nextLevel = getNextJobLevel(currentLevel);

                if (nextLevel != null) {
                    teacher.promotion();
                    teacher.setJobLevel(nextLevel);
                    System.out.println("Professor " + teacher.getName() + " promovido para " + nextLevel);
                } else {
                    System.out.println("O professor " + teacher.getName() + " já atingiu o cargo mais alto.");
                }
            } else {
                System.out.println("Índice inválido. Por favor, selecione um índice válido.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao promover o professor: " + e.getMessage());
        }
    }

    /*
     * Método para obter o próximo nível de cargo do funcionário
     * */
    public static EmployeeLevel getNextJobLevel(EmployeeLevel currentJobLevel) {
        return switch (currentJobLevel) {
            case BEGINNER -> EmployeeLevel.EXPERIENCED;
            case EXPERIENCED -> EmployeeLevel.ADVANCED;
            case ADVANCED -> null; // O professor "x" já atingiu o cargo mais alto.
        };
    }

    public static void addNewTeacher(Scanner scan) {
        try {
            System.out.println("*** Cadastro do novo professor ***\n");
            System.out.print("Digite o nome: ");
            String name = scan.next();

            System.out.print("Digite a idade: ");
            int age = scan.nextInt();
            System.out.print("Digite o salário: ");
            double salary = scan.nextDouble();
            System.out.print("Digite os anos de experiência: ");
            int employmentYears = scan.nextInt();

            Teacher newTeacher = new Teacher(name, age, salary, employmentYears);
            TeachersData.addTeacher(newTeacher);
            System.out.println("\nNovo professor adicionado com sucesso!");
        } catch (Exception exception) {
            System.out.println("\nNão foi possível adicionar um professor! Tente novamente.");
        }
    }

    /*
     * Method to remove a teacher.
     * */
    public static void removeTeacher(Scanner scan) {
        try {
            // Lista de professores em ordem alfabética
            List<Teacher> teachers = TeachersData.getTeachersList();
            teachers.sort(Comparator.comparing(Teacher::getName));

            // Exibindo a lista de professores com índices
            System.out.println("Lista de Professores:");
            for (int i = 0; i < teachers.size(); i++) {
                Teacher teacher = teachers.get(i);
                System.out.println("Índice " + i + ": " + teacher.getName() + " - Cargo: " + teacher.getJobLevel() + ", Experiência: " + teacher.getEmploymentYears() + " anos");
            }

            // Solicitar ao diretor que escolha o índice do professor a ser removido
            System.out.print("Digite o índice do professor que deseja remover: ");
            int index = scan.nextInt();

            // Remover o professor utilizando o método da classe TeachersData
            removeTeacherById(index);
        } catch (Exception e) {
            System.out.println("Erro ao remover o professor: " + e.getMessage());
        }
    }

    public static void addRemoveTeacher(Scanner scanner) {
        try {
            System.out.println("*** Adicionar ou remover professor ***\n");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar novo professor");
            System.out.println("2. Remover professor existente");
            System.out.print("Opção: ");
            int option = scanner.nextInt();

            if (option == 1) {
                addNewTeacher(scanner);
            } else if (option == 2) {
                removeTeacher(scanner);
            } else {
                System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar a ação. Tente novamente.");
        }
    }
    /*
     * Method to create a new Course. A registered Teacher is linked to the new Course
     * */
    public static void createNewCourse(Scanner scan) {
        try {
            List<Teacher> teachers = TeachersData.getTeachersList();

            if (teachers.isEmpty()) {
                System.out.println("Nenhum professor cadastrado.");
                System.out.println("Por favor, adicione um novo professor antes de criar um curso.");
                System.out.print("Deseja adicionar um novo professor? (S/N)");
                String option = scan.next();
                if (option.equalsIgnoreCase("S")) {
                    addNewTeacher(scan);
                    // Recarregar a lista de professores
                    teachers = TeachersData.getTeachersList();
                } else {
                    System.out.println("Operação cancelada.");
                    return;
                }
            }

            System.out.print("Digite o nome do novo curso: ");
            String courseName = scan.next();

            System.out.println("Lista de Professores Disponíveis:");
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println((i + 1) + ". " + teachers.get(i).getName());
            }

            System.out.print("Selecione o número do professor para este curso: ");
            int selectedTeacherIndex = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha pendente

            if (selectedTeacherIndex >= 1 && selectedTeacherIndex <= teachers.size()) {
                Teacher selectedTeacher = teachers.get(selectedTeacherIndex - 1);

                Course newCourse = new Course(courseName, selectedTeacher);
                CoursesData.addCourse(newCourse);

                System.out.println("Novo curso '" + newCourse.getName() + "' associado ao professor '" + selectedTeacher.getName() + "' criado com sucesso!");
            } else {
                System.out.println("Índice de professor selecionado inválido. O curso não foi criado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao criar o curso: " + e.getMessage());
        }
    }

    public static void addNewStudent(Scanner scan) {
        try {
            System.out.println("*** Cadastro do novo aluno ***\n");
            System.out.print("Digite o nome: ");
            String name = scan.next();

            System.out.print("Digite o e-mail: ");
            String email = scan.next();

            System.out.print("Digite o número de telefone: ");
            String phoneNumber = scan.next();

            Student newStudent = new Student(name, email, phoneNumber);
            StudentsData.addStudent(newStudent);
            System.out.println("\nNovo aluno adicionado com sucesso!");
        } catch (Exception exception) {
            System.out.println("\nNão foi possível adicionar um aluno! Tente novamente.");
        }
    }

    public static void removeStudent(Scanner scanner) {
        try {
            System.out.println("*** Remoção de aluno ***\n");

            // Listar todos os estudantes antes de remover
            List<Student> students = StudentsData.getStudentsList();
            System.out.println("Lista de estudantes:");
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                System.out.println("ID: " + i + ", Nome: " + student.getName());
            }

            System.out.print("Digite o ID do aluno a ser removido (0 para cancelar): ");
            int studentId = scanner.nextInt();

            if (studentId == 0) {
                return; // Cancelar a operação se o usuário digitar 0
            }

            Student studentToRemove = StudentsData.findStudentById(studentId);
            if (studentToRemove != null) {
                StudentsData.removeStudent(studentId);
                System.out.println("\nAluno removido com sucesso!");
            } else {
                System.out.println("\nAluno não encontrado. Verifique o ID e tente novamente.");
            }
        } catch (Exception exception) {
            System.out.println("\nNão foi possível remover o aluno! Tente novamente.");
        }
    }


    public static void addRemoveStudent(Scanner scan) {
        try {
            System.out.println("*** Adicionar ou remover aluno ***\n");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar novo aluno");
            System.out.println("2. Remover aluno existente");
            System.out.print("Opção: ");
            int option = scan.nextInt();

            if (option == 1) {
                addNewStudent(scan);
            } else if (option == 2) {
                removeStudent(scan);
            } else {
                System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar a ação. Tente novamente.");
        }
    }

    public static void createNewClass(Scanner scan) {
        try {
            // Obter a lista de turmas cadastradas
            List<Class> existingClasses = ClassesData.getClassesList();

            // Se houver turmas cadastradas, imprimir a lista
            if (!existingClasses.isEmpty()) {
                System.out.println("\n------- Turmas Cadastradas -------");
                for (Class existingClass : existingClasses) {
                    Course course = existingClass.getCourse();
                    String teacherName = course.getTeacher().getName();
                    System.out.println("Turma: " + existingClass.getName() + ", Ano: " + existingClass.getYear() + ", Curso: " + course.getName() + ", Professor: " + teacherName);
                }
                System.out.println();
            }

            System.out.print("Digite o nome da nova turma: ");
            String className = scan.next();
            scan.nextLine(); // Consumir a nova linha pendente

            System.out.print("Digite o ano da turma: ");
            int year = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha pendente

            // Obter a lista de cursos disponíveis
            List<Course> courses = CoursesData.getCoursesList();

            if (courses.isEmpty()) {
                // Se não houver cursos cadastrados, pedir para criar um novo curso
                System.out.print("\nNão há cursos cadastrados. Por favor, crie um novo curso.\n");
                createNewCourse(scan);
                // Depois de criar um novo curso, recarregar a lista de cursos
                courses = CoursesData.getCoursesList();
            }

            if (!courses.isEmpty()) {
                // Se houver cursos cadastrados, mostrar a lista e permitir a seleção
                System.out.println("\n*** Lista de Cursos Disponíveis ***");
                for (int i = 0; i < courses.size(); i++) {
                    System.out.println((i + 1) + ". " + courses.get(i).getName());
                }
                System.out.println("0. Criar um novo curso");

                System.out.print("Selecione o número do curso para esta turma (ou 0 para criar um novo): ");
                int selectedCourseIndex = scan.nextInt();
                scan.nextLine(); // Consumir a nova linha pendente

                if (selectedCourseIndex == 0) {
                    // Criar um novo curso
                    createNewCourse(scan);
                    // Após criar um novo curso, recarregar a lista de cursos
                } else if (selectedCourseIndex >= 1 && selectedCourseIndex <= courses.size()) {
                    Course selectedCourse = courses.get(selectedCourseIndex - 1);

                    // Criar a nova turma associada ao curso selecionado
                    Class newClass = new Class(className, year, selectedCourse);
                    ClassesData.addClass(newClass);

                    System.out.println("\nNova turma -" + className + "- associada ao curso -" + selectedCourse.getName() + "- criada com sucesso!");
                } else {
                    System.out.println("\nOpção inválida. A turma não foi criada.");
                }
            }
        } catch (Exception e) {
            System.out.println("\nErro ao criar a turma: " + e.getMessage());
        }
    }

}
