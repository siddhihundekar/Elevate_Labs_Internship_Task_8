package task_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    private List<Question> questions = new ArrayList<>();
    private List<Question> wrongQuestions = new ArrayList<>();
    private int score = 0;
    private Scanner sc = new Scanner(System.in);

    public Quiz() {
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question(
                "Which of the following is not a Java feature?",
                "A. Object-oriented",
                "B. Portable",
                "C. Dynamic",
                "D. Pointer usage",
                'D'
        ));

        questions.add(new Question(
                "Which keyword is used to create a subclass in Java?",
                "A. super",
                "B. this",
                "C. extends",
                "D. final",
                'C'
        ));

        questions.add(new Question(
                "Which company originally developed Java?",
                "A. Sun Microsystems",
                "B. Microsoft",
                "C. Google",
                "D. IBM",
                'A'
        ));

        questions.add(new Question(
                "What is JVM in Java?",
                "A. Java Variable Machine",
                "B. Java Virtual Machine",
                "C. Java Visual Model",
                "D. Java Version Manager",
                'B'
        ));

        questions.add(new Question(
                "Which symbol is used for single-line comments in Java?",
                "A. /*",
                "B. //",
                "C. #",
                "D. <>",
                'B'
        ));
    }

    public void startQuiz() {
        System.out.println("\n====================================");
        System.out.println("        📘 Java Online Quiz");
        System.out.println("====================================");

        for (Question q : questions) {
            askQuestion(q);
        }

        showResults();
    }

    private void askQuestion(Question q) {

        System.out.println("\n------------------------------------");
        System.out.println(q.getQuestion());
        System.out.println(q.getOptionA());
        System.out.println(q.getOptionB());
        System.out.println(q.getOptionC());
        System.out.println(q.getOptionD());
        System.out.println("------------------------------------");

        long start = System.currentTimeMillis();
        System.out.print("Your Answer (A/B/C/D): ");
        String input = sc.nextLine().trim().toUpperCase();
        long end = System.currentTimeMillis();

        if (input.length() != 1) {
            System.out.println("Invalid Input! Correct answer was: " + q.getCorrectAnswer());
            wrongQuestions.add(q);
            return;
        }

        char answer = input.charAt(0);

        if (end - start > 10000) {
            System.out.println("⏳ Time Up! Correct answer was: " + q.getCorrectAnswer());
            wrongQuestions.add(q);
            return;
        }

        if (answer == q.getCorrectAnswer()) {
            System.out.println("✔ Correct!");
            score++;
        } else {
            System.out.println("❌ Wrong! Correct answer: " + q.getCorrectAnswer());
            wrongQuestions.add(q);
        }
    }

    private void showResults() {
        System.out.println("\n====================================");
        System.out.println("              RESULTS");
        System.out.println("====================================");
        System.out.println("✔ Total Questions: " + questions.size());
        System.out.println("✔ Correct Answers: " + score);
        System.out.println("✔ Wrong Answers: " + wrongQuestions.size());

        double percentage = (score * 100.0) / questions.size();
        System.out.println("✔ Percentage: " + percentage + "%");

        if (!wrongQuestions.isEmpty()) {
            System.out.println("\n❌ Questions you got wrong:");
            for (Question q : wrongQuestions) {
                System.out.println("- " + q.getQuestion());
            }
        }

        System.out.println("\n🎉 Thank you for playing the Quiz!");
        generateCertificate(percentage);
    }
    
    private void generateCertificate(double percentage) {
        System.out.println("\n====================================");
        System.out.println("         🎓 QUIZ CERTIFICATE 🎓");
        System.out.println("====================================");
        System.out.println("This certificate is awarded to:");
        System.out.println("\n        ⭐  " + System.getProperty("user.name").toUpperCase() + "  ⭐\n");
        System.out.println("For successfully completing the Java Quiz");
        System.out.println("with a score of " + percentage + "%.");
        
        if (percentage >= 80) {
            System.out.println("\n🏆 Performance: Excellent");
        } else if (percentage >= 60) {
            System.out.println("\n🏅 Performance: Good");
        } else if (percentage >= 40) {
            System.out.println("\n🎖 Performance: Average");
        } else {
            System.out.println("\n📘 Performance: Needs Improvement");
        }

        System.out.println("\nKeep Learning • Keep Growing 🚀");
        System.out.println("====================================\n");
    }


}
