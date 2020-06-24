(ns bob
(:require [clojure.string :as str])
)

(defn last_character [s]
  (if (empty? s)
    ""
    (str (nth s (dec (count s))))
  ))

(defn getAllAlphabeticChars [s]
  (filter (fn [x] (Character/isLetter x)) s))

(defn yell? [s]
  (StringUtils/isAllUpperCase 
    (clojure.string/join 
      "" 
      (getAllAlphabeticChars s)))
)

(defn question? [s]
  (let [last_char (last_character (str/trim s))]
    (= last_char "?")))

(defn response-for [s] 
  (cond 
    (and (yell? s ) (question? s) ) "Calm down, I know what I'm doing!"
    (and (yell? s ) ) "Whoa, chill out!"
    (question? s) "Sure."
    (= (str/trim s) "") "Fine. Be that way!" 
    :else "Whatever."
  ))


