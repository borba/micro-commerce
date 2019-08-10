(ns http.server.lifecycle
  (:require [aleph.http :as http]
            [aleph.netty :as netty]
            [bidi.ring :refer [make-handler]]
            [integrant.core :as ig]
            [ring.middleware.reload :refer [wrap-reload]]))

(defmethod ig/init-key :http/handler
  [_ {:keys [routes]}]
  (make-handler routes))

(defmethod ig/init-key :http/server
  [_ {:keys [handler] :as opts}]
  (http/start-server handler (dissoc opts :handler)))

(defmethod ig/halt-key! :http/server
  [_ server]
  (.close server)
  (netty/wait-for-close server))
