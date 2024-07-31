import java.util.*;

public class Quiz {
    Scanner sc = new Scanner(System.in);

    Map<Integer, Map<String, Object>> quizData = new HashMap<>();
    List<Integer> answerList = new ArrayList<>();


    public void initQuiz() {
        quizData.put(1, createQuestionData(2, 10, "1. Python에서 변수를 선언하는 방법은?",
                new ArrayList<>(Arrays.asList("var name", "name = value", "set name", "name == value"))));
        quizData.put(2, createQuestionData(1, 15, "2. Python에서 리스트(List)의 특징은 무엇인가요?",
                new ArrayList<>(Arrays.asList("순서가 있고 변경 가능하다", "중복된 값을 가질 수 없다", "원소를 추가하거나 삭제할 수 없다", "정렬된 상태로 유지된다"))));
        quizData.put(3, createQuestionData(1, 10, "3. Python에서 조건문을 작성하는 방법은?",
                new ArrayList<>(Arrays.asList("if-else", "for-in", "while", "def"))));
        quizData.put(4, createQuestionData(2, 5, "4. Python에서 함수를 정의하는 방법은?",
                new ArrayList<>(Arrays.asList("class", "def", "import", "return"))));
    }


    private Map<String, Object> createQuestionData(int answer, int score, String question, List<String> options) {
        Map<String, Object> data = new HashMap<>();
        data.put("answer", answer);
        data.put("score", score);
        data.put("question", question);
        data.put("options", options);
        return data;
    }


    public void askQuestion(int questionNumber) {
        Map<String, Object> questionData = quizData.get(questionNumber);
        System.out.println(questionData.get("question") + " (점수: " + questionData.get("score") + "점)");
        List<String> options = (List<String>) questionData.get("options");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
        System.out.print("-정답 : ");
        int num = sc.nextInt();
        answerList.add(num);
    }


    public void result() {
        int totalScore = 0;
        System.out.println("----- 결과 -----");
        System.out.print("응답한 내용 : ");
        totalScore = getTotalScore();
        System.out.println();
        System.out.println("당신 응답 합계: " + totalScore);
    }


    private int getTotalScore() {
        int totalScore = 0;
        for (int i = 0; i < answerList.size(); i++) {
            int questionNumber = i + 1;
            int userAnswer = answerList.get(i);
            Map<String, Object> questionData = quizData.get(questionNumber);
            int correctAnswer = (int) questionData.get("answer");
            int score = (int) questionData.get("score");
            System.out.print(questionNumber + "번 " + userAnswer + ", ");

            if (userAnswer == correctAnswer) {
                totalScore += score;
            }
        }
        return totalScore;
    }


    public void runQuiz() {
        initQuiz();
        for (int i = 1; i <= quizData.size(); i++) {
            askQuestion(i);
        }
        result();
    }


}
