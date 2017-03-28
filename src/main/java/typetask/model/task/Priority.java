package typetask.model.task;

import typetask.commons.exceptions.IllegalValueException;

//@@author A0144902L
/**
* Represents a Task's priority in TypeTask.
* Guarantees: immutable; is valid as declared in {@link #isValidPriority(String)}
*/
public class Priority {

    public static final String MESSAGE_PRIORITY_CONSTRAINTS = "Task priority level should only contain"
            + " the words Yes and No (case-insensitive) or the letters y(Y) and n(N)";
    
    public static final String HIGH_PRIORITY= "High priority";
    public static final String NO_PRIORITY = "No priority";
    public static final String PRIORITY_REGEX = "^(?:Yes|No|yes|YES|NO|no|y|n|Y|N)$";
    
    public final String value;
    public final String priority;

    /**
     * Validates given priority.
     *
     * @throws IllegalValueException if given priority level string is invalid.
     */
    public Priority(String priorityLevel) throws IllegalValueException {
        assert priorityLevel != null;

        String trimmedPriorityLevel = priorityLevel.trim();

        if ("".equals(priorityLevel)) {
            this.value = NO_PRIORITY ;
            this.priority = "No";
        } else {
            if (!isValidPriority(trimmedPriorityLevel)) {
                throw new IllegalValueException(MESSAGE_PRIORITY_CONSTRAINTS);
            }
            if (trimmedPriorityLevel.contains("y") || trimmedPriorityLevel.contains("Y")) {
                this.value = NO_PRIORITY ;
                this.priority = "Yes";
            } else {
                this.value = NO_PRIORITY ;
                this.priority = "No";
            }
        }
    }

    /**
     * Returns true if a given string is a valid task priority level.
     */
    public static boolean isValidPriority(String test) {
        return test.matches(PRIORITY_REGEX) ||
                "".equals(test);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Priority // instanceof handles nulls
                && this.value.equals(((Priority) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }
}
