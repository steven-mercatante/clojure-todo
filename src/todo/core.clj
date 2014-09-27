(ns todo.core
  (:gen-class))


(defn in?
  "true if seq contains elm.
  Thanks to j-g-faustus @ http://stackoverflow.com/a/3249777/155175"
  [seq elm]
  (some #(= elm %) seq))


(defn add-task
  "Add a task to the list"
  [[task & args]]
  (println (str "add task: " task)))


(defn list-tasks
  [[show-all? & args]]
  (if (in? ["true", "yes", "all"] show-all?)
    (println "show all tasks")
    (println "show pending tasks")))


(defn complete-task
  [[task & args]]
  (println (str "complete task: " task)))


(defn delete-task
  [[task & args]]
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
