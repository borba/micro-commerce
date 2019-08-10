(ns user
  (:require [clojure.core.async :refer [<! go-loop timeout]]
            [clojure.tools.namespace.repl :refer [refresh refresh-all]]
            [warehouse.application :as application]
            [warehouse.config :refer [config]]))

(def system (atom nil))

(defn start
  "Starts the current development system."
  []
  (reset! system (application/create-system config)))

(defn stop
  "Shuts down and destroys the current development system."
  []
  (swap! system (fn [s] (when s (application/destroy-system s) nil))))

(defn restart
  []
  (stop)
  (refresh :after 'user/start))
