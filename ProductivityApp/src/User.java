import java.util.Hashtable;

public class User {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private Hashtable<String, Task> taskList= new Hashtable<String, Task>();

    /**
     * New User
     * @param username Username of this User
     * @param firstname First name of this User
     * @param lastname Last name of this User
     * @param email Email of this User
     * @param password Password of this User
     */
    public User(String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    /**
     * Method getting the username of this User
     * @return Username of this User
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method getting the first name of this User
     * @return Firstname of this User
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Method getting the last name of this User
     * @return Lastname of this User
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Method getting the email of this User
     * @return Email of this User
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method getting the password of this User
     * @return Password of this User
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method meant for testing purposes. Checks if the task exists for this user
     * @param taskId Id of the task
     * @return boolean, whether task exists or not
     */
    public boolean taskExists(String taskId){
        return taskList.containsKey(taskId);
    }

    //Inner class Task. It is a part/composition of the User.
    public class Task {
        String title;
        String description;
        String time;

        private Hashtable<String, Subtask> subtaskList= new Hashtable<String, Subtask>();

        /**
         * New Task
         * @param title Title of this Task
         * @param description Description of this Task
         * @param time Time of this Task
         */
        public Task(String title, String description, String time) {
            this.title = title;
            this.description = description;
            this.time = time;

            create_a_Task();
        }

        /**
         * Method getting the title of this Task
         * @return Title of this Task
         */
        public String getTitle() {
            return title;
        }

        /**
         * Method getting the description of this Task
         * @return Description of this Task
         */
        public String getDescription() {
            return description;
        }

        /**
         * Method getting the time of this Task
         * @return Time of this Task
         */
        public String getTime() {
            return time;
        }

        /**
         * Shows a list of tasks of the User. Method prints the information about each task one after another.
         */
        public void Show_list_of_Tasks(){
            for(String task:User.this.taskList.keySet()){
                System.out.println(User.this.taskList.get(task));
            }
        }

        /**
         * Creates a new Task. Method puts a new Task in a hashtable, distinguished by the task id
         */
        public void create_a_Task(){
            if(User.this.taskList.containsKey(getTitle())){
                System.err.println("Task already exists...");
            }
            else{
                User.this.taskList.put(getTitle(),this);
            }
        }

        /**
         * Removes a Task. Method removes a Task from a hashtable, distinguished by the task id
         */
        public void remove_a_Task(){
            if(!User.this.taskList.containsKey(getTitle())){
                System.err.println("Task doesn't exist...");
            }
            else {
                User.this.taskList.remove(getTitle());
            }
        }

        /**
         * Method shows the information that the Task has started
         */
        public void start_a_Task(){
            System.out.println("Task has started! Remaining time: "+getTime());
        }

        @Override
        public String toString() {
            return "Title: "+getTitle()+"\n"+
                    "Description: "+getDescription()+"\n"+
                    "Time: "+getTime()+"\n"+
                    "\n";
        }

        /**
         * Method meant for testing purposes. Checks if the subtask exists for this task
         * @param subtaskId Id of the subtask
         * @return boolean, whether subtask exists or not
         */
        public boolean subtaskExists(String subtaskId){
            return subtaskList.containsKey(subtaskId);
        }


        //Inner class Subtask. It is a part/composition of the Task.
        public class Subtask {
            String title;
            String description;

            /**
             * New Subtask
             * @param title Title of this Subtask
             * @param description Description of this Subtask
             */
            public Subtask(String title, String description) {
                this.title = title;
                this.description = description;

                create_a_Subtask();
            }

            /**
             * Method getting the title of this Subtask
             * @return Title of this Subtask
             */
            public String getTitle() {
                return title;
            }

            /**
             * Method getting the description of this Subtask
             * @return Description of this Subtask
             */
            public String getDescription() {
                return description;
            }

            /**
             * Creates a new Task. Method puts a new Task in a hashtable, distinguished by the task id
             */
            public void create_a_Subtask(){
                if(Task.this.subtaskList.containsKey(getTitle())){
                    System.err.println("Subtask already exists...");
                }
                else{
                    Task.this.subtaskList.put(getTitle(),this);
                }
            }

            /**
             * Removes a Task. Method removes a Task from a hashtable, distinguished by the task id
             */
            public void remove_a_Subtask(){
                if(!Task.this.subtaskList.containsKey(getTitle())){
                    System.err.println("Subtask doesn't exist...");
                }
                else {
                    Task.this.subtaskList.remove(getTitle());
                }
            }

        }
    }
}
