import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	private Scanner sc;

	public App(Scanner sc) {
		this.sc = sc;
	}

	public void run() {

		System.out.println("== 명언 앱 실행 ==");

		List<WiseSaying> wiseSayings = new ArrayList<>();
		int lastId = 0;

		while (true) {
			System.out.print("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("종료")) {
				System.out.println("== 명언 앱 종료 ==");
				break;
			} else if (cmd.equals("등록")) {
				int id = lastId + 1;
				System.out.print("명언 : ");
				String content = sc.nextLine().trim();
				System.out.print("작가 : ");
				String author = sc.nextLine().trim();
				wiseSayings.add(new WiseSaying(id, content, author));
				System.out.printf("%d번 명언이 등록되었습니다.\n", id);
				lastId++;
			} else if (cmd.equals("목록")) {
				if (wiseSayings.size() == 0) {
					System.out.println("등록된 명언이 없습니다.");
				} else {
					System.out.println("번호  |  작가    |  명언  ");
					for (int i = 0; i < wiseSayings.size(); i++) {
						System.out.printf("%d | %s | %s \n", wiseSayings.get(i).getId(), wiseSayings.get(i).getAuthor(),
								wiseSayings.get(i).getContent());
					}
				}
			} else {
				System.out.println("존재하지 않는 명령어입니다.");
			}
		}
	}
}
