(ns bob
(:import org.apache.commons.lang3.StringUtils)
(:require [clojure.string :only [trim]])
)

(defn last_character [s]
  (if (empty? s)
    ""
    (nth s (dec (count s)))
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
  (let [last_char (last_character (trim s))]
    (= last_char "?")))

(defn response-for [s] 
  (cond 
    (and (yell? s ) (question? s) ) "Calm down, I know what I'm doing!"
    (and (yell? s ) ) "Whoa, chill out!"
    (question? s) "Sure."
    (= (trim s) "") "Fine. Be that way!" 
    :else "Whatever."
  ))


