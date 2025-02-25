import java.util.*;

class Question {
    String question;
    String[] options;
    char correctAnswer;

    public Question(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(char answer) {
        return Character.toUpperCase(answer) == correctAnswer;
    }
}

public class QuizGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static int score = 0;

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        
        // Adding sample questions
        questions.add(new Question("What is the capital of France?", 
                    new String[]{"A. Berlin", "B. Paris", "C. Madrid", "D. Rome"}, 'B'));
        questions.add(new Question("Which planet is known as the Red Planet?", 
                    new String[]{"A. Earth", "B. Mars", "C. Jupiter", "D. Venus"}, 'B'));
        questions.add(new Question("Who developed Java?", 
                    new String[]{"A. James Gosling", "B. Dennis Ritchie", "C. Bjarne Stroustrup", "D. Guido van Rossum"}, 'A'));
        
        System.out.println("Welcome to the Quiz Game!");
        System.out.println("-------------------------");
        
        for (Question q : questions) {
            askQuestion(q);
        }
        
        System.out.println("\nQuiz Over! Your final score: " + score + "/" + questions.size());
        
        if (score == questions.size()) {
            System.out.println("Excellent! You're a genius!");
        } else if (score >= questions.size() / 2) {
            System.out.println("Good job! You did well.");
        } else {
            System.out.println("Better luck next time!");
        }
        
        scanner.close();
    }

    private static void askQuestion(Question q) {
        System.out.println("\n" + q.question);
        for (String option : q.options) {
            System.out.println(option);
        }

        System.out.print("Enter your answer (A/B/C/D): ");
        char answer = scanner.next().charAt(0);

        if (q.checkAnswer(answer)) {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Wrong! The correct answer was " + q.correctAnswer + "\n");
        }
    }
}