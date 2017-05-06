(ns clojure-katas.sine-angle
  (:require [clojure-katas.core :as core]))

(use 'clojure.contrib.math)

(defn cube [x] (* x x x ))

(defn find-sin [angle]
  (if (<= (abs angle) 0.1)
    angle
    (-  (* 3 (find-sin (/ angle 3.0)))  
        (* 4 (cube (find-sin (/ angle 3.0)))))
  )
)

(core/defproblem sine
  "The sine of an angle (specified in radians) can be computed
  by making use of the approximation sin x  x if x is sufficiently small,
  and the trigonometric identity:
    sin(r) = 3sin(r/3) -. 4sin^3(r/3)"
  [angle]
  (find-sin angle)
)
