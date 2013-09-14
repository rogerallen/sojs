(ns sojs.connect
  (:require [clojure.browser.repl :as repl]))

(.write js/document "Hello, ClojureScript! from sojs.connect.")

(repl/connect "http://localhost:9000/repl")
