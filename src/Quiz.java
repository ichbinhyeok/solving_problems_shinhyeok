

import java.util.*;

public class Quiz {
    Scanner sc = new Scanner(System.in);


    Map<Integer, Map<String, Object>> quizData = new HashMap<>();
    List<Integer> answerList = new ArrayList<>();


    public void initAnswer() {

        Map<String, Object> q1Data = new HashMap<>();
        q1Data.put("answer", 2);
        q1Data.put("score", 10);
        quizData.put(1, q1Data);


        Map<String, Object> q2Data = new HashMap<>();
        q2Data.put("answer", 1);
        q2Data.put("score", 15);
        quizData.put(2, q2Data);


        Map<String, Object> q3Data = new HashMap<>();
        q3Data.put("answer", 1);
        q3Data.put("score", 10);
        quizData.put(3, q3Data);


        Map<String, Object> q4Data = new HashMap<>();
        q4Data.put("answer", 2);
        q4Data.put("score", 5);
        quizData.put(4, q4Data);
    }

    public void Q01() {
        System.out.println("1. Python에서 변수를 선언하는 방법은? (점수: 10점)");
        System.out.println("1) var name 2) name = value 3) set name 4) name == value");
        System.out.print("-정답 : ");
        int num = sc.nextInt();
        answerList.add(num);
    }

    public void Q02() {
        System.out.println("2. Python에서 리스트(List)의 특징은 무엇인가요? (점수: 15점)");
        System.out.println("1) 순서가 있고 변경 가능하다, 2) 중복된 값을 가질 수 없다, 3) 원소를 추가하거나 삭제할 수 없다, 4) 정렬된 \n" +
                "상태로 유지된다");
        System.out.print("-정답 : ");
        int num = sc.nextInt();
        answerList.add(num);
    }

    public void Q03() {
        System.out.println("3. Python에서 조건문을 작성하는 방법은? (점수: 10점)");
        System.out.println("1) if-else, 2) for-in, 3) while, 4) def");
        System.out.print("-정답 : ");
        int num = sc.nextInt();
        answerList.add(num);
    }

    public void Q04() {
        System.out.println("4. Python에서 함수를 정의하는 방법은? (점수: 5점)");
        System.out.println("1) class, 2) def, 3) import, 4) return");
        System.out.print("-정답 : ");
        int num = sc.nextInt();
        answerList.add(num);
    }

    public void result() {
        int totalScore = 0;
        System.out.println("----- 결과 -----");
        System.out.print("응답한 내용 : ");
        for (int i = 0; i < answerList.size(); i++) {
            int questionNumber = i + 1;
            int userAnswer = answerList.get(i);


            Map<String, Object> questionData = quizData.get(questionNumber);
            if (questionData != null) {
                int correctAnswer = (int) questionData.get("answer");
                int score = (int) questionData.get("score");

                System.out.print(questionNumber + "번 " + userAnswer + ", ");


                if (userAnswer == correctAnswer) {
                    totalScore += score;
                }
            }
        }
        System.out.println();
        System.out.println("당신 응답 합계: " + totalScore);
    }


}
