(ns warehouse.application
  (:require [integrant.core :as ig]
            [warehouse.config :refer [config]]))

(defn create-system
  [config]
  (ig/init config))

(defn destroy-system
  [system]
  (ig/halt! system))

(defn -main
  []
  (create-system config))
