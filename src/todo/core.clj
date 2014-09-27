(ns todo.core
  (:gen-class))


(defn in?
  "true if seq contains elm.
  Thanks to j-g-faustus @ http://stackoverflow.com/a/3249777/155175"
  [seq elm]
  (some #(= elm %) seq))


(defn add-task
  "Add a task to the list"
  [task]
  (println (str "add task: " task)))


(defn list-tasks
  [show-all?]
  (if (in? ["true", "yes", "all"] show-all?)
    (println "show all tasks")
    (println "show pending tasks")))


(defn complete-task
  [task]
  (println (str "complete task: " task)))


(defn delete-task
  [task]
  (println (str "delete task: " task)))


(defn -main
  "The main entry point."
  [& args]
  (let [[action task] args]
    (case action
      "add" (add-task task)
      "complete" (complete-task task)
      "delete" (delete-task task)
      "list" (list-tasks task)
      (str "Unrecognized action: " action))))
