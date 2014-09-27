(ns todo.core
  (:gen-class)
  (:require [clojure.data.json :as json]))


(defn load-tasks
  "Load tasks from JSON file into memory and convert to map"
  []
  (let [json-file (str (System/getProperty "user.dir") "/tasks.json")]
    (json/read-str(slurp json-file) :key-fn keyword)))


(defn print-tasks
  [tasks [show-what?]]
  (println (str "show: " show-what?))
  (doseq [task tasks]
    (println (task :task))))


(defn add-task
  "Add a task to the list"
  [[task]]
  (println (str "add task: " task)))


(defn complete-task
  "Mark a task as complete"
  [[task]]
  (println (str "complete task: " task)))


(defn delete-task
  "Remove a task from the list"
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
      "list" (print-tasks (load-tasks) args)
      (str "Unrecognized action: " action))))
