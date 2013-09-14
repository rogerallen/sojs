(defproject sojs "0.1.0-SNAPSHOT"
  :description "simple overtone & javascript test"
  :url "http://github.com/rogerallen/sojs"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj"]

  :dependencies [[org.clojure/clojure       "1.5.1"]
                 [org.clojure/clojurescript "0.0-1878"]
                 [compojure                 "1.1.5"]
                 [overtone "0.8.1" :exclusions [org.clojure/clojure
                                                org.clojure/data.json]]
                 ]

  ;; lein-cljsbuild plugin to build a CLJS project
  :plugins [[lein-cljsbuild "0.3.3"]
            [lein-ring "0.8.7"]]

  :ring {:handler sojs.core/handler}

  ;; cljsbuild options configuration
  :cljsbuild {:builds
              [{:source-paths ["src/cljs"]
                :compiler {:output-to     "resources/public/js/sojs.js"
                           :optimizations :whitespace
                           :pretty-print  true}}]})
