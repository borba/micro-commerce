(ns warehouse.http
  (:require [clojure.pprint :refer [pprint]]))

(def plain-text-header
  {"content-type" "text/plain"})

(defn greet
  [_req]
  {:status  200
   :headers plain-text-header
   :body    "Hello World!"})

(defn goodbye
  [_req]
  {:status  200
   :headers plain-text-header
   :body    "Goodbye Cruel World!"})

(defn not-found
  [_req]
  {:status  404
   :headers plain-text-header
   :body    "Page not found"})

(defn yo
  [{{:keys [name]} :route-params}]
  {:status 200
   :headers plain-text-header
   :body (str "Yo! " name "!")})

(defn dump
  [req]
  {:status 200
   :headers plain-text-header
   :body (with-out-str (pprint req))})

(def routes ["/" {""                  {:get greet}
                  "goodbye"           {:get goodbye}
                  "request"           {:get dump}
                  ["yo/" :name]       {:get yo}
                  ["calc/" :a "/" :op "/" :b] {:get dump}
                  true                not-found}])
