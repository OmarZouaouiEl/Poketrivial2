package com.example.poketrivial2

import TriviaQuestion


enum class Questions(val question: TriviaQuestion) {
    QUESTION_1(
        TriviaQuestion(
            "Which Pokémon has the highest base HP stat as of Generation 8?",
            R.drawable.question1,
            listOf("Blissey", "Chansey", "Wobbuffet", "Lugia"),
            "Blissey",
            Difficulty.EASY
        )
    ),
    QUESTION_2(
        TriviaQuestion(
            "What is the signature move of the Pokémon Aegislash in its Shield Form?",
            R.drawable.question2,
            listOf("Sacred Sword", "King's Shield", "Shadow Sneak", "Iron Head"),
            "King's Shield",
            Difficulty.EASY
        )
    ),
    QUESTION_3(
        TriviaQuestion(
            "Name three Pokémon that have the ability to change their form during battle.",
            R.drawable.question3,
            listOf("Giratina", "Shaymin", "Darmanitan", "Castform"),
            "Giratina, Shaymin, Darmanitan",
            Difficulty.MEDIUM
        )
    ),
    QUESTION_4(
        TriviaQuestion(
            "In competitive Pokémon battling, what does the term 'Evasion Clause' refer to?",
            R.drawable.question4,
            listOf(
                "A rule against boosting evasion stats",
                "A strategy involving evasive moves",
                "A ban on using items to boost evasion",
                "A clause in Pokémon contracts"
            ),
            "A rule against boosting evasion stats",
            Difficulty.MEDIUM
        )
    ),
    QUESTION_5(
        TriviaQuestion(
            "Which move allows a Pokémon to copy its opponent's last used move and type?",
            R.drawable.question5,
            listOf("Mimic", "Copycat", "Mirror Move", "Sketch"),
            "Sketch",
            Difficulty.MEDIUM
        )
    ),
    QUESTION_6(
        TriviaQuestion(
            "What is the only Pokémon with the ability 'Parental Bond' as of Generation 8?",
            R.drawable.question6,
            listOf("Kangaskhan", "Lopunny", "Azumarill", "Kecleon"),
            "Kangaskhan",
            Difficulty.MEDIUM
        )
    ),
    QUESTION_7(
        TriviaQuestion(
            "Which move ignores the target's ability and always results in a critical hit?",
            R.drawable.question7,
            listOf("Aerial Ace", "Storm Throw", "Frost Breath", "Psycho Cut"),
            "Storm Throw",
            Difficulty.MEDIUM
        )
    ),
    QUESTION_8(
        TriviaQuestion(
            "In the VGC (Video Game Championships), what is the maximum number of Pokémon a player can bring to a battle but only use two during the actual match?",
            R.drawable.question8,
            listOf("3", "4", "6", "2"),
            "4",
            Difficulty.HARD
        )
    ),
    QUESTION_9(
        TriviaQuestion(
            "Name three Pokémon that have the ability to Mega Evolve and share a base stat total of 700.",
            R.drawable.question9,
            listOf("Mega Charizard X", "Mega Alakazam", "Mega Blastoise", "Mega Tyranitar"),
            "Mega Charizard X, Mega Alakazam, Mega Blastoise",
            Difficulty.HARD
        )
    ),
    QUESTION_10(
        TriviaQuestion(
            "Which ability boosts the power of a Pokémon's moves when its HP is below one-third of its maximum?",
            R.drawable.question10,
            listOf("Guts", "Overgrow", "Torrent", "Rattled"),
            "Guts",
            Difficulty.HARD
        )
    ),
    QUESTION_11(
        TriviaQuestion(
            "What is the base power of the move 'Foul Play' determined by?",
            R.drawable.question11,
            listOf(
                "User's Attack stat",
                "User's Defense stat",
                "Opponent's Attack stat",
                "Opponent's Defense stat"
            ),
            "Opponent's Attack stat",
            Difficulty.HARD
        )
    ),
    QUESTION_12(
        TriviaQuestion(
            "Which move has the biggest chance of always moving first, regardless of Speed?",
            R.drawable.question12,
            listOf("Quick Attack", "Extreme Speed", "Mach Punch", "Bullet Punch"),
            "Extreme Speed",
            Difficulty.HARD
        )
    ),
    QUESTION_13(
        TriviaQuestion(
            "In Pokémon Black and White, what is the only type of move that causes the move 'Weather Ball' to change its type?",
            R.drawable.question13,
            listOf("Water", "Fire", "Ice", "Electric"),
            "Water",
            Difficulty.EASY
        )
    ),
    QUESTION_14(
        TriviaQuestion(
            "Which Pokémon has the highest base Speed stat as of Generation 8?",
            R.drawable.question14,
            listOf("Deoxys (Speed Forme)", "Ninjask", "Accelgor", "Jolteon"),
            "Deoxys (Speed Forme)",
            Difficulty.MEDIUM
        )
    ),
    QUESTION_15(
        TriviaQuestion(
            "Which Pokémon was NOT in Ash's team in the world cup final?",
            R.drawable.question15,
            listOf("Sirfetch'd", "Lucario", "Greninja", "Dracovish"),
            "Greninja",
            Difficulty.MEDIUM
        )
    ),
    QUESTION_16(
        TriviaQuestion(
            "What is the effect of the move 'Trick Room' on the turn it is used?",
            R.drawable.question16,
            listOf(
                "Switching priorities",
                "Lowering the foe's attack by 2 stages",
                "protect from status changes",
                "All the above"
            ),
            "Switching Priorities",
            Difficulty.MEDIUM
        )
    ),
    QUESTION_17(
        TriviaQuestion(
            "What is Ash's most important battle?",
            R.drawable.question17,
            listOf(
                "World cup final vs Leon",
                "World cup semifinal vs Cintia",
                "Sinnoh league quarterfinals vs Paul",
                "Vs professor Kukui final alola Battle"
            ),
            "World cup final vs Leon",
            Difficulty.MEDIUM
        )
    ),
    QUESTION_18(
        TriviaQuestion(
            "What was team rocket's objective?",
            R.drawable.question18,
            listOf("Dominate the world", "Catch Pikachu", "Train Ash", "Win Contests"),
            "Dominate the world",
            Difficulty.MEDIUM
        )
    ),
    QUESTION_19(
        TriviaQuestion(
            "How many episodes does the pokemon anime have?",
            R.drawable.question19,
            listOf("128", "65", "962", "1270"),
            "1270",
            Difficulty.MEDIUM
        )
    ),
    QUESTION_20(
        TriviaQuestion(
            "Who is The actual world champion (goat) of pokemon?",
            R.drawable.question20,
            listOf("Wolfey Glick", "Sea Jun Park", "Red", "Ash Ketchum"),
            "Ash Ketchum",
            Difficulty.MEDIUM
        )
    ),
}