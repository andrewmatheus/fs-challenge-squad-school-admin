// TODO: 13/02/2024 
//  Crie um enum para representar Status de Matricula e adicione ele como atributo a Aluno 
//  Valores: ATIVO, TRANCADO, FORMADO.
//  Crie um enum para representar o Cargo do Funcionário. 
//  Valores: Iniciante, Experiente, Avançado 
//  Demonstrar o uso de values() e valueOf(). 

package enums;

public enum StatusNivel {
    INICIANTE(1),
    EXPERIENTE(2),
    AVANCADO(3);

    private final int valorNivel;

    StatusNivel(int valorNivel) {
        this.valorNivel = valorNivel;
    }

}