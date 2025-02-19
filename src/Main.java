import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String username_admin = "admin";
        String password_admin = "admin";
        String usernameRegistered = "Leonardo";
        String passwordRegistered = "123";
        String username;
        String password;
        int escolhaSwitch;
        float saldoCommon = 2500;
        String mensagemLoginSuccessfull = """
                Bem-vindo ao South America Liba'$ Bank, %s, no que podemos te ajudar hoje?
                1- Consultar Saldo
                2- Receber valor
                3- Transferir valor
                4- Logout
                
                Digite qual a ação deseja realizar:
                """.formatted(usernameRegistered);



        Scanner leitorDeDados = new Scanner(System.in);

        System.out.println("Bem-vindo ao South America Liba'$ Bank, por favor digite seu usuário:");
        username = leitorDeDados.nextLine();

        System.out.println("Por favor digite sua senha:");
        password = leitorDeDados.nextLine();

        if (username.equals(usernameRegistered) && password.equals(passwordRegistered) || username.equals(username_admin) && password.equals(password_admin)) {
            do {
                System.out.println(mensagemLoginSuccessfull);
                escolhaSwitch = leitorDeDados.nextInt();

                switch (escolhaSwitch) {
                    case 1:
                        System.out.println("Você escolher verificar o seu saldo disponívevl.\n");

                        System.out.printf("O saldo atual é de R$ %.2f \n", saldoCommon);

                        break;

                    case 2:
                        System.out.println("Você escolheu receber um valor de alguem. \n");

                        System.out.println("Digite o valor a ser recebido:");

                        float valorRecebido = leitorDeDados.nextFloat();
                        leitorDeDados.nextLine();

                        saldoCommon += valorRecebido;

                        System.out.printf("Pagamento recebido! Seu saldo agora é de R$ %.2f\n", saldoCommon);

                        break;

                    case 3:
                        System.out.println("Você escolheu transferir um valor.");

                        System.out.println("Digite o valor a ser transferido: ");
                        float valorRetirado = leitorDeDados.nextFloat();
                        leitorDeDados.nextLine();
                        if ( valorRetirado > saldoCommon ){
                            System.out.println("Saldo insuficiente para realizar a transferência.");
                        } else {
                            saldoCommon -= valorRetirado;

                            System.out.println("Você escolheu transferir um valor.\n");
                            System.out.printf("Valor transferido! Seu saldo agora é de R$ %.2f", saldoCommon);
                        }
                        break;

                    case 4:
                        System.out.println("Você optou pelo logout.");
                        leitorDeDados.close();
                        return;
                }
            } while (escolhaSwitch != 4);

        }
        else {
            System.out.println("Nome de usuário ou senha incorretos. Tente novamente.");

        }
    }
}