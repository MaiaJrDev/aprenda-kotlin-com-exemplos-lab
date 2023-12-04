enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val name: String, val age: Int, email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuarios: List<Usuario>) {
        for (usuario in usuarios) {
            inscritos.add(usuario)
            println("Usuário ${usuario.name} matriculado com sucesso!")
        }
        println("Quantidade de usuarios matriculados para a formação $nome : ${inscritos.size}")
    }
}

fun main() {
    val firstContent = ConteudoEducacional("kotlin", nivel = Nivel.BASICO)
    val secondContent = ConteudoEducacional("JavaScript", 80, Nivel.INTERMEDIARIO)
    val thirdContent = ConteudoEducacional("Java", 120, Nivel.AVANCADO)
    val formacao = Formacao("Desenvolvedor Master", listOf(firstContent, secondContent, thirdContent))
    
    val user1 = Usuario("Roberto Maia", 29, "roberto@dio.me")
    val user2 = Usuario("Vanderlei", 34, "van@dio.me")
    val user3 = Usuario("Josefa", 19, "jose@dio.me")
    formacao.matricular(listOf(user1, user2, user3))
    println(formacao.inscritos)
}