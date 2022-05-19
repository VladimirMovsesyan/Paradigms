(defn v+ [x y]
    (map + x y)
)

(defn v- [x y]
    (map - x y)
)

(defn v* [x y]
    (map * x y)
)

(defn vd [x y]
    (map / x y)
)

(defn sqr [x]
    (* x x)
)

(defn sum [x]
    (apply + x)
)

(defn len [x]
    (Math/sqrt (sum (map sqr x)))
)

(defn scalar [x y]
    (def cos (/ (sum (v* x y)) (* (len x) (len y))))
    (* (len x) (len y) cos)
)

(defn vect [x y]
    (list (- (* (nth x 1) (nth y 2)) (* (nth x 2) (nth y 1))) (- (* (nth x 2) (nth y 0)) (* (nth x 0) (nth y 2))) (- (* (nth x 0) (nth y 1)) (* (nth x 1) (nth y 0))))
)

(defn v*s [x y]
    (for [i x]
    (* i y))
)

(defn m+ [x y]
    (letfn [(getsum [x y]
        (cond 
            (vector? (nth x 0)) (map getsum x y)
            :else (v+ x y)
        )
    )]
    (getsum x y))
)

(defn m- [x y]
    (letfn [(getsubtract [x y]
        (cond 
            (vector? (nth x 0)) (map getsubtract x y)
            :else (v- x y)
        )
    )]
    (getsubtract x y))
)

(defn m* [x y]
    (letfn [(getmult [x y]
        (cond 
            (vector? (nth x 0)) (map getmult x y)
            :else (v* x y)
        )
    )]
    (getmult x y))
)

(defn md [x y]
    (letfn [(getdiv [x y]
        (cond 
            (vector? (nth x 0)) (map getdiv x y)
            :else (vd x y)
        ))]
    
    (getdiv x y))
)

(defn m*s [x y]
    (letfn [(getmultscalar [x y]
        (cond
            (vector? (nth (nth x 0) 0)) (for [i x] (getmultscalar i y))
            :else (for [i x] (v*s i y))
        ))]
    (getmultscalar x y))
)

(defn m*v [x y]
    (for [i x]
        (sum (v* i y))
    )
)

(defn transpose [x]
  (apply mapv vector x))

(defn m*m [x y]
    (letfn [(matrixmult [x y]
        (for [i x]
            (m*v y i)
        )
    )]
    (matrixmult x (transpose y)))
)

;; (println (md [[1 2][3 4]] [[1 2][3 4]]))