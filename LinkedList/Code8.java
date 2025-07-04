class TextState {
    String content;
    TextState next, prev;

    TextState(String content) {
        this.content = content;
    }
}

class TextEditor {
    TextState head, tail, current;
    int size = 0;
    final int MAX_HISTORY = 10;

    void type(String newText) {
        TextState newState = new TextState(newText);
        if (current != null) {
            current.next = null;
        }
        newState.prev = current;
        if (current != null) {
            current.next = newState;
        } else {
            head = newState;
        }
        current = newState;
        tail = newState;
        size++;

        if (size > MAX_HISTORY) {
            head = head.next;
            if (head != null) head.prev = null;
            size--;
        }
    }

    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo available.");
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo available.");
        }
    }

    void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("Editor is empty.");
        }
    }
}

 class Code8 {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.type("Hello");
        editor.type("Hello, World");
        editor.type("Hello, World!");
        editor.displayCurrentState();
        System.out.println("-- Undo --");
        editor.undo();
        editor.displayCurrentState();
        System.out.println("-- Undo --");
        editor.undo();
        editor.displayCurrentState();
        System.out.println("-- Redo --");
        editor.redo();
        editor.displayCurrentState();
        System.out.println("-- New Input --");
        editor.type("New content after undo");
        editor.displayCurrentState();
    }
}
