package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int id;

    public static void main(String[] args) {


        List<WiseSaying> wsList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");


        while (true) {

            System.out.print("명령) ");
            String command = sc.nextLine(); // 입력값 받기

            if (command.equals("등록")) {
                addWiseSaying(wsList);
            } else if (command.equals("종료")) {
                System.out.println("== 명언 앱이 종료되었습니다 ==");
                break;
            } else if (command.equals("목록")) {
                printWiseSaying(wsList);
            } else if (command.contains("삭제")) {
                removeWiseSaying(wsList, Integer.parseInt(command.split("=")[1]));
            } else if (command.contains("수정")) {
                revisionWiseSaying(wsList, Integer.parseInt(command.split("=")[1]));
            }
        }

    }

    // 명언 등록 메서드
    static void addWiseSaying(List<WiseSaying> wsList) {
        Scanner sc = new Scanner(System.in);

        System.out.print("명언: ");
        String content = sc.nextLine();
        System.out.print("작가: ");
        String author = sc.nextLine();

        wsList.add(new WiseSaying(++id, content, author));

        System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
    }

    // 명언 목록 메서드
    static void printWiseSaying(List<WiseSaying> wsList) {
        System.out.println("번호 / 작가 / 명언\n----------------------");

        for (WiseSaying ws : wsList) {
            System.out.println(ws);
        }
    }

    // 명언 삭제 메서드
    static void removeWiseSaying(List<WiseSaying> wsList, int id) {

        for (WiseSaying ws : wsList) {
            if (ws.getId() == id) {
                wsList.remove(ws);
                System.out.println(id + "번 명언이 삭제되었습니다.");
                return;
            }
        }
        System.out.println(id + "번 명언은 존재하지 않습니다.");
    }

    // 명언 수정 메서드
    static void revisionWiseSaying(List<WiseSaying> wsList, int id) {
        for (WiseSaying ws : wsList) {
            if (ws.getId() == id) {
                Scanner sc = new Scanner(System.in);

                System.out.println("명언(기존): " + ws.getContent());
                System.out.print("멍언");

                ws.revisionContent(sc.nextLine());
                System.out.println("작가(기존): " + ws.getAuthor());
                System.out.print("작가");
                ws.revisionAuthor(sc.nextLine());

                System.out.println(id + "번 명언이 수정되었습니다.");
                return;
            }
        }
        System.out.println(id + "번 명언은 존재하지 않습니다.");
    }
}
