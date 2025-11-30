import java.util.ArrayList;
import java.util.Scanner;

abstract class Contato {
    // Atriburos
    protected String nome;
    protected String apelido;
    protected String email;
    protected String aniversario;

    // Construtor
    public Contato(String nome, String apelido, String email, String aniversario){
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.aniversario = aniversario;
    }

    // Getters e Setters
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getApelido() {return apelido;}
    public void setApelido(String apelido) {this.apelido = apelido;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getAniversario() {return aniversario;}
    public void setAniversario(String aniversario) {this.aniversario = aniversario;}

    // Metodos
    public String imprimirBasico(){
        return "Nome: " + nome + "\n" +
                "Apelido: " + apelido + "\n" +
                "Email: " + email + "\n" +
                "Aniversário: " + aniversario + "\n";
    }

    abstract public String imprimirContato();
}

class Amigo extends Contato{
    // Atributos
    protected int grau;

    // Construtor
    public Amigo(String nome, String apelido, String email, String aniversario, int grau){
        super(nome, apelido, email, aniversario);
        this.grau = grau;
    }

    // Metodos
    @Override
    public String imprimirContato() {
        switch (grau){
            case 1:
                return imprimirBasico() + "Grau: Melhor Amigo";
            case 2:
                return imprimirBasico() + "Grau: Amigo";
            case 3:
                return imprimirBasico() + "Grau: Conhecido";
        }
        return "";
    }
}

class Familia extends Contato{
    // Atributos
    protected String parentesco;

    // Construtor
    public Familia(String nome, String apelido, String email, String aniversario, String parentesco){
        super(nome, apelido, email, aniversario);
        this.parentesco = parentesco;
    }

    // Metodos
    @Override
    public String imprimirContato() {
        return imprimirBasico() + "Parentesco: " + parentesco;
    }
}

class ColegasDeTrabalho extends Contato{
    // Atributos
    protected String tipo;

    // Construtor
    public ColegasDeTrabalho(String nome, String apelido, String email, String aniversario, String tipo){
        super(nome, apelido, email, aniversario);
        this.tipo = tipo;
    }

    // Metodos
    @Override
    public String imprimirContato() {
        return imprimirBasico() + "Relacionamento de trabalho: " + tipo;
    }
}

public class UsoContatos {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int menu;
        ArrayList<Contato> contatos = new ArrayList<>();

        while (true){
            menu = entrada.nextInt();

            switch (menu){
                case 1:
                    int tipoContato = entrada.nextInt();
                    if (tipoContato == 1){
                        Amigo amigo = new Amigo(entrada.next(), entrada.next(), entrada.next(), entrada.next(), entrada.nextInt());
                        contatos.add(amigo);
                    } else if (tipoContato == 2) {
                        Familia familiar = new Familia(entrada.next(), entrada.next(), entrada.next(), entrada.next(), entrada.next());
                        contatos.add(familiar);
                    } else if (tipoContato == 3) {
                        ColegasDeTrabalho colega = new ColegasDeTrabalho(entrada.next(), entrada.next(), entrada.next(), entrada.next(), entrada.next());
                        contatos.add(colega);
                    }
                    break;
                case 2:
                    for (Contato contato : contatos){
                        System.out.println(contato.imprimirContato());
                    }
                    break;
                case 3:
                    for (Contato contato : contatos){
                        if (contato instanceof Familia) {
                            System.out.println(contato.imprimirContato());
                        }
                    }
                    break;
                case 4:
                    for (Contato contato : contatos){
                        if (contato instanceof Amigo) {
                            System.out.println(contato.imprimirContato());
                        }
                    }
                    break;
                case 5:
                    for (Contato contato : contatos){
                        if (contato instanceof ColegasDeTrabalho) {
                            System.out.println(contato.imprimirContato());
                        }
                    }
                    break;
                case 6:
                    for (Contato contato : contatos){
                        if (contato instanceof Amigo) {
                            if (((Amigo) contato).grau == 1){
                            System.out.println(contato.imprimirContato());
                            }
                        }
                        if (contato instanceof Familia){
                            if (((Familia) contato).parentesco.equals(("irmão"))){
                                System.out.println(contato.imprimirContato());
                            }
                        }
                        if (contato instanceof ColegasDeTrabalho){
                            if (((ColegasDeTrabalho) contato).tipo.equals(("colega"))){
                                System.out.println(contato.imprimirContato());
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println(contatos.get(entrada.nextInt() - 1).imprimirContato());
                    break;
            }
            if (menu == 8) break;
        }
    }
}