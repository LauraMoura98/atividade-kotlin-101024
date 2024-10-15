fun main() {
    val loja = Loja()

    while (true) {
        println("\n**LOJINHA DO SR. ABU**")
        println("1. Cadastrar Produto")
        println("2. Alterar Produto")
        println("3. Excluir Produto")
        println("4. Adicionar Item à Venda")
        println("5. Finalizar Compra")
        println("6. Sair")

        when (readLine()?.toInt()) {
            1 -> {
                println("Código do produto:")
                val codigo = readLine()?.toInt() ?: 0
                println("Nome do produto:")
                val nome = readLine() ?: ""
                println("Valor unitário:")
                val valor = readLine()?.toDouble() ?: 0.0
                println("Tipo de unidade:")
                val unidade = readLine() ?: ""

                loja.cadastrarProduto(Produto(codigo, nome, valor, unidade))
            }
            2 -> {
                println("Código do produto a ser alterado:")
                val codigo = readLine()?.toInt() ?: 0
                println("Novo nome (ou deixe em branco):")
                val nome = readLine()
                println("Novo valor unitário (ou deixe em branco):")
                val valor = readLine()?.toDoubleOrNull()
                println("Novo tipo de unidade (ou deixe em branco):")
                val unidade = readLine()

                loja.alterarProduto(codigo, nome, valor, unidade)
            }
            3 -> {
                println("Código do produto a ser excluído:")
                val codigo = readLine()?.toInt() ?: 0
                loja.excluirProduto(codigo)
            }
            4 -> {
                println("Código do produto a ser vendido:")
                val codigo = readLine()?.toInt() ?: 0
                println("Quantidade:")
                val quantidade = readLine()?.toInt() ?: 0
                loja.adicionarItemVenda(codigo, quantidade)
            }
            5 -> {
                loja.finalizarCompra()
            }
            6 -> {
                println("Saindo...")
                break
            }
            else -> println("Opção inválida!")
        }
    }
}
