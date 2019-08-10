(ns user
  (:require [clojure.tools.namespace.repl :refer [refresh]]
            [warehouse.application :as application]))

(def ^:private system (atom nil))

(defn start!
  []
  (reset! system (application/create-system)))

(defn stop!
  []
  (swap! system (fn [s] (when s (application/destroy-system s) nil))))

(defn restart!
  []
  (stop!)
  (refresh :after 'user/start!))
