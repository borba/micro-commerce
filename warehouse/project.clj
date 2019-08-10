(defproject warehouse "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :plugins [[lein-ancient "0.6.15"]
            [lein-nsorg "0.3.0"]]

  :dependencies [[org.clojure/clojure "1.10.1"]

                 [aleph "0.4.7-alpha5"]
                 [bidi "2.1.6"]
                 [integrant "0.7.0"]
                 [ring "1.7.1"]
                 [ring-logger "1.0.1"]]

  :injections [(require '[debug.tools :refer :all]
                        '[user :refer :all])]

  :main warehouse.application

  :profiles {:dev {:source-paths ["dev"]
                   :main user/start!
                   :dependencies [[org.clojure/tools.namespace "0.3.1"]
                                  [mvxcvi/puget "1.1.2"]]}})