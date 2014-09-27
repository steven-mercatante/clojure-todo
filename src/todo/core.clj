(ns todo.core
  (:gen-class))


(defn add-task
  "Add a task to the list"
  [[task]]
  (println (str "add task: " task)))


(defn list-tasks
  [[list-what?]]
  (case list-what?
    "all" (println "list all tasks")
    "completed" (println "list completed tasks")
    ("pending" nil) (println "list pending tasks")
    (println (str "Unrecognized value: " list-what?))))


(defn complete-task
  [[task]]
  (println (str "complete task: " task)))


(defn delete-task
  [[task]]
  (println (str "delete task: " task)))


(defn -main
  "The main entry point."
  [& args]
  (let [[action & args] args]
    (case action
      "add" (add-task args)
      "complete" (complete-task args)
      "delete" (delete-task args)
      "list" (list-tasks args)
      (str "Unrecognized action: " action))))
