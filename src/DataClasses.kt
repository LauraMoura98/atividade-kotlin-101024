data class Produto(
    val codigo: Int,
    var nome: String,
    var valorUnitario: Double,
    var tipoUnidade: String
)

data class ItemVenda(
    val produto: Produto,
    var quantidade: Int
)