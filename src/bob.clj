(ns bob
  (:require [clojure.string :as str]))

(defn last_character [s]
    (str/ends-with? (str/trimr s) "?"))

(defn yell? [s]
  (some? (re-matches #"[^a-z]*[A-Z][^a-z]*" s)))

(defn question? [s]
  (str/ends-with? (str/trimr s) "?"))

(defn response-for [s] 
  ( let [isYelling (yell? s) isAsking (question? s)]
    (cond 
      (str/blank? s)            "Fine. Be that way!" 
      (and isYelling isAsking)  "Calm down, I know what I'm doing!"
      isYelling                 "Whoa, chill out!"
      isAsking                  "Sure."
      :else                     "Whatever."
  )))
  


