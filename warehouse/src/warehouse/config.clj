(ns warehouse.config
  (:require [integrant.core :as ig]
            [warehouse.core :as core]
            [http.server.lifecycle]))

(def config
  {:http/handler {:routes core/routes}
   :http/server {:port 8000
                 :handler (ig/ref :http/handler)}})
