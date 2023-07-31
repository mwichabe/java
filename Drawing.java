import java.util.Stack;

class Action {
    String type;

    Action(String type) {
        this.type = type;
    }
}

public class Drawing {
    private static Stack<Action> undo = new Stack<>();
    private static Stack<Action> redo = new Stack<>();

    // Add an action to the undo stack
    public static void addActionToUndo(Action action) {
        undo.push(action);
    }

    // Remove the most recent action from the undo stack and add it to the redo stack
    public static void undoAction() {
        if (!undo.isEmpty()) {
            Action recentAction = undo.pop();
            System.out.println("Undo Action: " + recentAction.type);
            redo.push(recentAction);
        }
    }

    // Remove the most recent action from the redo stack and add it to the undo stack
    public static void redoAction() {
        if (!redo.isEmpty()) {
            Action recentAction = redo.pop();
            System.out.println("Redo Action: " + recentAction.type);
            undo.push(recentAction);
        }
    }

    // Print the most recent action without removing it from the undo stack
    public static void printLastUndoAction() {
        if (!undo.isEmpty()) {
            Action recentAction = undo.peek();
            System.out.println("Most Recent Undo Action: " + recentAction.type);
        } else {
            System.out.println("Undo stack is empty.");
        }
    }

    public static void main(String[] args) {
        Action drawAction = new Action("draw");
        Action moveAction = new Action("move");
        Action resizeAction = new Action("resize");
        
        undo.push(drawAction);
        undo.push(moveAction);
        undo.push(resizeAction);

        // Perform undo and redo operations
        undoAction();
        redoAction();

        // Print the most recent action without removing it from the undo stack
        printLastUndoAction();
    
    }
}
