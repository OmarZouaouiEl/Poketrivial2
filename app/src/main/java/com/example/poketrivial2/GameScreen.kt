
// GameScreen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.contentColorFor
import com.example.poketrivia.Difficulty
import com.example.poketrivial2.Questions
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

// Convierte el enum class en una lista de TriviaQuestion
val triviaQuestionsList: List<TriviaQuestion> = Questions.values().map { it.question }



@Composable
fun GameScreen(navController: NavController, selectedDifficulty: Difficulty) {
    var questions by remember { mutableStateOf(getRandomUniqueQuestions(emptyList())) }
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var userScore by remember { mutableStateOf(0) }
    var timeLeft by remember { mutableStateOf(60) }
println( "hola")
    if (currentQuestionIndex < questions.size && timeLeft > 0) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            GameQuestionCard(
                question = questions[currentQuestionIndex],
                onAnswerSelected = { userAnswer ->
                    if (userAnswer == questions[currentQuestionIndex].correctAnswer) {
                        userScore++
                    }
                    currentQuestionIndex++
                    timeLeft = 60
                },
                isAnswerCorrect = false // Puedes cambiar esto según la lógica de tu juego
            )

            // TimeProgressBar
            TimeProgressBar(timeLeft = timeLeft.toFloat())
        }
    } else {
        navController.navigate(Routes.ResultScreen.route) {
            // Configura los argumentos de ResultScreen aquí si es necesario
            // Ejemplo: launchSingleTop = true
        }
    }
}

// Método para obtener preguntas únicas y aleatorias
fun getRandomUniqueQuestions(usedQuestions: List<TriviaQuestion>): List<TriviaQuestion> {
    val remainingQuestions = triviaQuestionsList.toMutableList()
    remainingQuestions.removeAll(usedQuestions)
    return (0 until minOf(remainingQuestions.size, 10)).map {
        remainingQuestions.random()
    }
}




@Composable
fun TimeProgressBar(timeLeft: Float) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val contentColor = contentColorFor(primaryColor)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .border(1.dp, primaryColor, CircleShape)
    ) {
        val progress = remember(timeLeft) { timeLeft.coerceIn(0f, 60f) / 60f }

        Box(
            modifier = Modifier
                .fillMaxSize(progress)
                .background(contentColor)
        )
    }
}


@Composable
fun GameQuestionCard(question: TriviaQuestion,  onAnswerSelected: (String) -> Unit, isAnswerCorrect: Boolean) {
    var selectedAnswer by remember { mutableStateOf("") }

    val textColor = if (isAnswerCorrect) Color.Green else Color.Red

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = question.questionText,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = question.imageUrl),
            contentDescription = "Question Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = MaterialTheme.shapes.medium)
        )

        Spacer(modifier = Modifier.height(16.dp))

        question.options.forEach { option ->
            GameOptionButton(
                option = option,
                isSelected = option == selectedAnswer,
                onOptionSelected = {
                    selectedAnswer = it
                    onAnswerSelected(it)
                },
                isCorrect = option == question.correctAnswer
            )
        }
    }
}


@Composable
fun GameOptionButton(option: String, isSelected: Boolean, onOptionSelected: (String) -> Unit, isCorrect: Boolean) {
    val buttonBackgroundColor = if (isSelected) {
        if (isCorrect) Color.Green else Color.Red
    } else {
        Color.Black
    }

    Button(
        onClick = { onOptionSelected(option) },
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonBackgroundColor,
            contentColor = if (isSelected) Color.White else Color.Red
        ),
        border = BorderStroke(5.dp, Color.Green),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = option)
    }
}
