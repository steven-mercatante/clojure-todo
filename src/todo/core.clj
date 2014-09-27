(ns todo.core
  (:gen-class)
  (:require [clojure.data.json :as json]))


(def json-file (str (System/getProperty "user.dir") "/tasks.json"))


(defn load-tasks
  "Load tasks from JSON file into memory and convert to map"
  []
  (json/read-str (slurp json-file) :key-fn keyword))


(defn write-tasks
  "Write task list to JSON file"
  [tasks]
  (spit json-file (json/write-str tasks)))


(defn print-tasks
  "Print tasks in the list"
  [tasks [show-what?]]
  (println (str "show: " show-what?))
  (doseq [task tasks]
    (println (task :task))))


(defn add-task
  "Add a task to the list"
  [tasks [task]]
  (write-tasks (conj tasks {:task task :complete false})))


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
      "add" (add-task (load-tasks) args)
      "complete" (complete-task args)
      "delete" (delete-task args)
      "list" (print-tasks (load-tasks) args)
      (str "Unrecognized action: " action))))
