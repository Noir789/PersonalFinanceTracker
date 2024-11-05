Expense Tracker Project Documentation
1. Overview of the System Architecture
The Expense Tracker Application is designed to allow users to track their incomes, expenses, and balances. The application follows the MVC (Model-View-Controller) architectural pattern to separate concerns and improve maintainability. Additionally, several design patterns (Singleton, Factory, Decorator, Facade, Observer, and Strategy) are integrated to address specific requirements, improve code flexibility, and enhance user experience.

Key Components:
Model Layer: Manages the core logic and data. It consists of classes that represent transactions (Income, Expense) and the budget tracking logic.
View Layer: Provides an interface for user interaction. It captures inputs and displays outputs but does not manage data or business logic.
Controller Layer: Coordinates user inputs, updates the model, and refreshes the view. It manages the application’s main logic and flow.
2. Explanation of Design Patterns
This project incorporates various design patterns to promote reusability, flexibility, and scalability.

Creational Patterns
Singleton Pattern: Implemented in the BudgetTracker class to ensure that only one instance of the budget tracker exists throughout the application. This allows centralized management of transactions and balance data.

Factory Method Pattern: Used in IncomeFactory and ExpenseFactory classes to create instances of Income and Expense. This promotes flexibility by allowing new transaction types to be added without modifying the main logic.

Structural Patterns
Decorator Pattern: Applied to add custom properties to transactions (e.g., marking them as high-value or recurring). This pattern allows for extending transaction behavior without altering the Transaction base class.

Facade Pattern: The BudgetFacade class provides a simplified interface to core functionalities (adding income, adding expense, viewing balance). It encapsulates complex logic, making the controller’s interaction with the model more straightforward.

Behavioral Patterns
Observer Pattern: Used to notify registered observers (e.g., LowBalanceAlert, NegativeBalanceAlert) whenever the balance changes. This pattern supports user alerts when the balance crosses specific thresholds.

Strategy Pattern: Implemented to allow different balance calculation and reporting strategies, like SimpleBalanceStrategy, ProjectedBalanceStrategy, and CategorySummaryStrategy. Users can choose how they want their balance reported based on specific needs.

3. UML Diagrams
Below are the UML diagrams illustrating the structure and interactions of each pattern.

1. Class Diagram for MVC Architecture
The UML class diagram below represents the separation of concerns between the Model, View, and Controller.

sql
Копировать код
                           +------------------+
                           |   BudgetView     |
                           |  (View Layer)    |
                           +--------+---------+
                                    |
                                    |  User Input & Display
                                    |
                           +--------v---------+
                           | BudgetController |
                           |  (Controller)    |
                           +--------+---------+
                                    |
               +--------------------+-------------------+
               |                                        |
      Transaction Creation (Factory)            Core Operations (Facade)
               |                                        |
       +-------v--------+                   +-----------v----------+
       |  Transaction   |                   |    BudgetFacade      |
       |  Factories     |                   |   (Facade Pattern)   |
       +-------+--------+                   +-----------+----------+
               |                                        |
  +------------v------------+                 +---------v---------+
  |     IncomeFactory       |                 |   BudgetTracker   |
  |     ExpenseFactory      |                 | (Singleton Model) |
  +------------+------------+                 +---------+---------+
               |                                        |
               +-------------------+---------------------------+
                                   |
                                   |
                     +-------------v-------------+
                     |  Transaction Decorators   |
                     |  (Decorator Pattern)      |
                     +-------------+-------------+
                                   |
2. Sequence Diagram for Observer Pattern
This sequence diagram shows the interactions for balance alerts. When a transaction is added, the BudgetTracker notifies observers if the balance crosses the defined thresholds.

scss
Копировать код
User       --> BudgetController      --> BudgetTracker      --> BalanceObserver
             addTransaction()
                                             |
                                   notifyObservers()
                                                     | update()
                                               LowBalanceAlert/NegativeBalanceAlert
3. Class Diagram for Strategy Pattern
This diagram represents the BalanceStrategy interface and the concrete strategies (SimpleBalanceStrategy, ProjectedBalanceStrategy, and CategorySummaryStrategy). The BudgetController selects a strategy based on user input.

4. Usage Instructions
Setting Up the Project
Clone or download the project source code.
Ensure you have a compatible Java Development Kit (JDK) installed.
Compile the project classes.
Running the Application
Start the application by running the main method in the BudgetController.
Follow the on-screen prompts to add incomes and expenses.
Choose the balance reporting strategy based on your preference (e.g., simple balance or category-based summary).
Feature Overview
Adding Income/Expense: Enter descriptions and amounts for each transaction.
Viewing Balance: Check the balance and choose between different reporting strategies.
Balance Alerts: Receive notifications if the balance falls below defined thresholds.
Transaction Tags: High-value and recurring transactions are tagged accordingly.
5. Assumptions and Limitations
Assumptions
All users have a single, centralized budget.
Thresholds for alerts (e.g., $100 for low balance) are predefined but can be adjusted in the code.
Income and expense projections used in the ProjectedBalanceStrategy are constants set in code.
Limitations
Currently, there is no persistence for transactions. All data is lost when the application is closed.
No graphical user interface (GUI) is implemented; interactions are through the console.
Additional features, like transaction categories or user-defined alerts, would require further development.
