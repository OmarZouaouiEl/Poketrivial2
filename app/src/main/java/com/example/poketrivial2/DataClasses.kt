
// Data classes and enums go here
data class TriviaQuestion(
    val questionText: String,
    val imageUrl: Int,
    val options: List<String>,
    val correctAnswer: String,
    val medium: Difficulty
)

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}
