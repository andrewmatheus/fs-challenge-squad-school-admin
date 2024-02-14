// TODO: 13/02/2024
//  Crie um enum para representar Status de Matricula e adicione ele como atributo a Aluno
//  Valores: ATIVO, TRANCADO, FORMADO.
//  Crie um enum para representar o Cargo do Funcionário.
//  Valores: Iniciante, Experiente, Avançado
//  Demonstrar o uso de values() e valueOf().

package enums;

public enum StatusMatricula {
    ATIVO(1),
    TRANCADO(2),
    FORMADO(3);

    private final int valorMatricula;

    StatusMatricula(int valorMatricula) {
        this.valorMatricula = valorMatricula;
    }
}
