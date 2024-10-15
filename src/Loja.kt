class Loja {
    private val produtos = mutableListOf<Produto>()
    private val carrinho = mutableListOf<ItemVenda>()


    fun cadastrarProduto(produto: Produto) {
        produtos.add(produto)
        println("Produto ${produto.nome} cadastrado com sucesso!")
    }


    fun alterarProduto(codigo: Int, nome: String?, valorUnitario: Double?, tipoUnidade: String?) {
        val produto = produtos.find { it.codigo == codigo }
        if (produto != null) {
            nome?.let { produto.nome = it }
            valorUnitario?.let { produto.valorUnitario = it }
            tipoUnidade?.let { produto.tipoUnidade = it }
            println("Produto alterado com sucesso!")
        } else {
            println("Produto não encontrado!")
        }
    }


    fun excluirProduto(codigo: Int) {
        produtos.removeIf { it.codigo == codigo }
        println("Produto excluído com sucesso!")
    }


    fun adicionarItemVenda(codigo: Int, quantidade: Int) {
        val produto = produtos.find { it.codigo == codigo }
        if (produto != null) {
            carrinho.add(ItemVenda(produto, quantidade))
            println("Item ${produto.nome} adicionado ao carrinho.")
        } else {
            println("Produto não encontrado!")
        }
    }


    fun finalizarCompra() {
        if (carrinho.isEmpty()) {
            println("Carrinho está vazio!")
            return
        }

        val total = carrinho.sumOf { it.produto.valorUnitario * it.quantidade }
        println("Total da compra: R$%.2f".format(total))
        escolherFormaPagamento(total)
    }


    private fun escolherFormaPagamento(total: Double) {
        println("Escolha a forma de pagamento:")
        println("1. Pix")
        println("2. Cartão (Crédito/Débito)")
        println("3. Dinheiro")

        when (readLine()?.toInt()) {
            1 -> pagamentoPix()
            2 -> pagamentoCartao()
            3 -> pagamentoDinheiro(total)
            else -> println("Opção inválida!")
        }
    }

    private fun pagamentoPix() {
        println("Código Pix: 123456789")
        println("Pagamento realizado com Pix.")
    }

    private fun pagamentoCartao() {
        println("Informe os dados do cartão:")
        println("Número do cartão:")
        val numeroCartao = readLine()
        println("Nome no cartão:")
        val nomeCartao = readLine()
        println("Pagamento realizado com sucesso via cartão.")
    }

    private fun pagamentoDinheiro(total: Double) {
        println("Informe o valor pago:")
        val valorPago = readLine()?.toDoubleOrNull()
        if (valorPago != null && valorPago >= total) {
            val troco = valorPago - total
            println("Pagamento realizado. Troco: R$%.2f".format(troco))
        } else {
            println("Valor insuficiente!")
        }
    }
}