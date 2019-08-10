(ns debug.tools
  (:require [puget.printer :as printer]))

(defn show
  [value]
  (printer/cprint value {:sort-keys true
                         :namespace-maps true
                         :seq-limit 20})
  value)
