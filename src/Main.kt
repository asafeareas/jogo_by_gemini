import kotlin.random.Random

fun main() {
    println("Bem-vindo ao Jogo de Pedra, Papel e Tesoura!")

    while (true) {
        println("Escolha sua jogada:")
        println("1 - Pedra")
        println("2 - Papel")
        println("3 - Tesoura")
        println("4 - Sair")

        val jogadaJogador = readLine()?.toIntOrNull()

        if (jogadaJogador == null || jogadaJogador !in 1..4) {
            println("Entrada inválida. Por favor, escolha uma opção válida.")
            continue
        }

        if (jogadaJogador == 4) {
            println("Obrigado por jogar!")
            break
        }

        val jogadaComputador = Random.nextInt(1, 4) // Gera um número aleatório entre 1 e 3

        println("Você jogou: ${getJogada(jogadaJogador)}")
        println("Computador jogou: ${getJogada(jogadaComputador)}")

        val resultado = determinarVencedor(jogadaJogador, jogadaComputador)

        println(resultado)

        println("--------------------------------------")
    }
}

fun getJogada(jogada: Int): String {
    return when (jogada) {
        1 -> "Pedra"
        2 -> "Papel"
        3 -> "Tesoura"
        else -> "Opção inválida"
    }
}

fun determinarVencedor(jogadaJogador: Int, jogadaComputador: Int): String {
    if (jogadaJogador == jogadaComputador) {
        return "Empate!"
    } else if (
        (jogadaJogador == 1 && jogadaComputador == 3) ||
        (jogadaJogador == 2 && jogadaComputador == 1) ||
        (jogadaJogador == 3 && jogadaComputador == 2)
    ) {
        return "Você venceu!"
    } else {
        return "Computador venceu!"
    }
}

// Explicação do código:

//main() função:

//Imprime uma mensagem de boas-vindas.
//Entra em um loop while (true) que continua até o jogador escolher sair.
//Imprime as opções para o jogador: Pedra, Papel, Tesoura, Sair.
//Lê a entrada do jogador usando readLine()?.toIntOrNull().
//Valida a entrada para garantir que seja um número inteiro válido entre 1 e 4.
//Se a entrada for inválida, imprime uma mensagem de erro e continua para a próxima iteração do loop.
//Se o jogador escolher sair (opção 4), imprime uma mensagem de despedida e sai do loop usando break.
//Gera uma jogada aleatória para o computador usando Random.nextInt(1, 4).
//Imprime as jogadas do jogador e do computador usando a função getJogada().
//Determina o vencedor usando a função determinarVencedor().
//Imprime o resultado da partida.

//getJogada() função:

//Recebe um inteiro que representa a jogada (1, 2 ou 3).
//Retorna uma string correspondente à jogada (Pedra, Papel ou Tesoura).
//Se a entrada for inválida, retorna "Opção inválida".

//determinarVencedor() função:

//Recebe as jogadas do jogador e do computador.
//Verifica se houve empate (jogadas iguais).
//Verifica se o jogador venceu (Pedra vs Tesoura, Papel vs Pedra, Tesoura vs Papel).
//Se não for empate nem vitória do jogador, o computador vence.
//Retorna uma string indicando o resultado (Empate!, Você venceu!, Computador venceu!).