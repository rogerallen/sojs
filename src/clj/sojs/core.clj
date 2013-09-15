(ns sojs.core
  (:use compojure.core)
  (:use overtone.live)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(definst humm [d 1.0 f 400]
  (* (env-gen (perc 0.1 d) :action FREE)
     (sin-osc f)))

(definst buzz [d 1.0 f 400]
  (* (env-gen (perc 0.1 d) :action FREE)
     (mix [(saw f) (saw (* 1.1 f))])))

(defn play-humm [d f]
  (humm d f))

;; dissonant buzz when a page is not found
(defn not-found-buzz []
  (buzz 0.25 350))

;; defroutes macro defines a function that chains individual route
;; functions together. The request map is passed to each function in
;; turn, until a non-nil response is returned.
(defroutes app-routes
  ; to serve document root address
  (GET "/" []
       (str "<p>Hello from compojure..</p>"
            "<p><a href=\"play.html\">Play a note Page.</a></p>"
            "<p><a href=\"simple.html\">Simple, Stupid Page.</a></p>"))

  ; will call this when we want to play
  (POST "/play"
        [duration frequency]
        (let [text (str "<p>Play!</p>"
                        "<p>Duration:" duration"</p>"
                        "<p>Frequency:" frequency "</p>")]
          (play-humm (read-string duration) (read-string frequency))
          ;;text
          (ring.util.response/redirect "/play.html")))

  ; to serve static pages saved in resources/public directory
  (route/resources "/")

  ; if page is not found
  (route/not-found (fn [_]
                     (not-found-buzz)
                     "Page not found")))

;; site function creates a handler suitable for a standard website,
;; adding a bunch of standard ring middleware to app-route:
(def handler
  (handler/site app-routes))

;; hum on startup
(play-humm 1.5 330)
