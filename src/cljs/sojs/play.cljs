(ns sojs.play)

(.write js/document "<p>Hello from sojs.play.</p>")

;; define the function to be attached to form submission event
(defn validate-form []
  ;; get duration and frequency
  (let [duration-str (.getElementById js/document "duration")
        frequency-str (.getElementById js/document "frequency")]
    (if (and (> (count (.-value duration-str)) 0)
             (> (count (.-value frequency-str)) 0))
      ;;(let [duration (cljs.reader/read-string duration-str)
      ;;      frequency (cljs.reader/read-string frequency-str)]
      ;;(if (and (> (float duration-str) 0.0) (< (float duration-str) 10.0))
      ;;  (if (and (> frequency-str 30.0) (< frequency-str 3000.0))
      ;;    true
      ;;    (do (js/alert "Please use frequency value 30.0 < v < 3000.0")
      ;;        false))
      ;;  (do (js/alert "Please use duration value 0.0 < v < 10.0")
      ;;      false));)
      true
      (do (js/alert "Please, complete the form!")
          false))))


;; define the function to attach validate-form to onsubmit event of
;; the form
(defn init []
  ;; verify that js/document exists and that it has a getElementById
  ;; property
  ;;(.write js/document "<p>Hello from sojs.play/init.</p>")
  (if (and js/document
           (.-getElementById js/document))
    ;; get playForm by element id and set its onsubmit property to
    ;; our validate-form function
    (let [play-form (.getElementById js/document "playForm")]
      (set! (.-onsubmit play-form) validate-form))))

;; initialize the HTML page in unobtrusive way
(set! (.-onload js/window) init)
