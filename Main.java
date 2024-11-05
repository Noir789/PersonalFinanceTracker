import Controller.BudgetController;
import View.BudgetView;

public class Main {
    public static void main(String[] args) {
        BudgetView view = new BudgetView();
        BudgetController controller = new BudgetController( view);
        controller.run();
    }
}