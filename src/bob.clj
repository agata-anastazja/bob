(ns bob
  (:require [clojure.string :as str]))

(defn last_character [s]
  (if (empty? s)
    ""
    (str (nth s (dec (count s))))))

(defn getAllAlphabeticCharsAsString [s]
  (clojure.string/join
    ""
    (filter (fn [x] (Character/isLetter x)) s)))

(defn yell? [s]
  (let [alphabeticCharsString (getAllAlphabeticCharsAsString s)]
    (if (= alphabeticCharsString "") 
      false
      (= (str/upper-case alphabeticCharsString)
      alphabeticCharsString))))

(defn question? [s]
  (let [last_char (last_character (str/trim s))]
    (= last_char "?")))

(defn response-for [s] 
  (cond 
    (str/blank? s) "Fine. Be that way!" 
    (and (yell? s ) (question? s) ) "Calm down, I know what I'm doing!"
    (yell? s ) "Whoa, chill out!"
    (question? s) "Sure."
    :else "Whatever."
  ))


