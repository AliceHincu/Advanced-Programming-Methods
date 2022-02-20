import controller.Controller;
import repository.Repository;
import repository.RepositoryInterface;
import view.UI;

public class Main {

    public static void main(String[] args) {
        RepositoryInterface repo = new Repository();
        Controller controller = new Controller(repo);
        UI ui = new UI(controller);
        ui.run();
    }
}
