(ns warehouse.application
  (:require [http.server.lifecycle]
            [integrant.core :as ig]
            [ring.logger :as logger]
            [warehouse.http :as http]))

(def config
  {:http/handler           {:routes   http/routes
                            :wrappers [logger/wrap-with-logger]}
   :http/server            {:port    8000
                            :handler (ig/ref :http/handler)}})

(defn create-system
  []
  (ig/init config))

(defn destroy-system
  [system]
  (ig/halt! system))

(defn -main
  []
  (create-system))
