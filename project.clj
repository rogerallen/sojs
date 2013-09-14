(defproject sojs "0.1.0-SNAPSHOT"
  :description "simple overtone & javascript test"
  :url "http://github.com/rogerallen/sojs"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj"]

  :dependencies [[org.clojure/clojure       "1.5.1"]
                 [org.clojure/clojurescript "0.0-1878"]
                 [compojure                 "1.1.5"]
                 ;; was not able to get python -m SimpleHTTPServer to do brepl
                 ;; ? https://groups.google.com/forum/#!topic/clojurescript/lPbE2qA7AFw
                 ;; [org.clojure/google-closure-library-third-party "0.0-2029"]
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
