import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class User extends Guest{
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private List<LaunchingTask> launchingTaskList= new ArrayList<>();
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
        super();
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
     * Method setting the username for this User
     * @param username New Username to be set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method setting the firstname for this User
     * @param firstname New Firstname to be set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Method setting the lastname for this User
     * @param lastname New Lastname to be set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Method setting the email for this User
     * @param email New email address to be set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method setting the password for this User
     * @param password New password to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method adding LaunchingTask the list of Launching Tasks
     * @param launchingTask New LaunchingTask to be added to the List
     */
    public void addLaunchingTask(LaunchingTask launchingTask){
        launchingTaskList.add(launchingTask);
    }

    /**
     * Method retrieving the LaunchingTask from the List
     * @param launchingTaskId LaunchingTask id distinguishing the desired LaunchingTask
     */
    public LaunchingTask getLaunchingTask(int launchingTaskId){
        return launchingTaskList.get(launchingTaskId);
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
        private String title;
        private String description;
        private String time;

        private LaunchingTask launchingTask;

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
         * Method setting the title of this Task
         * @param title New title to be set
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * Method setting the description of this Task
         * @param description New description to be set
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * Method setting the time of this Task
         * @param time New time to be set
         */
        public void setTime(String time) {
            this.time = time;
        }

        /**
         * Method getting the LaunchingTask of this Task
         * @return LaunchingTask of this Task
         */
        public LaunchingTask getLaunchingTask() {
            return launchingTask;
        }

        /**
         * Method setting the LaunchingTask of this Task
         * @param launchingTask New description to be set
         */
        public void setLaunchingTask(LaunchingTask launchingTask) {
            this.launchingTask = launchingTask;
        }

        /**
         * Shows a list of tasks of the User. Method prints the information about each task one after another.
         */
        public Hashtable<String, Task> Show_list_of_Tasks(){
            for(String task:User.this.taskList.keySet()){
                System.out.println(User.this.taskList.get(task));
            }
            return User.this.taskList;
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
         * Method shows the information that the Task has started
         */
        public String start_a_Task(){
            String str="Task has started! Remaining time: "+getTime();
            System.out.println(str);
            return str;
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
             * Method setting the title of this Subask
             * @param title New title to be set
             */
            public void setTitle(String title) {
                this.title = title;
            }

            /**
             * Method setting the description of this Subtask
             * @param description New description to be set
             */
            public void setDescription(String description) {
                this.description = description;
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

        }
    }
}
