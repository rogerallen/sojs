(ns sojs.core
  (:use compojure.core)
  (:use overtone.live)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

;; humm nicely on startup
(defn demo-humm []
  (demo 1.5 (* (sin-osc (/ (* 2 1.5))) (sin-osc [330 330]))))

;; ???
(defn found-humm []
  (demo 0.25 (* (sin-osc (/ (* 2 0.25))) (sin-osc [440 440]))))

;; dissonant buzz when a page is not found
(defn not-found-buzz []
  (demo 0.25 (* (sin-osc (/ (* 2 0.25))) (saw [397 880]))))

;; defroutes macro defines a function that chains individual route
;; functions together. The request map is passed to each function in
;; turn, until a non-nil response is returned.
(defroutes app-routes
  ; to serve document root address
  (GET "/" [] "<p>Hello from compojure.  Hummm...</p>")

  ; to serve static pages saved in resources/public directory
  (route/resources "/")

  ; if page is not found
  (route/not-found (fn [_
]
                     (not-found-buzz)
                     "Page not found")))

;; site function creates a handler suitable for a standard website,
;; adding a bunch of standard ring middleware to app-route:
(def handler
  (handler/site app-routes))

(demo-humm)
