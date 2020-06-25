(ns armstrong)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn expBasedOnBaseAsString [intAsStr n]
  (exp (Integer/parseInt (nth intAsStr n)) (inc n))
)

(defn armstrong [n]
  (let intAsStr (str n)
    (loop [ index 0
            acc   0]
      (if (= index (count intAsStr))
        0
        (recur  (inc index) 
                (+ acc (exp (Integer/parseInt (nth intAsStr index)) (inc index) ))) 
      )
    )
  )
)