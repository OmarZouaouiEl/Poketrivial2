
// GameScreen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GameScreen(navController: NavController, questions: List<TriviaQuestion>) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var userScore by remember { mutableStateOf(0) }

    if (currentQuestionIndex < questions.size) {
        GameQuestionCard(
            question = questions[currentQuestionIndex],
            onAnswerSelected = { userAnswer ->
                if (userAnswer == questions[currentQuestionIndex].correctAnswer) {
                    userScore++
                }
                currentQuestionIndex++
            }
        )
    } else {
        ResultScreen(navController = navController, userScore = userScore) {
            // Handle playing again, reset the state or navigate back to the menu
            currentQuestionIndex = 0
            navController.navigate(Routes.MenuScreen.route)
        }
    }
}

@Composable
fun GameQuestionCard(question: TriviaQuestion, onAnswerSelected: (String) -> Unit) {
    var selectedAnswer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = question.questionText,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
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
    Button(
        onClick = { onOptionSelected(option) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) {
                if (isCorrect) Color.Green else Color.Red
            } else {
                Color.Blue
            },
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