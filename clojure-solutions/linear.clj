(defn vector_function [operation] (fn [a, b] (mapv operation a b)))

(def v+ (vector_function +))
(def v* (vector_function *))
(def v- (vector_function -))
(def vd (vector_function /))

(defn v*s [v1, s] (mapv (partial * s) v1))
(defn scalar [v1, v2] (apply + (v* v1 v2)))

(defn vect [[x1 x2 x3] [y1 y2 y3]]
    [(- (* x2 y3) (* x3 y2))
     (- (* x3 y1) (* x1 y3))
     (- (* x1 y2) (* x2 y1))])

(def transpose (fn [vv] (apply mapv vector vv)))

(defn m*s [vv, s] (mapv (fn [x] (v*s x s)) vv))
(defn m*v [vv, v] (mapv (fn [x] (scalar x v)) vv))
(defn m*m [vv1, vv2] (mapv (fn [vv1] (mapv (fn [vv2] (scalar vv1 vv2)) (transpose vv2))) vv1))

(def m+ (vector_function v+))
(def m- (vector_function v-))
(def m* (vector_function v*))
(def md (vector_function vd))

(def c+ (vector_function m+))
(def c- (vector_function m-))
(def c* (vector_function m*))
(def cd (vector_function md))

(defn -main
  [& args]
  ;; (def v1 (vector 1 2 3))
  ;; (def v2 (vector 1 5 7))
  ;; (def m1 [[1 2 3] [1 2 3] [1 2 3]])
  ;; (def m2 [[2 3 4] [5 6 7] [8 9 10]])

  ;; (println (m- m1 m2))
  ;; (println (m+ m1 m2))
  ;; (println (m* m1 m2))
  ;; (println (md m1 m2))

  ;; (println (m*m m1 m2))
  ;; (println (c+ [[[1] [2]] [[3] [4]]] [[[5] [6]] [[7] [8]]]))
  )