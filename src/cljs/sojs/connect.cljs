(ns sojs.connect
  (:require [clojure.browser.repl :as repl]))

(.write js/document "<p>Hello from sojs.connect.</p>")

(repl/connect "http://localhost:9000/repl")
