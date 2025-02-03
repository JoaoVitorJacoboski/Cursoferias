/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package unipar.br.tarefaferias;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author jjoao
 */
public class Aplicacao {

    static ArrayList<String> nomes = new ArrayList<>();
    static double[] vendas = new double[12];
    static int[] numeros = new int[50];
    static int contadorNumeros = 0;

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:\n"
                    + "1 - Gerenciar Nomes\n"
                    + "2 - Controle de Vendas e Comissões\n"
                    + "3 - Manipular Vetor\n"
                    + "0 - Sair"));

            switch (opcao) {
                case 1:
                    gerenciarNomes();
                    break;
                case 2:
                    controleVendas();
                    break;
                case 3:
                    manipularVetor();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void gerenciarNomes() {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Gerenciamento de Nomes:\n"
                    + "1 - Inserir nome\n"
                    + "2 - Remover nome\n"
                    + "3 - Exibir todos os nomes\n"
                    + "0 - Voltar"));

            switch (opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite um nome:");
                    nomes.add(nome);
                    break;
                case 2:
                    int pos = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição do nome a remover:"));
                    if (pos >= 0 && pos < nomes.size()) {
                        nomes.remove(pos);
                    } else {
                        JOptionPane.showMessageDialog(null, "Posição inválida.");
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Nomes: " + nomes);
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void controleVendas() {
        double totalComissao = 0;
        for (int i = 0; i < 12; i++) {
            vendas[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o total de vendas do mês " + (i + 1) + ":"));
            double comissao = calcularComissao(vendas[i]);
            totalComissao += comissao;
            JOptionPane.showMessageDialog(null, "Mês " + (i + 1) + ":\nVendas: R$" + vendas[i] + "\nComissão: R$" + comissao);
        }
        JOptionPane.showMessageDialog(null, "Total de comissão anual: R$" + totalComissao);
    }

    public static double calcularComissao(double valor) {
        if (valor <= 500) return valor * 0.005;
        else if (valor <= 800) return valor * 0.008;
        else if (valor <= 1000) return valor * 0.01;
        else if (valor <= 3000) return valor * 0.015;
        else return valor * 0.02;
    }

    public static void manipularVetor() {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Manipulação de Vetor:\n"
                    + "1 - Inserir valor\n"
                    + "2 - Pesquisar valor\n"
                    + "3 - Mostrar todos os valores\n"
                    + "4 - Mostrar menor e maior valor\n"
                    + "5 - Mostrar primeiro e último valor\n"
                    + "6 - Mostrar valores pares\n"
                    + "7 - Mostrar valores ímpares\n"
                    + "8 - Mostrar soma dos valores\n"
                    + "0 - Voltar"));
            
            switch (opcao) {
                case 1:
                    if (contadorNumeros < 50) {
                        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:"));
                        boolean existe = false;
                        for (int i = 0; i < contadorNumeros; i++) {
                            if (numeros[i] == num) {
                                existe = true;
                                break;
                            }
                        }
                        if (!existe) {
                            numeros[contadorNumeros++] = num;
                        } else {
                            JOptionPane.showMessageDialog(null, "Número já existe no vetor.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Vetor cheio.");
                    }
                    break;
                case 2:
                    int buscar = Integer.parseInt(JOptionPane.showInputDialog("Digite um número para buscar:"));
                    boolean encontrado = false;
                    for (int i = 0; i < contadorNumeros; i++) {
                        if (numeros[i] == buscar) {
                            JOptionPane.showMessageDialog(null, "Número encontrado na posição " + i);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) JOptionPane.showMessageDialog(null, "Número não encontrado.");
                    break;
                case 3:
                    StringBuilder sb = new StringBuilder("Valores: ");
                    for (int i = 0; i < contadorNumeros; i++) {
                        sb.append(numeros[i]).append(" ");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;
                case 4:
                    int menor = Integer.MAX_VALUE, maior = Integer.MIN_VALUE;
                    for (int i = 0; i < contadorNumeros; i++) {
                        if (numeros[i] < menor) menor = numeros[i];
                        if (numeros[i] > maior) maior = numeros[i];
                    }
                    JOptionPane.showMessageDialog(null, "Menor: " + menor + " Maior: " + maior);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Primeiro: " + numeros[0] + " Último: " + numeros[contadorNumeros - 1]);
                    break;
                case 6:
                    StringBuilder pares = new StringBuilder("Pares: ");
                    for (int i = 0; i < contadorNumeros; i++) {
                        if (numeros[i] % 2 == 0) pares.append(numeros[i]).append(" ");
                    }
                    JOptionPane.showMessageDialog(null, pares.toString());
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (opcao != 0);
    }
}
