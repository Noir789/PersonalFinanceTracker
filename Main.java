import Controller.BudgetController;
import Model.BudgetTracker;
import View.BudgetView;

public class Main {
    public static void main(String[] args) {
        BudgetTracker model = new BudgetTracker();
        BudgetView view = new BudgetView();
        BudgetController controller = new BudgetController(model, view);
        controller.run();
    }
}